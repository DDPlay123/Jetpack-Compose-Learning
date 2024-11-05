@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.course_2.components_2_4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.R
import mai.project.compose.presentation.home.components.CourseHintText
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ImageGraphicLayerExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        val avatarBitmap1 = painterResource(id = R.drawable.avatar_1_raster)

        CourseHintText(text = "旋轉 Rotate")
        FlowRow(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        rotationX = 45f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        rotationY = 45f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        rotationZ = 45f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        rotationX = 45f,
                        rotationY = 45f,
                        rotationZ = 45f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
        }

        CourseHintText(text = "縮放 Scale, 透明 Alpha, 位移 Translate, 視覺感 CameraDistance")
        FlowRow(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        scaleX = .8f,
                        scaleY = .8f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        alpha = .5f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        translationX = 18f,
                        translationY = 18f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        cameraDistance = 2f,
                        rotationX = 30f
                    ),
                painter = avatarBitmap1,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun ImageGraphicLayerExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ImageGraphicLayerExample()
    }
}