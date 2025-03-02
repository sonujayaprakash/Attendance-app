package com.example.attendanceapp.adapters



import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.attendanceapp.MainActivity

class ViewPagerAdapterStudent(fragmentnActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentnActivity){

    val fragments = mutableListOf<Fragment>()
    val fragmentTitles = mutableListOf<String>()

    fun addFragment(fragment: Fragment, title:String){
        fragments.add(fragment)
        fragmentTitles.add(title)
    }
    fun getPageTitle(position: Int): String {
        return fragmentTitles[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return  fragments[position]
    }
}