package mai.project.compose.presentation.ui.course_2.components_2_12.color

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ColorWheel(
    modifier: Modifier = Modifier,
) {
    // 通過疊加兩個圓實現，不太準確

    val gradientColors = listOf(
        Color.Cyan,
        Color.Blue,
        Color.Magenta,
        Color.Red,
        Color.Yellow,
        Color.Green,
        Color.Cyan
    )

    Canvas(
        modifier = modifier.aspectRatio(1f)
    ) {
        // 取得 Canvas 尺寸
        val canvasWidth = size.width
        val canvasHeight = size.height

        // 計算中心點座標
        val cX = canvasWidth / 2
        val cY = canvasHeight / 2
        val center = Offset(cX, cY)

        // 設定半徑
        val radius = size.minDimension / 2f

        // 畫圓
        drawCircle(
            brush = Brush.sweepGradient(
                colors = gradientColors,
                center = center
            ),
            radius = radius,
            center = center
        )

        // 疊加一層半透明的圓
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.8f),
                    Color.Transparent
                ),
                center = center,
                radius = radius
            ),
            radius = radius,
            center = center
        )
    }
}

@PreviewLightDark
@Composable
private fun ColorWheelPreview() {
    Jetpack_Compose_LearningTheme {
        ColorWheel()
    }
}