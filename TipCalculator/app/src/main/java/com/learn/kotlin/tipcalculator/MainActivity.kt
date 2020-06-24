package com.learn.kotlin.tipcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Change background color while launch
        window.decorView.setBackgroundColor(Color.WHITE)

        // Have to show info only when calculate is clicked
        infoTextView.visibility = View.INVISIBLE

        calculateButton.setOnClickListener {
            // Bill Amount
            val bill = billAmountEditText.text.toString().toDouble()

            // Tip Percentage
            val tipPercentage = tipPercentageEditText.text.toString().toDouble()

            // Tip Amount
            val tipAmount = bill * (tipPercentage/100)

            //Total
            val totalAmount = bill + tipAmount

            //Display Tip amount and Total amount in 
            infoTextView.visibility = View.VISIBLE
            
            // Set info text
           // infoTextView.text = "Tip: "+ tipAmount + " INR Total:"+ totalAmount + " INR"
            infoTextView.text = "Tip: ${roundOfAmount(tipAmount)} Total: ${roundOfAmount(totalAmount)}"
        }
    }

    private fun roundOfAmount(number: Double) : String {
        return String.format("%.2f",number) + " INR"
    }
}