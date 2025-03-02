package com.example.attendanceapp.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.models.TimetableView

class RecyclerAdapter(val list: List<TimetableView>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var parent: ViewGroup


    private val ITEM_TYPE = 1
    private val PROGRESS_TYPE = 2

    var isLoading = false

    inner class ItemsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvPeriod : TextView =itemView.findViewById(R.id.tvPeriod)
        val tvStart : TextView =itemView.findViewById(R.id.tvStart)
        val tvEnd : TextView =itemView.findViewById(R.id.tvEnd)
        val tvSubject : TextView =itemView.findViewById(R.id.tvSubject)
        val tvFaculty : TextView =itemView.findViewById(R.id.tvFaculty)
    }

    inner class ProgressViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        this.parent = parent
        return if(viewType == ITEM_TYPE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.timetable_card,parent,false)
            ItemsViewHolder(view)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.progress_card,parent,false)
            ProgressViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoading && position == list.size) {
            PROGRESS_TYPE
        } else
            ITEM_TYPE
    }

    override fun getItemCount(): Int {
        return  if (isLoading) {
            list.size + 1
        } else
            list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemsViewHolder) {
            val item = list[position]
            holder.tvPeriod.text = item.period
            holder.tvStart.text = item.start
            holder.tvEnd.text = item.end
            holder.tvSubject.text = item.subject_name
            holder.tvFaculty.text = item.instruct_name


        }
    }

}