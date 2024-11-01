package mai.project.compose.presentation.course_1.components_1_2

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SurfaceContentColorExample(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(12.dp),
        shape = RoundedCornerShape(10.dp),
        color = (Color(0xFFFDD835)),
        contentColor = (Color(0xFF26C6DA))
    ) {
        Text(
            text = "Surface 內的文字會使用 Surface 的內容顏色作為默認顏色",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun SurfaceContentColorExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SurfaceContentColorExample()
    }
}