package com.example.projecttestkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = Person(resources.getString(R.string.person_name), 7)
        val personOutput: TextView = findViewById(R.id.person_output)
        val btnDataClass: Button = findViewById(R.id.btn_data_class)
        btnDataClass.setOnClickListener {
            personOutput.text = person.toString()
        }

        val copyClassOutput: TextView = findViewById(R.id.copy_class_output)
        val btnCopyClass: Button = findViewById(R.id.btn_copy_class)
        btnCopyClass.setOnClickListener {
            val copyClass: Person = person.copy()
            copyClassOutput.text = copyClass.toString()
        }

        val btnCycles: Button = findViewById(R.id.btn_cycles)
        btnCycles.setOnClickListener {
            val arrListName = arrayListOf<String>(*resources.getStringArray(R.array.person_names))

            val nameList = arrayListOf(
                Person(arrListName[0], 1),
                Person(arrListName[1], 2),
                Person(arrListName[2], 3),
                Person(arrListName[3], 4),
            )
            println("____")
            println("«..»")
            for (i in 0..3) {
                println(nameList[i].name)
            }
            println("____")
            println("downTo:")
            for (i in nameList.size - 1 downTo 0) {
                println(nameList[i].name)
            }

            println("____")
            println("until:")
            for (i in 0 until 3) {
                println(nameList[i].name)
            }
            println("____")
            println("forEach:")
            nameList.forEach {
                println(it.name + it.id)
            }
            println("____")
            println("indices:")
            for (i in nameList.indices) {
                println(nameList[i])
            }


        }
    }
}
