package mai.project.compose.presentation.ui.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun FontColorExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Red 700",
            color = Color(0xffd32f2f)
        )
        Text(
            text = "Purple 700",
            color = Color(0xff7B1FA2)
        )
        Text(
            text = "Green 700",
            color = Color(0xff1976D2)
        )
        Text(
            text = "Teal 700",
            color = Color(0xff00796B)
        )
    }
}

@PreviewLightDark
@Composable
private fun FontColorExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FontColorExample()
    }
}