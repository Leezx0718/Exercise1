package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            val carprice:Double = editTextCarPrice.text.toString().toDouble()
            val loanperiod:Double = editTextLoanPeriod.text.toString().toDouble()
            val downpayment:Double = editTextDownPayment.text.toString().toDouble()
            val interestrate:Double = editTextInterestRate.text.toString().toDouble()

            val loan:Double = carprice - downpayment
            val interest:Double = loan * (interestrate/100) * loanperiod
            val monthlyRepayment:Double = (loan + interest) / loanperiod / 12

            textViewLoan.text = "Loan : RM %.2f".format(loan)
            textViewInterest.text = "Interest : RM %.2f".format(interest)
            textViewMonthlyRepayment.text = "Monthly Repayment : RM %.2f".format(monthlyRepayment)

            buttonReset.setOnClickListener {
                editTextCarPrice.text = null
                editTextDownPayment.text = null
                editTextLoanPeriod.text = null
                editTextInterestRate.text = null

                textViewLoan.text = "Loan : "
                textViewInterest.text = "Interest : "
                textViewMonthlyRepayment.text = "Monthly Repayment : "
            }
        }


    }
}