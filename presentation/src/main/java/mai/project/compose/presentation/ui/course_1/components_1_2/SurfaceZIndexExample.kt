package mai.project.compose.presentation.ui.course_1.components_1_2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun SurfaceZIndexExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(horizontal = 8.dp)
    ) {
        val rowModifier = Modifier
            .aspectRatio(1f)
            .weight(1f)
            .padding(12.dp)

        Surface(
            shape = RectangleShape,
            modifier = rowModifier,
            color = (Color(0xFFFDD835)),
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            border = BorderStroke(5.dp, color = Color(0xFFFF6F00))
        ) {}

        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = rowModifier,
            color = (Color(0xFFF4511E)),
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            border = BorderStroke(3.dp, color = Color(0xFF6D4C41))
        ) {}

        Surface(
            shape = CircleShape,
            modifier = rowModifier,
            color = (Color(0xFF26C6DA)),
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            border = BorderStroke(2.dp, color = Color(0xFF004D40))
        ) {}

        Surface(
            shape = CutCornerShape(topStartPercent = 20),
            modifier = rowModifier,
            color = (Color(0xFF7E57C2)),
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            border = BorderStroke(2.dp, color = Color(0xFFd50000))
        ) {}
    }
}

@PreviewLightDark
@Composable
private fun SurfaceZIndexExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SurfaceZIndexExample()
    }
}