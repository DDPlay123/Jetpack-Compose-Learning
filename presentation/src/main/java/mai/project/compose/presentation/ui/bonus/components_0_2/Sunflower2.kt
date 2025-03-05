package mai.project.compose.presentation.ui.bonus.components_0_2

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun Sunflower2(
    modifier: Modifier = Modifier,
    maxSeeds: Int,
    seeds: Int
) {
    val tau = PI * 2
    val scaleFactor = 10f
    val phi = (sqrt(5.0) + 1) / 2

    Box(
        modifier = modifier
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        for (i in 0 until maxSeeds) {
            val isActive = i < seeds

            val theta = i * tau / phi
            val radius = if (isActive) sqrt(i.toDouble()).toFloat() * scaleFactor else 130f
            val targetOffset = Offset(radius * cos(theta).toFloat(), radius * sin(theta).toFloat())

            val position = remember { Animatable(targetOffset, Offset.VectorConverter) }

            LaunchedEffect(targetOffset) {
                position.animateTo(
                    targetOffset,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                )
            }

            Dot(
                offset = position.value,
                color = if (isActive) Color(0xFFFFA000) else Color.Gray,
                density = LocalDensity.current
            )
        }
    }
}

@Composable
private fun Dot(
    offset: Offset,
    color: Color,
    density: Density,
) {
    Box(
        modifier = Modifier
            .offset {
                IntOffset(
                    x = with(density) { offset.x.dp.roundToPx() },
                    y = with(density) { offset.y.dp.roundToPx() }
                )
            }
            .size(6.dp)
            .background(
                color = color,
                shape = CircleShape
            )
    )
}

@Preview
@Composable
private fun Sunflower2Preview() {
    Jetpack_Compose_LearningTheme {
        Sunflower2(maxSeeds = 100, seeds = 50)
    }
}