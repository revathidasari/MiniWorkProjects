package com.example.myrecorderapp.player

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import java.io.File

class AudioPlayer(
    private val context: Context
) : IAudioPlayer{

    private var player : MediaPlayer? = null


    override fun startPlaying(file: File) {
      MediaPlayer.create(context, file.toUri()).apply {
          player = this
          start()
      }
    }

    override fun stopPlaying() {
        player?.stop()
        player?.release()
        player = null
    }
}