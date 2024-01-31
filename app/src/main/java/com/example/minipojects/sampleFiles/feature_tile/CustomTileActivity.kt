package com.example.minipojects.sampleFiles.feature_tile

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.minipojects.MainActivity
import com.example.minipojects.R

class CustomTileActivity : AppCompatActivity() {

    val RESULT_ACTIVITY_INFO_KEY = "resultActivityInfo"
    val RESULT_ACTIVITY_NAME_KEY = "resultActivityName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_tile)

        if (intent!=null){
            val extras = intent.extras

            val tileState = extras?.getString(RESULT_ACTIVITY_INFO_KEY)
            val tileName = extras?.getString(RESULT_ACTIVITY_NAME_KEY)

            val resultText = findViewById<TextView>(R.id.resText)
            val homeText = findViewById<TextView>(R.id.homeText)

            resultText.text = getString(R.string.result_output, tileName, tileState)
            homeText.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}