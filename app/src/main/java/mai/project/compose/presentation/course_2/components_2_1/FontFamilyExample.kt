package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun FontFamilyExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Default",
            fontFamily = FontFamily.Default
        )
        Text(
            text = "Cursive",
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "Monospace",
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = "SansSerif",
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = "Serif",
            fontFamily = FontFamily.Serif
        )
    }
}

@PreviewLightDark
@Composable
private fun FontFamilyExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FontFamilyExample()
    }
}