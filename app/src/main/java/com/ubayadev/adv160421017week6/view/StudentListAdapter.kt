package com.ubayadev.adv160421017week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubayadev.adv160421017week6.databinding.StudentCardBinding
import com.ubayadev.adv160421017week6.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(var binding: StudentCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):StudentViewHolder {
        val binding = StudentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.txtID.text = "ID : " + studentList[position].id
        holder.binding.txtName.text = studentList[position].name

        var url=studentList[position].images
        var builder= Picasso.Builder(holder.itemView.context)
        builder.listener{picasso, uri, exception->exception.printStackTrace()}
        builder.build().load(url).into(holder.binding.imgProfil)

        holder.binding.btnDetail.setOnClickListener {
            println(studentList[position].id)
            val action = FragmentListDirections.actionFragmentListToFragmentDetail(studentList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun getItemCount(): Int {
        return studentList.size
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

}
