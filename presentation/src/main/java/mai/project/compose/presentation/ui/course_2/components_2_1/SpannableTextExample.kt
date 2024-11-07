package mai.project.compose.presentation.ui.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun SpannableTextExample(
    modifier: Modifier = Modifier
) {
    val annotatedColorString = buildAnnotatedString {
        append("Red-Green-Blue")
        addStyle(
            style = SpanStyle(
                color = Color.Red,
                fontSize = 24.sp
            ),
            start = 0,
            end = 3
        )
        addStyle(
            style = SpanStyle(
                color = Color.Green,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            start = 4,
            end = 9
        )
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 26.sp,
                textDecoration = TextDecoration.Underline
            ),
            start = 10,
            end = this.length
        )
    }

    Text(
        modifier = modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .fillMaxWidth(),
        text = annotatedColorString
    )
}

@PreviewLightDark
@Composable
private fun SpannableTextExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SpannableTextExample()
    }
}