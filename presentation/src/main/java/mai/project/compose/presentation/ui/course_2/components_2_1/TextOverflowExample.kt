package mai.project.compose.presentation.ui.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun TextOverflowExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(
            text = "超出的文字會被省略(...)。測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試。結尾",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        HorizontalDivider()
        Text(
            text = "超出的文字會被裁切(剪斷)。測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試。結尾",
            maxLines = 1,
            overflow = TextOverflow.Clip
        )
        HorizontalDivider()
        Text(
            text = "在超出的範圍仍顯示所有文字。測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試測試。結尾",
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
    }
}

@PreviewLightDark
@Composable
private fun TextOverflowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TextOverflowExample()
    }
}