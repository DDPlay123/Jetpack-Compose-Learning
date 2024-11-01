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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SubscriptTextExample(
    modifier: Modifier = Modifier
) {
    val subscript = SpanStyle(
        baselineShift = BaselineShift.Subscript,
        fontSize = 14.sp,
        color = Color.Blue
    )

    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        fontSize = 20.sp,
        text = buildAnnotatedString {
            append("CH")
            withStyle(subscript) {
                append("4")
            }
            append(" + H")
            withStyle(subscript) {
                append("2")
            }
            append("O = CO + 3H")
            withStyle(subscript) {
                append("2")
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun SubscriptTextExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SubscriptTextExample()
    }
}