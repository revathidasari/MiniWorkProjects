package com.example.minipojects.sampleFiles

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.minipojects.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*
import kotlin.collections.ArrayList

class SampleActivity : AppCompatActivity() {

    private var writeAndReadFileData = WriteAndReadFileData()
    var chipData : String? = null
    var chipGroup : ChipGroup? = null
    var addChip : TextView? = null
    var editChips : EditText? = null
    var filterChip : ChipGroup? = null
    var choiceChip : ChipGroup? = null
    var actionChip  : ChipGroup? = null
    var action1  : Chip? = null
    var action2  : Chip? = null
    var action3  : Chip? = null
    var listView : ListView? = null
    var options: ArrayList<String> = arrayListOf()



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        editChips = findViewById(R.id.textChip)
        chipGroup = findViewById(R.id.chipGroup)

        //  chipGroup?.isSingleSelection = true
/*        var chipDrawable : ChipDrawable = ChipDrawable.createFromAttributes(
            this,
            null,
            0,
            com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
        )*/

        addChip = findViewById(R.id.addchip)
        filterChip = findViewById(R.id.filterChipGroup)
        choiceChip = findViewById(R.id.choiceChip)
        actionChip = findViewById(R.id.actionChip)
        action1 = findViewById(R.id.chipA1)
        action2 = findViewById(R.id.chipA2)
        action3 = findViewById(R.id.chipA3)

        chipsTypesData()

        listView = findViewById(R.id.listView)
        options = arrayListOf("Share", "Edit", "Get Link","Delete", "Send a copy", "open","move","star","rename")
        listView?.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)



    }


    private fun chipsTypesData() {
        addChip?.setOnClickListener {
            chipData = editChips?.text.toString()
            val newChip = Chip(this)

            newChip.apply {
                text = chipData
                chipIcon =
                    ContextCompat.getDrawable(this@SampleActivity, R.drawable.ic_baseline_add_24)
                isChipIconVisible = false
                isCloseIconVisible = true
                isClickable = true
                isCheckable = false
                //   chipDrawable = chipDrawable
            }

            chipGroup?.addView(newChip as View)
            newChip.setOnCloseIconClickListener {
                chipGroup?.removeView(newChip as View)
            }

            Toast.makeText(this, "$chipData", Toast.LENGTH_SHORT).show()
            editChips?.text?.clear()

        }


        filterChip?.setOnCheckedChangeListener { group, checkedId ->
            val chip : Chip? = group.findViewById(checkedId)

            chip?.let { chipView ->
                when(chipView.text) {
                    "first" -> {
                        choiceChip?.visibility = View.GONE
                        actionChip?.visibility = View.VISIBLE
                    }
                    "second" -> {
                        choiceChip?.visibility = View.VISIBLE
                        actionChip?.visibility = View.GONE
                    }
                    "third" -> {
                        choiceChip?.visibility = View.GONE
                        actionChip?.visibility = View.GONE
                    }
                }
            } ?: kotlin.run {
                choiceChip?.visibility = View.VISIBLE
                actionChip?.visibility = View.VISIBLE
            }


        }

        choiceChip?.setOnCheckedChangeListener { group, checkedId ->
            val chip : Chip? = group.findViewById(checkedId)

            /*  val chipDrawable : ChipDrawable = ChipDrawable.createFromAttributes(
                  this,
                  null,
                  0,
                  com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice
              )
              chip?.apply {
                  setChipDrawable(chipDrawable)
                  isClickable = true
                  isCheckable = true
              }*/
            Log.d("revathi","choicechip ${chip?.text}")
            chip?.let {
                Toast.makeText(this, "Choosed ${it.text}", Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {

            }
        }

        action1?.setOnClickListener{
            Toast.makeText(this, "Action1 ", Toast.LENGTH_SHORT).show()
        }
        action2?.setOnClickListener{
            Toast.makeText(this, "Action2 ", Toast.LENGTH_SHORT).show()
        }
        action3?.setOnClickListener{
            Toast.makeText(this, "Action3 ", Toast.LENGTH_SHORT).show()
        }

    }

    // to read and write data into json & text file
    private fun fileWritingAndReading() {
        writeAndReadFileData.writeJSONData("json","written")
        writeAndReadFileData.readJSONData("json")

        writeAndReadFileData.writeTextData("text file")
        writeAndReadFileData.readTextData()
    }

    //switch and load the fragment based on argument passed
    private fun loadFragment(fragment : Fragment) : Boolean {
        Toast.makeText(this,"crent"+fragment.toString(),Toast.LENGTH_SHORT).show()
        if (fragment != null) {
            val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
         //   fragmentTransaction.replace(R.id.frame, fragment) //Nav host container of fragment Tag
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            return true
        }
        return false
    }

    private fun alarmTrigger() {
        val intent = Intent(this, SampleActivity::class.java)
        val pi = PendingIntent.getService(this, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val am = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR_OF_DAY, 23)
        am.setInexactRepeating(
            AlarmManager.RTC_WAKEUP, getTriggerAt(Date()),
            /* (60 * 60 * 1000).toLong()*/
            AlarmManager.INTERVAL_DAY, pi
        ) /* start Service every hour. */
    }

    private fun getTriggerAt(time : Date) : Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 15)
        Toast.makeText(this,"${time.time}-----${calendar.timeInMillis}", Toast.LENGTH_SHORT).show()
        return calendar.timeInMillis
    }


}