package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun LineHeightExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(
            text = "此文字的行高為 15 sp。段落的行高使用 TextUnit 單位，例如 SP 或 EM。",
            lineHeight = 15.sp
        )
        HorizontalDivider()
        Text(
            text = "此文字的行高為 20 sp。段落的行高使用 TextUnit 單位，例如 SP 或 EM。",
            lineHeight = 20.sp
        )
        HorizontalDivider()
        Text(
            text = "此文字的行高為 25 sp。段落的行高使用 TextUnit 單位，例如 SP 或 EM。",
            lineHeight = 25.sp
        )
        HorizontalDivider()
        Text(
            text = "此文字的行高為 30 sp。段落的行高使用 TextUnit 單位，例如 SP 或 EM。",
            lineHeight = 30.sp
        )
    }
}

@PreviewLightDark
@Composable
private fun LineHeightExamplePreview() {
    Jetpack_Compose_LearningTheme {
        LineHeightExample()
    }
}