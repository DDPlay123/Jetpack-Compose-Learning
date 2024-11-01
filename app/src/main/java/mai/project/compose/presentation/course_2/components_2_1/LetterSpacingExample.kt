package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun LetterSpacingExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "LS:0.0sp",
            letterSpacing = 0.sp
        )
        Text(
            text = "LS:1.0sp",
            letterSpacing = 1.sp
        )
        Text(
            text = "LS:2.0sp",
            letterSpacing = 2.sp
        )
        Text(
            text = "LS:4.0sp",
            letterSpacing = 4.sp
        )
    }
}

@PreviewLightDark
@Composable
private fun LetterSpacingExamplePreview() {
    Jetpack_Compose_LearningTheme {
        LetterSpacingExample()
    }
}