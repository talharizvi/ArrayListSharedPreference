package com.example.talha.arraylistsharedprefrence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.gson.Gson

class MainActivity:AppCompatActivity() {

    var list = ArrayList<PersonData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.btn1)
        var person = PersonData("Max",24)
        var person1 = PersonData("Roy",25)
        var person2 = PersonData("Jenny",26)
        list.add(person)
        list.add(person1)
        list.add(person2)
        var gson = Gson()
        var json:String = gson.toJson(list)
        var sharedPreferences:SharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("key",json)
        editor.apply()

        button.setOnClickListener {
            var i = Intent(this,ActivityTest::class.java)
            startActivity(i)
        }
    }


}