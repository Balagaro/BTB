package my.limitless.btb


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.color


class GameActivity : AppCompatActivity() {


    private lateinit var gameView: GameView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }


    inner class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {


        init {
            holder.addCallback(this)
        }


        override fun surfaceCreated(holder: SurfaceHolder) {
            val canvas = holder.lockCanvas()
            draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }


        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            // A játék átméretezése
            // ...
        }


        override fun surfaceDestroyed(holder: SurfaceHolder) {
            // A játék leállítása
            // ...
        }


        // A játék frissítése és rajzolása
        fun update() {
            // ...
        }


        override fun draw(canvas: Canvas) {
            super.draw(canvas) // Call the super method first
            canvas.drawColor(Color.WHITE) // Set the background color to white
            val paint = Paint()
            paint.color = Color.RED
            canvas.drawRect(100f, 100f, 200f, 200f, paint)
        }
    }
}