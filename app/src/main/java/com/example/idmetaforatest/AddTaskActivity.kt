package com.example.idmetaforatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.idmetaforatest.ViewModel.ListTaskViewModel
import com.example.idmetaforatest.ViewModel.TaskViewModelFactory
import com.example.idmetaforatest.databinding.ActivityAddTaskBinding
import com.example.idmetaforatest.db.DataUser

class AddTaskActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding : ActivityAddTaskBinding
    private lateinit var taskViewModel: ListTaskViewModel

    private var result : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        val viewModelFactory = TaskViewModelFactory(this)
        taskViewModel = ViewModelProvider(this,viewModelFactory)[ListTaskViewModel::class.java]
        setContentView(binding.root)

        dropDownMenu()
        val dataIntent = intent.getParcelableExtra<DataUser>("data")
        Toast.makeText(this, "${dataIntent?.id_user}", Toast.LENGTH_SHORT).show()
        if(dataIntent != null){ submitData(dataIntent.id_user) }
    }


    // Set DropDownMenu
    private fun dropDownMenu(){
        val data = resources.getStringArray(R.array.status)
        val adapter = ArrayAdapter(this,R.layout.dropdown_task,data)
        with(binding.tvStatus){
            setAdapter(adapter)
            onItemClickListener = this@AddTaskActivity
        }
    }

    // Set DropDown Menu OnClick
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        result = item
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()


    }


    private fun submitData(idUser : Int?){
        binding.add.setOnClickListener {
            if (idUser != null) {

                try {
                    taskViewModel.addTask(
                        binding.etTask.text.toString(),
                        result,
                        idUser
                    )

                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java).also { finish() })
                }catch (e : Exception){
                    Toast.makeText(this, "Error ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}