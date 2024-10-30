package mai.project.compose.presentation.course_1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun WeightExample(
    modifier: Modifier = Modifier
) {
    val rowModifier = Modifier
        .fillMaxHeight()
        .background(Color(0xFFA1887F))
        .padding(4.dp)

    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.LightGray)
    ) {
        Text(
            fontSize = 12.sp,
            text = "Weight 2",
            modifier = rowModifier.weight(2f)
        )

        // Spacer creates a space with given modifier width or height based on which scope(row/column) it exists
        Spacer(modifier = Modifier.weight(1f))

        Text(
            fontSize = 12.sp,
            text = "Weight 3",
            modifier = rowModifier.weight(3f)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            fontSize = 12.sp,
            text = "Weight 4",
            modifier = rowModifier.weight(4f)
        )
    }
}

@PreviewLightDark
@Composable
private fun WeightExamplePreview() {
    Jetpack_Compose_LearningTheme {
        WeightExample()
    }
}