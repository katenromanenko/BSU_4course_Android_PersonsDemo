package com.example.personsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val persons = mutableListOf<Person>()
    lateinit var recuclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persons.add(Person("Join", "Smith", 45, R.drawable.p1))
        persons.add(Person("Ivan", "Petrov", 27, R.drawable.p2))
        persons.add(Person("Petr", "Lenoff", 28, R.drawable.p3))
        persons.add(Person("Vasya", "Pupkin", 40, R.drawable.p4))

        recuclerView = findViewById(R.id.recuclerView)

        recuclerView.adapter = PersonAdapter(persons,this)
        //recuclerView.layoutManager = GridLayoutManager(this, 2)
        recuclerView.layoutManager = LinearLayoutManager(this)

        val btnAdd = findViewById<Button>(R.id.buttonAdd)
        btnAdd.setOnClickListener{
            persons.add(Person("newName", "newSecondName", 36, R.drawable.p6))
            recuclerView.adapter?.notifyItemInserted(persons.lastIndex)
        }


    }
    fun onItemClick(position: Int) {
        Toast.makeText(this, "Hello, ${persons[position].name}", Toast.LENGTH_SHORT).show()
    }
    fun onItemDeleted(position: Int){
        persons.removeAt(position)
        recuclerView.adapter?.notifyItemRemoved(position)
    }

}