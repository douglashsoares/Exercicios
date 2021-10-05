package com.douglas.exercicios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.exercicios.databinding.FragmentHomeBinding
import com.douglas.exercicios.databinding.FragmentListBinding
import com.douglas.exercicios.models.Task


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    val tasksList = ArrayList<Task>()
    val tasksAdapter = TasksAdapter(tasksList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcTask.adapter = tasksAdapter

        binding.btnAddTask.setOnClickListener{
            val taskText = binding.edtTask.text.toString()
            val task = Task(taskText)

            tasksList.add(task)

            tasksAdapter.notifyDataSetChanged()


        }

    }

}