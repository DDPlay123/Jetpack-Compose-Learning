package mai.project.compose.presentation.ui.course_2.components_2_12.color

import android.graphics.Bitmap
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.core.Method
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun HueWheel(
    modifier: Modifier = Modifier,
) {
    val bitmap = rememberSaveable { Method.createHueWheelBitmap() }

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Hue Wheel",
        modifier = modifier
            .aspectRatio(1f)
            .clip(CircleShape)
    )
}

@Composable
fun HueWheelPicker(
    modifier: Modifier = Modifier,
    initialColor: Color = Color.White,
    onColorChanged: (Color) -> Unit = {}
) {
    val bitmapSize = 1000
    // 異步生成 Bitmap，避免卡頓
    val bitmap by produceState<Bitmap?>(null) {
        value = Method.createHueWheelBitmap(bitmapSize)
    }

    var selectedOffset by remember { mutableStateOf<Offset?>(null) }
    var selectedColor by remember { mutableStateOf(Color.White) }

    BoxWithConstraints(
        modifier = modifier.aspectRatio(1f)
    ) {
        val boxSizePx = with(LocalDensity.current) { maxWidth.toPx() }

        // 初始化 Offset 位置
        LaunchedEffect(bitmap) {
            bitmap?.let {
                val position = findColorPosition(it, bitmapSize, initialColor)
                position?.let { (x, y) ->
                    selectedOffset = Offset(
                        x = x / bitmapSize.toFloat() * boxSizePx,
                        y = y / bitmapSize.toFloat() * boxSizePx
                    )
                }
            }
        }

        if (bitmap != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(boxSizePx) {
                        detectDragGestures { change, _ ->
                            handleTabOrDragEvent(
                                position = change.position,
                                boxSizePx = boxSizePx,
                                bitmapSize = bitmapSize,
                                bitmap = bitmap!!,
                                onColorChanged = {
                                    selectedColor = it
                                    selectedOffset = change.position
                                    onColorChanged(it)
                                }
                            )
                        }
                    }
                    .pointerInput(boxSizePx) {
                        detectTapGestures { offset ->
                            handleTabOrDragEvent(
                                position = offset,
                                boxSizePx = boxSizePx,
                                bitmapSize = bitmapSize,
                                bitmap = bitmap!!,
                                onColorChanged = {
                                    selectedColor = it
                                    selectedOffset = offset
                                    onColorChanged(it)
                                }
                            )
                        }
                    }
            ) {
                Image(
                    bitmap = bitmap!!.asImageBitmap(),
                    contentDescription = "Hue Wheel",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )

                selectedOffset?.let { offset ->
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(
                            color = Color.Black,
                            radius = 14.dp.toPx(),
                            center = offset,
                            style = Stroke(width = 2.dp.toPx())
                        )
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ColorWheel()
            }
        }
    }
}

private fun handleTabOrDragEvent(
    position: Offset,
    boxSizePx: Float,
    bitmapSize: Int,
    bitmap: Bitmap,
    onColorChanged: (Color) -> Unit
) {
    val x = (position.x / boxSizePx * bitmapSize).toInt()
    val y = (position.y / boxSizePx * bitmapSize).toInt()
    if (x in 0 until bitmapSize && y in 0 until bitmapSize) {
        val pixelColor = bitmap.getPixel(x, y)
        val pickedColor = Color(pixelColor)
        if (pickedColor.alpha > 0f) {
            onColorChanged(pickedColor)
        }
    }
}

private fun findColorPosition(
    bitmap: Bitmap,
    bitmapSize: Int,
    targetColor: Color,
): Pair<Int, Int>? {
    var bestX = -1
    var bestY = -1
    var minDistance = Float.MAX_VALUE

    for (y in 0 until bitmapSize step 5) { // 每 5px 掃描一次，加快速度
        for (x in 0 until bitmapSize step 5) {
            val pixelColor = Color(bitmap.getPixel(x, y))
            if (pixelColor.alpha > 0f) {
                val distance = colorDistance(pixelColor, targetColor)
                if (distance < minDistance) {
                    minDistance = distance
                    bestX = x
                    bestY = y
                }
            }
        }
    }

    return if (bestX != -1 && bestY != -1) bestX to bestY else null
}

private fun colorDistance(c1: Color, c2: Color): Float {
    val rDiff = c1.red - c2.red
    val gDiff = c1.green - c2.green
    val bDiff = c1.blue - c2.blue
    return rDiff * rDiff + gDiff * gDiff + bDiff * bDiff
}

@PreviewLightDark
@Composable
private fun HueWheelPreview() {
    Jetpack_Compose_LearningTheme {
        HueWheel()
    }
}

@PreviewLightDark
@Composable
private fun HueWheelPickerPreview() {
    Jetpack_Compose_LearningTheme {
        HueWheelPicker()
    }
}