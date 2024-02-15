package com.example.myrecorderapp.unused

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant

class DataAndConverters {

    @RequiresApi(Build.VERSION_CODES.O)
    fun timeData() {
        val currentTime = Instant.now().epochSecond
        val currentTimeInMillis = Instant.now().toEpochMilli()
    }

}