package com.example.myrecorderapp.recorder

import java.io.File

interface IAudioRecorder {

    fun startRecord(file: File)
    fun stopRecord()
}