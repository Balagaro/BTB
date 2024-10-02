package com.example.btb

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import android.view.SurfaceView


class GameActivity(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    init {
        holder.addCallback(this)
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        val canvas: Canvas? = holder.lockCanvas()
        try {
            if (canvas != null) {
                //amit szeretnenk rajzolni
                draw(canvas)
            }
        } finally {
            //renderel
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        TODO("Not yet implemented")
    }
}
