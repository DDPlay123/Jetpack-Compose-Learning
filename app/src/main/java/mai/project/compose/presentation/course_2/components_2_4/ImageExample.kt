package mai.project.compose.presentation.course_2.components_2_4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.R
import mai.project.compose.presentation.home.components.CourseHintText
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ImageExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        CourseHintText(text = "圖片來源：Painter Resource")
        Image(
            painter = painterResource(id = R.drawable.landscape1),
            contentDescription = null
        )

        CourseHintText(text = "圖片來源：Image Vector")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                colorFilter = ColorFilter.tint(Color.Yellow)
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.vd_clock_alarm),
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
            )
        }

        CourseHintText(text = "圖片來源：Bitmap")
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.landscape2),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ImageExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ImageExample()
    }
}