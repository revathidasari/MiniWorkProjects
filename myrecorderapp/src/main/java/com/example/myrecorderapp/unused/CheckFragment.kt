package com.example.myrecorderapp.unused

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myrecorderapp.R

class CheckFragment : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_fragment)

        val btnIn = findViewById<Button>(R.id.btnFragmentIn)
        val btnOut = findViewById<Button>(R.id.btnFragmentOut)

        btnIn.setOnClickListener {
            replaceFragment(FragmentIn())
        }

        btnOut.setOnClickListener {
            replaceFragment(FragmentOut())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.checkFragments, fragment)
        fragmentTransaction.commit()
    }
}