package com.example.myrecorderapp

import android.content.ContextWrapper
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class RecordAndPlayActivity : AppCompatActivity() {

    private lateinit var recordImg: ImageView
    private lateinit var playImg: ImageView
    private lateinit var recordingPathText: TextView
    private lateinit var recordingTimeText: TextView

    private lateinit var mediaRecorder: MediaRecorder
    private lateinit var mediaPlayer: MediaPlayer

    var handler: Handler? = null

    var isRecording = false
    var isPlaying = false
    var seconds = 0
    var path: String? = null
    var dummySeconds = 0
    var playableSeconds = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_and_play)

        recordImg = findViewById(R.id.micImg)
        playImg = findViewById(R.id.playImg)
        recordingPathText = findViewById(R.id.recordingPath)
        recordingTimeText = findViewById(R.id.recordingTime)

        recordImg.setOnClickListener {
            if (isRecording) {
                stopRecording()
            } else {
                startRecording()
            }
        }

        playImg.setOnClickListener {
            if (isPlaying) {
                stopPlaying()
            } else {
                startPlaying()
            }
        }

    }

    private fun runTimer() {
        handler = Handler(Looper.getMainLooper())
        handler?.post {
            val mins = (seconds%3600) / 60
            val secs = seconds % 60
            val time = String.format("%02d:%02d", mins, secs)
            recordingTimeText.text = time

            if (isRecording || (isPlaying && playableSeconds != -1)) {
                seconds++
                playableSeconds--
                if (playableSeconds == -1 && isPlaying) {
                    stopPlaying()
                    playableSeconds = dummySeconds
                }
            }
            handler?.postDelayed({
                runTimer()
            },1000)
        }
    }

    private fun stopPlaying() {
        mediaPlayer.stop()
        mediaPlayer.release()
        mediaPlayer = MediaPlayer()
        isPlaying = false
        seconds = 0
        handler?.removeCallbacksAndMessages(null)
        playImg.visibility = View.VISIBLE
        playImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_play_arrow_24))
    }

    private fun startPlaying() {
        mediaPlayer = MediaPlayer()
        if (path != null) {
            try {
                mediaPlayer.setDataSource(getRecordingFilePath())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            mediaPlayer.prepare()
            mediaPlayer.start()
            isPlaying = true
            playImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_pause_24))
            playImg.visibility = View.VISIBLE
            runTimer()
        }
    }

    private fun startRecording() {
        isRecording = true
        mediaRecorder = MediaRecorder()
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)//THREE_GPP won't work to record audio and play
        mediaRecorder.setOutputFile(getRecordingFilePath())
        path = getRecordingFilePath()
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

        try {
            mediaRecorder.prepare()
        } catch (e:Exception) {
            e.printStackTrace()
        }
        mediaRecorder.start()

        runOnUiThread {
            playImg.visibility = View.GONE
            recordingPathText.text = path
            playableSeconds = 0
            seconds = 0
            dummySeconds = 0
            recordImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_mic_24))
            runTimer()
        }
    }

    private fun stopRecording() {
        mediaRecorder.stop()
        mediaRecorder.release()
        playableSeconds = seconds
        dummySeconds = seconds
        seconds = 0
        isRecording = false
        mediaRecorder = MediaRecorder()

        runOnUiThread {
            playImg.visibility = View.VISIBLE
            handler?.removeCallbacksAndMessages(null)
            recordImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_mic_24))
        }
    }

    private fun getRecordingFilePath(): String {
        val contextWrapper = ContextWrapper(applicationContext)
        val music: File? = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        val file = File(music, "recording.mp3")
        Log.d("revathi", "getRecordingPath ${file.path}")
        return file.path
    }

    private fun extraMediaRecorder() {
        //uses WRITE_EXTERNAL_STORAGE
        val state = Environment.getExternalStorageState()
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            val root = Environment.getExternalStorageDirectory()
            val dir = File(root.absolutePath + "/MyAppFile")
            if (!dir.exists()) {
                dir.mkdir()
            }
            val file = File(dir,"myData.txt")
            val fOut = FileOutputStream(file)
            val myOutWriter = OutputStreamWriter(fOut)
            myOutWriter.append("hello")
            myOutWriter.close()
            fOut.close()
        }
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        mediaRecorder.setOutputFile("/sdcard/Music"+System.currentTimeMillis()+".amr")
        mediaRecorder.prepare()
        mediaRecorder.start()
    }
}