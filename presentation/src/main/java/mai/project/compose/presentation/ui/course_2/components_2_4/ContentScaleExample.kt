package mai.project.compose.presentation.ui.course_2.components_2_4

import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.core.R
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ContentScaleExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        SampleImage(
            ratio = 4 / 3f,
            imageId = R.drawable.landscape10
        )
        SampleImage(
            ratio = 1f,
            imageId = R.drawable.landscape5
        )
    }
}

@Composable
private fun SampleImage(
    @FloatRange(from = 0.0, fromInclusive = false)
    ratio: Float,
    @DrawableRes
    imageId: Int
) {
    val imgMd = Modifier
        .fillMaxWidth()
        .aspectRatio(ratio)
        .background(Color.LightGray)
    val painter = painterResource(id = imageId)

    CourseHintText(text = "Original")
    Image(
        painter = painter,
        contentDescription = null
    )

    CourseHintText(text = "ContentScale.None")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.None
    )

    CourseHintText(text = "ContentScale.Crop")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.Crop
    )

    CourseHintText(text = "ContentScale.FillBounds")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.FillBounds
    )

    CourseHintText(text = "ContentScale.FillWidth")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.FillWidth
    )

    CourseHintText(text = "ContentScale.FillHeight")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.FillHeight
    )

    CourseHintText(text = "ContentScale.Fit")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.Fit
    )

    CourseHintText(text = "ContentScale.Inside")
    Image(
        painter = painter,
        contentDescription = null,
        modifier = imgMd,
        contentScale = ContentScale.Inside
    )
}

@Preview
@Composable
private fun ContentScaleExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ContentScaleExample()
    }
}