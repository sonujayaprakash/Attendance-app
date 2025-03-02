package com.example.attendanceapp



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class Registration : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etCollegeId: EditText
    private lateinit var etPassword: EditText
    private lateinit var etReEnterPassword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnRead: Button
    private lateinit var login:TextView

    private val db: UserDatabase by lazy {
        UserDatabase.getDatabase(this)
    }
    private val userDAO: UserDAO by lazy {
        db.userDAO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        login=findViewById(R.id.loginbtn)

        // Initialize views after setting the layout
        initializeViews()

        // Handle window insets for immersive UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Regbtn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Button click listener
        btnSubmit.setOnClickListener {
            lifecycleScope.launch {
                if (!checkAllFields()) {
                    Toast.makeText(applicationContext, "Please enter all relevant fields", Toast.LENGTH_SHORT).show()
                } else {
                    userDAO.insertUser(
                        User(
                            firstName = etFirstName.text.toString(),
                            lastName = etLastName.text.toString(),
                            email = etEmail.text.toString(),
                            college_id = etCollegeId.text.toString(),
                            password = etPassword.text.toString()
                        )
                    )
                    Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG).show()
                }
            }
        }

//        btnRead.setOnClickListener {
//            readUsers()
//        }

        login.setOnClickListener{
            val intenthome=Intent(this,Home::class.java)
            startActivity(intenthome)
        }
    }

    private fun initializeViews() {
        etFirstName = findViewById(R.id.first_name)
        etLastName = findViewById(R.id.last_name)
        etEmail = findViewById(R.id.email)
        etCollegeId = findViewById(R.id.collegeid)
        etPassword = findViewById(R.id.password)
        etReEnterPassword = findViewById(R.id.reenter_password)
        btnSubmit = findViewById(R.id.submit)
    }

//    private fun readUsers() {
//        lifecycleScope.launch {
//            val data = userDAO.getUsers()
//            data.forEach {
//                Toast.makeText(applicationContext, "User: ${it.firstName}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    private fun checkAllFields(): Boolean {
        var isValid = true
        if (etFirstName.text.toString().isEmpty()) {
            etFirstName.error = "Enter first name"
            isValid = false
        }
        if (etLastName.text.toString().isEmpty()) {
            etLastName.error = "Enter last name"
            isValid = false
        }
        if (etEmail.text.toString().isEmpty()) {
            etEmail.error = "Enter email"
            isValid = false
        }
        if (etCollegeId.text.toString().isEmpty()) {
            etCollegeId.error = "Enter college ID"
            isValid = false
        }
        return isValid
    }
}
