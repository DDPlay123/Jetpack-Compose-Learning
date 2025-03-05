@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2.components_2_12

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_12.color.HueWheelPicker

@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
    initialColor: Color = Color.White,
    onColorChanged: (Color) -> Unit = {},
) {
    var hueColor by remember { mutableStateOf(initialColor) }
    var alpha by remember { mutableFloatStateOf(initialColor.alpha) }
    var brightness by remember { mutableFloatStateOf(1f) }

    LaunchedEffect(hueColor, alpha, brightness) {
        onColorChanged(
            hueColor.copy(
                red = hueColor.red * brightness,
                green = hueColor.green * brightness,
                blue = hueColor.blue * brightness,
                alpha = alpha
            )
        )
    }

    Column(
        modifier = modifier
    ) {
        HueWheelPicker(
            initialColor = initialColor,
            onColorChanged = { pickedColor ->
                hueColor = pickedColor
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AlphaSlider(
            hueColor = hueColor,
            alpha = alpha,
            onAlphaChanged = {
                alpha = it
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BrightnessSlider(
            hueColor = hueColor,
            brightness = brightness,
            onBrightnessChanged = {
                brightness = it
            }
        )
    }
}

@Composable
private fun AlphaSlider(
    hueColor: Color,
    alpha: Float,
    onAlphaChanged: (Float) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        CheckerBackground(
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            hueColor.copy(alpha = 0f),
                            hueColor.copy(alpha = 1f)
                        )
                    )
                )
        )

        Slider(
            modifier = Modifier.matchParentSize(),
            value = alpha,
            onValueChange = onAlphaChanged,
            valueRange = 0f..1f,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.Transparent,
                inactiveTrackColor = Color.Transparent
            ),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        )
    }
}

@Composable
private fun BrightnessSlider(
    hueColor: Color,
    brightness: Float,
    onBrightnessChanged: (Float) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black,
                            hueColor.copy(alpha = 1f)
                        )
                    )
                )
        )

        Slider(
            modifier = Modifier.matchParentSize(),
            value = brightness,
            onValueChange = onBrightnessChanged,
            valueRange = 0f..1f,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.Transparent,
                inactiveTrackColor = Color.Transparent
            ),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        )
    }
}

@Composable
private fun CheckerBackground(
    modifier: Modifier = Modifier,
    rowCount: Int = 4,
) {
    val lightGray = Color(0xFFC0C0C0)
    val darkGray = Color(0xFF808080)

    Canvas(modifier = modifier) {
        val cellHeight = size.height / rowCount
        val columnCount = (size.width / cellHeight).toInt() + 1
        val cellWidth = size.width / columnCount

        for (row in 0 until rowCount) {
            for (col in 0 until columnCount) {
                drawRect(
                    color = if ((row + col) % 2 == 0) lightGray else darkGray,
                    topLeft = Offset(
                        x = col * cellWidth,
                        y = row * cellHeight
                    ),
                    size = androidx.compose.ui.geometry.Size(cellWidth, cellHeight)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun ColorRingPreview() {
    Jetpack_Compose_LearningTheme {
        ColorPicker()
    }
}