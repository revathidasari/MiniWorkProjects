package com.example.myrecorderapp.recorder

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream

class AudioRecorder(
    private val context: Context
) : IAudioRecorder {

    private var recorder : MediaRecorder? = null

    private fun createRecorder() : MediaRecorder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            return MediaRecorder(context)
        } else {
            return MediaRecorder()
        }
    }

    override fun startRecord(file: File) {
        createRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(FileOutputStream(file).fd)//file)

            prepare()
            start()

            recorder = this
        }
    }

    override fun stopRecord() {
        recorder?.stop()
        recorder?.reset()
        recorder = null
    }

}