package com.example.myrecorderapp.player

import java.io.File

interface IAudioPlayer {

    fun startPlaying(file: File)
    fun stopPlaying()
}