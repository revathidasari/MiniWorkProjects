package com.example.myrecorderapp.recorder

import java.io.File

interface IVideoRecorder {

    fun startRecording(file: File)
    fun stopRecording()
}