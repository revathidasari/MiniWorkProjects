package com.example.myrecorderapp.unused

import java.sql.Timestamp
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Currency


/*
* Notes App
* Food app
* E-banking
* Expense Tracker App - https://projectworlds.in/android-projects-with-source-code/expense-management-android-app-source-code/
* Budget Manager App - https://projectworlds.in/android-projects-with-source-code/expense-tracker-android-app-source-code/
* IT & EMI calculator App - https://projectworlds.in/calculate-income-tax-and-emi-android-app-project/
* */



class Utils {

    fun dateStringToMillis(dateString: String): Long {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val date = dateFormat.parse(dateString)
        return date.time
    }
    fun dateMillisToString(dateMillis: Long): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val cal = Calendar.getInstance()
        cal.timeInMillis = dateMillis
        return dateFormat.format(cal.time)
    }
    fun timeStampToString(timestamp: Timestamp): String {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        return dateFormat.format(timestamp.date)
    }

    fun parseDouble(string: String?): Double{
        return if (string == null || string.isEmpty()) Double.NaN else string.toDouble()
    }

    fun indianRupee(amount: Double): String{
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("INR")
        return format.format(amount)
    }

}
val String.cleanTextContent: String
    get() {
        var text = this
        text = text.replace("[^\\x00-\\x7F]".toRegex(),"")
        text = text.replace("[\\p{Cntrl}&&[^\r\n\t]]".toRegex(),"")
        text = text.replace("\\p{C}".toRegex(),"")
        text = text.replace(",".toRegex(),"")
        return text.trim()
    }

