package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun TextBackgroundExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            text = "Orange 500",
            modifier = Modifier
                .background(
                    color = Color(color = 0xffFF9800),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        )
        Text(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            text = "Cyan 500",
            modifier = Modifier
                .background(
                    color = Color(color = 0xff00BCD4),
                    shape = CutCornerShape(topStartPercent = 25)
                )
                .padding(20.dp)
        )
        Text(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            text = "Gradient",
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(color = 0xffF57F17),
                            Color(color = 0xffFFEE58),
                            Color(color = 0xffFFF9C4)
                        )
                    )
                )
                .padding(20.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun TextBackgroundExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TextBackgroundExample()
    }
}