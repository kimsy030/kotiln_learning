package com.example.dbtest_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val result_text = findViewById<TextView>(R.id.result_text)
        val edit = findViewById<EditText>(R.id.edit)

        // db 연결
        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "database"
        ).allowMainThreadQueries().build()

        // db에 저장된 데이터 불러오기
        db.dao().getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()

        })

        // 글을 쓰고 버튼을 누르면 db에 저장
        button.setOnClickListener{
            db.dao().insert(Entity(edit.text.toString()))
        }

    }

}