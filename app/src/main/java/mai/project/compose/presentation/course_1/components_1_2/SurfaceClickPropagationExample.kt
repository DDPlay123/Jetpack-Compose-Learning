package mai.project.compose.presentation.course_1.components_1_2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun SurfaceClickPropagationExample(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .clickable(onClick = {
                Toast
                    .makeText(context, "Box Clicked", Toast.LENGTH_SHORT)
                    .show()
            })
    ) {
        Surface(
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            shape = RoundedCornerShape(10.dp),
            color = (Color(0xFFFDD835)),
            modifier = Modifier
                .size(150.dp)
                .padding(12.dp),
            onClick = {
                Toast
                    .makeText(
                        context,
                        "Surface(Left) inside Box is clicked!",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        ) {
            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .size(80.dp)
                    .offset(x = 50.dp, y = (-20).dp),
                color = (Color(0xFF26C6DA)),
                shadowElevation = 8.dp,
                tonalElevation = 4.dp,
                onClick = {
                    Toast
                        .makeText(
                            context,
                            "Surface inside Surface is clicked!",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            ) {}
        }

        Surface(
            shape = CutCornerShape(10.dp),
            modifier = Modifier
                .size(110.dp)
                .padding(12.dp)
                .offset(x = 110.dp, y = 20.dp),
            color = (Color(0xFFF4511E)),
            shadowElevation = 8.dp,
            tonalElevation = 4.dp,
            onClick = {
                Toast
                    .makeText(
                        context,
                        "Surface(Right) inside Box is clicked!",
                        Toast.LENGTH_SHORT
                    )
                    .show()

            }
        ) {}
    }
}

@PreviewLightDark
@Composable
private fun SurfaceClickPropagationExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SurfaceClickPropagationExample()
    }
}