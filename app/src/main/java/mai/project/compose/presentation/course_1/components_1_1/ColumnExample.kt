package mai.project.compose.presentation.course_1.components_1_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.home.components.CourseHintText
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ColumnExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ColumnItem(
            hint = "Arrangement.Top",
            verticalArrangement = Arrangement.Top
        )
        ColumnItem(
            hint = "Arrangement.Bottom",
            verticalArrangement = Arrangement.Bottom
        )
        ColumnItem(
            hint = "Arrangement.Center",
            verticalArrangement = Arrangement.Center
        )
        ColumnItem(
            hint = "Arrangement.SpaceEvenly",
            verticalArrangement = Arrangement.SpaceEvenly
        )
        ColumnItem(
            hint = "Arrangement.SpaceAround",
            verticalArrangement = Arrangement.SpaceAround
        )
        ColumnItem(
            hint = "Arrangement.SpaceBetween",
            verticalArrangement = Arrangement.SpaceBetween
        )
    }
}

@Composable
private fun ColumnItem(
    modifier: Modifier = Modifier,
    hint: String,
    verticalArrangement: Arrangement.Vertical
) {
    CourseHintText(text = hint)
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray),
        verticalArrangement = verticalArrangement
    ) {
        ColumnTexts()
    }
}

@Composable
private fun ColumnTexts(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Column1", modifier = modifier
            .background(Color(0xFF8BC34A))
            .padding(4.dp)
    )
    Text(
        text = "Column2", modifier = modifier
            .background(Color(0xFF9CCC65))
            .padding(4.dp)
    )
    Text(
        text = "Column3", modifier = modifier
            .background(Color(0xFFAED581))
            .padding(4.dp)
    )
}

@PreviewLightDark
@Composable
private fun ColumnExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ColumnExample()
    }
}