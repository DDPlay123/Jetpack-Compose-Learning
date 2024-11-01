package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun FontSizeExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "14sp",
            fontSize = 14.sp
        )
        Text(
            text = "18sp",
            fontSize = 18.sp
        )
        Text(
            text = "30sp",
            fontSize = 30.sp
        )
        Text(
            text = "40sp",
            fontSize = 40.sp
        )
    }
}

@PreviewLightDark
@Composable
private fun FontSizeExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FontSizeExample()
    }
}