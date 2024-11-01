package mai.project.compose.presentation.course_1.components_1_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SurfaceShapeExample(
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
            modifier = rowModifier,
            shape = RectangleShape,
            color = (Color(0xFFFDD835))
        ) {}

        Surface(
            modifier = rowModifier,
            shape = RoundedCornerShape(5.dp),
            color = (Color(0xFFF4511E))
        ) {}

        Surface(
            modifier = rowModifier,
            shape = CircleShape,
            color = (Color(0xFF26C6DA))
        ) {}

        Surface(
            modifier = rowModifier,
            shape = CutCornerShape(10.dp),
            color = (Color(0xFF7E57C2))
        ) {}
    }
}

@PreviewLightDark
@Composable
private fun SurfaceExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SurfaceShapeExample()
    }
}