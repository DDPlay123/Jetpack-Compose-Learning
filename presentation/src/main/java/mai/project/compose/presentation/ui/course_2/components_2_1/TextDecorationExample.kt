package mai.project.compose.presentation.ui.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun TextDecorationExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "None",
            textDecoration = TextDecoration.None
        )
        Text(
            text = "Underline",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "LineThrough",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "combine",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun TextDecorationExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TextDecorationExample()
    }
}