package mai.project.compose.presentation.ui.course_2.components_2_12.color

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ColorRing(
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(
        Color.Red,
        Color.Magenta,
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Yellow,
        Color.Red
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

        // 找出半徑，並設定線條寬度是半徑的 30%
        val canvasRadius = canvasWidth.coerceAtMost(canvasHeight) / 2f
        val strokeWidth = canvasRadius * .3f
        val radius = canvasRadius - strokeWidth

        // 畫圓
        drawCircle(
            brush = Brush.sweepGradient(
                colors = gradientColors,
                center = center
            ),
            radius = radius,
            center = center,
            style = Stroke(
                width = strokeWidth
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun ColorRingPreview() {
    Jetpack_Compose_LearningTheme {
        ColorRing()
    }
}