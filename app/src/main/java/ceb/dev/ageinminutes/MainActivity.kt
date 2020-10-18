package ceb.dev.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GoButton.isClickable = false
        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
        }

    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val yearNow = myCalendar.get(Calendar.YEAR)
        val monthNow = myCalendar.get(Calendar.MONTH)
        val dayNow = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, SelectedYear, SelectedMonth, SelectedDay ->
            // Toast made for date
            val DateToast = Toast.makeText(this,"The year is $SelectedYear, Month is ${SelectedMonth + 1}, Day is $SelectedDay", Toast.LENGTH_SHORT,)
            DateToast.setGravity(Gravity.CENTER,0,350)
            DateToast.show()

            // The date that is displayed in SetDate
            val selectedDate = "$SelectedYear/${SelectedMonth + 1}/$SelectedDay"
            Date.setText(selectedDate)

            // GoButton Properties
            GoButton.isClickable = true
            GoButton.setBackgroundResource(R.color.AgeTextColor)

            val age = yearNow - SelectedYear


            val result = if (age == 1){
                "$age Year Old"
            }
            else{
                "$age Years Old"
            }
            GoButton.setOnClickListener{Result.setText(result)}
        }, yearNow, monthNow, dayNow).show()

    }
}