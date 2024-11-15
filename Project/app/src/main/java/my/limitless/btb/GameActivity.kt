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
        private val perlinNoise = PerlinNoise(seed = 42)
        private val paint = Paint()


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
        private fun drawPerlinNoise(canvas: Canvas) {
            val width = canvas.width
            val height = canvas.height

            // A képernyő minden egyes pixelére generáljunk Perlin zajt
            for (y in 0 until height) {
                for (x in 0 until width) {
                    // A perlin zaj érték generálása
                    val noiseValue = perlinNoise.noise(x.toDouble() / 100, y.toDouble() / 100)
                    // Normalizáljuk az értéket [0, 1] tartományra
                    val normalizedNoise = (noiseValue + 1) / 2
                    // Kiszámítjuk a szürkeárnyalat színt
                    val color = (normalizedNoise * 255).toInt()
                    paint.color = Color.rgb(color, color, color) // Szürkeárnyalat

                    // Minden egyes pixelt megjelenítünk
                    canvas.drawPoint(x.toFloat(), y.toFloat(), paint)
                }
            }
        }

}
