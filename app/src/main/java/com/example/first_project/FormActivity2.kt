package com.example.first_project

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var display: TextView
    lateinit var  autoCompleteTextView: AutoCompleteTextView

    val countries = arrayOf("Nepal", "China", "India", "US", "Canada", "Australia")

    val citities = arrayOf(
        "Kathmandu","Lalitput","Bhaktapur","Kanchanpur","Bhadrapur"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form2)

        spinner = findViewById(R.id.spinner)
        display = findViewById(R.id.countryDisplay)
        autoCompleteTextView=findViewById(R.id.cities)


        var adapter =ArrayAdapter(
            this@FormActivity2,
            android.R.layout.simple_spinner_item,
            countries,
        )

        val autoCompleteAdapter = ArrayAdapter(
            this@FormActivity2,
            android.R.layout.simple_dropdown_item_1line,
            citities
        )

        autoCompleteTextView.threshold=1

        spinner.onItemSelectedListener=this
        spinner.adapter=adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        display.text=parent?.getItemAtPosition(position).toString()


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }
}