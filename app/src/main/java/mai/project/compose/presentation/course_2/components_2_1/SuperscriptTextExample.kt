package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SuperscriptTextExample(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        fontSize = 20.sp,
        text = buildAnnotatedString {
            append("E = mc")
            withStyle(
                style = SpanStyle(
                    baselineShift = BaselineShift.Superscript,
                    fontSize = 14.sp,
                    color = Color.Red
                )
            ) {
                append("2")
            }
        }
    )
}

@Preview
@Composable
private fun SuperscriptTextExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SuperscriptTextExample()
    }
}