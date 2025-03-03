package mai.project.compose.core

import android.graphics.Bitmap
import android.graphics.Color
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sqrt

object Method {

    fun createHueWheelBitmap(
        size: Int = 1000,
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val centerX = size / 2f
        val centerY = size / 2f
        val radius = size / 2f

        for (y in 0 until size) {
            for (x in 0 until size) {
                val dx = x - centerX
                val dy = y - centerY
                val distance = sqrt(dx * dx + dy * dy)

                if (distance <= radius) {
                    val angle = (atan2(dy, dx) / (2 * PI) + 0.5).toFloat()
                    val saturation = (distance / radius).coerceIn(0f, 1f)
                    val hsv = floatArrayOf(angle * 360f, saturation, 1f)
                    val color = Color.HSVToColor(hsv)
                    bitmap.setPixel(x, y, color)
                } else {
                    bitmap.setPixel(x, y, Color.TRANSPARENT)
                }
            }
        }
        return bitmap
    }
}