class PerlinNoise(private val seed: Int) {
    private val permutation = IntArray(512)

    init {
        val p = IntArray(256) { it }
        p.shuffle(java.util.Random(seed.toLong()))
        for (i in 0..255) {
            permutation[i] = p[i]
            permutation[i + 256] = p[i]
        }
    }

    fun noise(x: Double, y: Double): Double {
        val xi = x.toInt() and 255
        val yi = y.toInt() and 255

        val xf = x - x.toInt()
        val yf = y - y.toInt()

        val u = fade(xf)
        val v = fade(yf)

        val a = permutation[xi] + yi
        val b = permutation[xi + 1] + yi

        val aa = permutation[a]
        val ab = permutation[a + 1]
        val ba = permutation[b]
        val bb = permutation[b + 1]

        return lerp(
            v, lerp(
                u, grad(permutation[aa], xf, yf),
                grad(permutation[ba], xf - 1, yf)
            ),
            lerp(
                u, grad(permutation[ab], xf, yf - 1),
                grad(permutation[bb], xf - 1, yf - 1)
            )
        )
    }

    private fun fade(t: Double) = t * t * t * (t * (t * 6 - 15) + 10)
    private fun lerp(t: Double, a: Double, b: Double) = a + t * (b - a)
    private fun grad(hash: Int, x: Double, y: Double): Double {
        val h = hash and 3
        val u = if (h and 2 == 0) x else -x
        val v = if (h and 1 == 0) y else -y
        return u + v
    }
}