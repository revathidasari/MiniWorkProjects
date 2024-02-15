package com.example.myrecorderapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.myrecorderapp.player.AudioPlayer
import com.example.myrecorderapp.recorder.AudioRecorder
import com.example.myrecorderapp.ui.theme.MyRecorderAppTheme
import java.io.File
import java.util.*

class MainActivity : ComponentActivity() {


    private var permissions: Array<String> = arrayOf(
        android.Manifest.permission.RECORD_AUDIO,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private val recorder by lazy {
        AudioRecorder(applicationContext)
    }

    private val player by lazy {
        AudioPlayer(applicationContext)
    }

    private var audioFile : File? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AllowRuntimePermissions(this, permissions).requestPermissions()
        AllowRuntimePermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)).requestPermissions()

/*        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.RECORD_AUDIO),
            0
        )*/


        setContent {
            MyRecorderAppTheme {
                Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement =  Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {
                        File(cacheDir, "audio.mp3").also {
                            recorder.startRecord(it)
                            audioFile = it
                        }
                    }) {
                        Text(text = "Start Recording")
                    }
                    Button(onClick = {
                        recorder.stopRecord()
                    }) {
                        Text(text = "Stop Recording")
                    }
                    Button(onClick = {
                        player.startPlaying(audioFile ?: return@Button)
                    }) {
                        Log.d("revathi", "files are ${Arrays.toString(cacheDir.list())}")
                        Text(text = "Play")
                    }
                    Button(onClick = {
                        player.stopPlaying()
                    }) {
                        Text(text = "Stop Playing")
                    }
                }
            }
        }
    }

/*    fun GetFileName() : String {
        for (i in 0 until 6) {
            var s = "audio"+i+".mp3"
            audioFile = s
        }
        return audioFile
    }*/
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRecorderAppTheme {
    }
}