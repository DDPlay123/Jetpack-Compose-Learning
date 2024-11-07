package mai.project.compose.presentation.ui.course_1.components_1_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun RowExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        RowItem(
            hint = "Arrangement.Start",
            horizontalArrangement = Arrangement.Start
        )
        RowItem(
            hint = "Arrangement.End",
            horizontalArrangement = Arrangement.End
        )
        RowItem(
            hint = "Arrangement.Center",
            horizontalArrangement = Arrangement.Center
        )
        RowItem(
            hint = "Arrangement.SpaceEvenly",
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        RowItem(
            hint = "Arrangement.SpaceAround",
            horizontalArrangement = Arrangement.SpaceAround
        )
        RowItem(
            hint = "Arrangement.SpaceBetween",
            horizontalArrangement = Arrangement.SpaceBetween
        )
    }
}

@Composable
private fun RowItem(
    modifier: Modifier = Modifier,
    hint: String,
    horizontalArrangement: Arrangement.Horizontal
) {
    CourseHintText(text = hint)
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = horizontalArrangement
    ) {
        RowTexts()
    }
}

@Composable
private fun RowTexts(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Row1", modifier = modifier
            .background(Color(0xFFFF9800))
            .padding(4.dp)
    )
    Text(
        text = "Row2", modifier = modifier
            .background(Color(0xFFFFA726))
            .padding(4.dp)
    )
    Text(
        text = "Row3", modifier = modifier
            .background(Color(0xFFFFB74D))
            .padding(4.dp)
    )
}

@PreviewLightDark
@Composable
private fun RowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        RowExample()
    }
}