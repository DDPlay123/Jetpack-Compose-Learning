@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.ui.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun FontWeightExample(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Thin",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "ExtraLight",
            fontWeight = FontWeight.ExtraLight
        )
        Text(
            text = "Light",
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Normal",
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "Medium",
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "SemiBold",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Bold",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "ExtraBold",
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Black",
            fontWeight = FontWeight.Black
        )
    }
}

@PreviewLightDark
@Composable
private fun FontWeightExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FontWeightExample()
    }
}