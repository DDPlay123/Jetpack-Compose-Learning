package mai.project.compose.presentation.course_1.components_1_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SpacerExample(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .padding(horizontal = 8.dp)
        .fillMaxWidth()
        .background(Color.LightGray)
    ) {
        Row {
            Text(
                text = "Row1",
                modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(100.dp))
            Text(
                text = "Row2",
                modifier = Modifier
                    .background(Color(0xFFFFA726))
                    .padding(4.dp)
            )
            Text(
                text = "Row3",
                modifier = Modifier
                    .background(Color(0xFFFFB74D))
                    .padding(4.dp)
            )
        }

        Column(
            modifier = Modifier.height(200.dp)
        ) {
            Text(
                text = "Column1",
                modifier = Modifier
                    .background(Color(0xFF8BC34A))
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Column2",
                modifier = Modifier
                    .background(Color(0xFF9CCC65))
                    .padding(4.dp)
            )
            Text(
                text = "Column3",
                modifier = Modifier
                    .background(Color(0xFFAED581))
                    .padding(4.dp)
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun SpacerExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SpacerExample()
    }
}