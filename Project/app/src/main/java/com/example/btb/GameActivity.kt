package com.example.btb.ui.theme

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.SurfaceHolder
import com.example.btb.R


private lateinit var surfaceHolder: SurfaceHolder
private lateinit var mediaPlayer: MediaPlayer
private lateinit var fileDescriptor: AssetFileDescriptor


class GameActivity : AppCompatActivity(),SurfaceHolder.Callback2 {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var surfaceHolder: SurfaceHolder
    lateinit var fileDescriptor: AssetFileDescriptor


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDisplay(surfaceHolder)
        mediaPlayer.setDataSource(fileDescriptor)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener { mediaPlayer -> mediaPlayer.start() }
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        surfaceHolder = surface_view.holder
        surfaceHolder.addCallback(p0: this)
        fileDescriptor = assets.openFd("bgm.mp3")
        mediaPlayer = MediaPlayer()
    }


    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }

    override fun surfaceRedrawNeeded(p0: SurfaceHolder) {
    }
}