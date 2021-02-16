package com.example.android.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.text.SimpleDateFormat



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnDatePicker.setOnClickListener{ view->
            clickDatePicker(view)
        }

    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

    val dpd =  DatePickerDialog   (
            this,
            DatePickerDialog.OnDateSetListener { view, Selectedyear, Selectedmonth, SelecteddayOfMonth ->

                Toast.makeText(
                    this,
                    "Your year is $Selectedyear month is $Selectedmonth & day is $dayOfMonth",
                    Toast.LENGTH_SHORT
                ).show()
                val selectedDate = "$SelecteddayOfMonth/${Selectedmonth + 1}/$Selectedyear"
                tvSelectedDate.setText(selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val selectedDateInMinutes = theDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes = currentDate!!.time / 60000
                val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
                tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
            }
            ,year
            ,month
             ,dayOfMonth)

        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()


        


        }


}






