@file:OptIn(ExperimentalGlideComposeApi::class)

package mai.project.compose.presentation.ui.course_2.components_2_4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun GlideLoadExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        val imageUrl =
            "https://avatars3.githubusercontent.com/u/35650605?s=400&u=058086fd5c263f50f2fbe98ed24b5fbb7d437a4e&v=4"

        GlideImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
private fun GlideLoadExamplePreview() {
    Jetpack_Compose_LearningTheme {
        GlideLoadExample()
    }
}