package com.example.theroos.agecal_firstappkotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import java.sql.RowId
import java.text.FieldPosition
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate = findViewById<Button>(R.id.calculate);
        calculate.setOnClickListener { view->
            CalculateAge(view);
        }
    }

    private fun CalculateAge(view: View?) {

        val currentyear: Int = Calendar.getInstance().get(Calendar.YEAR)
        val currentmonth = Calendar.getInstance().get(Calendar.MONTH)
        val currentday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        val enter_date = findViewById<EditText>(R.id.enter_date)
        if(TextUtils.isEmpty(enter_date.getText().toString())){
            Toast.makeText(this@MainActivity, "Enter the date!!", Toast.LENGTH_SHORT).show()
        } else{
            val ent_date: Int = enter_date.text.toString().toInt()
            if(ent_date > 31){Toast.makeText(this@MainActivity, "Invalid Date!!", Toast.LENGTH_SHORT).show() }
        }


        val months = resources.getStringArray(R.array.Months)
        val enter_month = findViewById<Spinner>(R.id.enter_month_spinner)

        if(enter_month != null){
            val adapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,months)
            enter_month.adapter = adapter

            enter_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    Toast.makeText(this@MainActivity,getString(R.string.selected_item) + " " + "" + months[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }



        val enter_year = findViewById<EditText>(R.id.enter_year);
        if(TextUtils.isEmpty(enter_year.getText().toString())){
            Toast.makeText(this@MainActivity, "Enter the Year!!", Toast.LENGTH_SHORT).show()
        }else {
            val ent_yr: Int = enter_year.text.toString().toInt()
            if(ent_yr > currentyear){ Toast.makeText(this@MainActivity, "Invalid Year!!", Toast.LENGTH_SHORT).show()}
        }



        //val ageyear: Int = currentyear - ent_yr
        //Toast.makeText(this@MainActivity, ageyear.toString(), Toast.LENGTH_SHORT).show()
        //Toast.makeText(this@MainActivity, currentday.toString()+" "+currentmonth.toString()+" "+currentyear.toString(), Toast.LENGTH_SHORT).show()


        //Toast.makeText(this@MainActivity, currentmonth.toString(), Toast.LENGTH_SHORT).show()



    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}