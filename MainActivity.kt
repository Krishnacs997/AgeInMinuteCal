package com.example.ageinminutecal


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSectedDate :TextView? = null
    private var tvAgeInMinute : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnDatePic : Button = findViewById(R.id.selectDate)
        tvSectedDate = findViewById(R.id.calculateage3)
        tvAgeInMinute = findViewById(R.id.calculateage7)

        btnDatePic.setOnClickListener{
           clickDatePic()
        }
    }

    private fun clickDatePic() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

       DatePickerDialog(this,
           DatePickerDialog.OnDateSetListener{ view, year, month, day ->
               Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show()

               val sectedDate = "$day/${month+1}/$year"
               tvSectedDate?.text = sectedDate

               val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
               val theDate = sdf.parse(sectedDate)
               var selectedDateInMinute = theDate.time  / 60000
               var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
               var currentDateInMinute = currentDate.time / 60000
               var diffrenceInMinute = currentDateInMinute - selectedDateInMinute
               var ageinyear = diffrenceInMinute /525600
               tvAgeInMinute?.text = ageinyear.toString()

           },
       year,
       month,
       day
       ).show()



    }


}