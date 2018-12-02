package com.example.talha.arraylistsharedprefrence

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ActivityTest:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var name=findViewById<TextView>(R.id.tv_name)
        var age = findViewById<TextView>(R.id.tv_age)
        var sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        var gson = Gson()
        var json = sharedPreferences.getString("key","Null")

        var type = object:TypeToken<ArrayList<PersonData>>() {
        }.getType()
        var list:ArrayList<PersonData> = gson.fromJson<ArrayList<PersonData>>(json,type)

        name.text = list.get(1).name
        age.text = list.get(1).age.toString()
    }
}