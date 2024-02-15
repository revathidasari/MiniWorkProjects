package com.example.myrecorderapp.recorder

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream

class VideoRecorder(
    private val context: Context
) : IVideoRecorder {

    private var recorder : MediaRecorder? = null

    private fun createRecorder() : MediaRecorder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            return MediaRecorder(context)
        } else {
            return MediaRecorder()
        }
    }

    override fun startRecording(file: File) {
        createRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setVideoSource(MediaRecorder.VideoSource.CAMERA)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setVideoEncoder(MediaRecorder.VideoEncoder.H264)
            setOutputFile(FileOutputStream(file).fd)//file)
            setPreviewDisplay(surface)

            prepare()
            start()

            recorder = this
        }
    }

    override fun stopRecording() {
        recorder?.stop()
        recorder?.reset()
        recorder?.release()
        recorder = null
    }

}