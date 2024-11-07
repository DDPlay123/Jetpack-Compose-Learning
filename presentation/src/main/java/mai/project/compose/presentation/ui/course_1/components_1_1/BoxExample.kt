package mai.project.compose.presentation.ui.course_1.components_1_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun BoxExample(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        BoxTexts(
            hint = "First",
            backgroundColor = Color(0xFF1976D2),
            size = 200.dp
        )
        BoxTexts(
            hint = "Second",
            backgroundColor = Color(0xFF2196F3),
            size = 150.dp
        )
        BoxTexts(
            hint = "Third",
            backgroundColor = Color(0xFF64B5F6),
            size = 100.dp
        )
    }
}

@Composable
private fun BoxTexts(
    modifier: Modifier = Modifier,
    hint: String,
    backgroundColor: Color,
    size: Dp
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .size(size)
    ) {
        Text(
            text = hint,
            modifier = Modifier
                // 文字在右下角對齊
                .align(Alignment.BottomEnd),
            color = Color.White,
        )
    }
}

@PreviewLightDark
@Composable
private fun BoxExamplePreview() {
    Jetpack_Compose_LearningTheme {
        BoxExample()
    }
}