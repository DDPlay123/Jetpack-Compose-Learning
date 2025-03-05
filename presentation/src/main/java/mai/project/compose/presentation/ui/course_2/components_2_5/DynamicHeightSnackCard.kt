package mai.project.compose.presentation.ui.course_2.components_2_5

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import mai.project.compose.core.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.model.Snack
import mai.project.compose.presentation.ui.course_2.model.snacks
import timber.log.Timber

@Composable
fun DynamicHeightSnackCard(
    modifier: Modifier = Modifier,
    snack: Snack
) {
    Card(
        modifier = modifier
            .heightIn(min = 200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = {}
    ) {
        val density = LocalDensity.current.density

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = snack.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder)
        )

        var padding by remember { mutableStateOf(0.dp) }

        Text(
            modifier = Modifier.padding(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = padding
            ),
            text = snack.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            onTextLayout = {
                val lineCount = it.lineCount
                val height = (it.size.height / density).dp

                Timber.d(message = "lineCount: $lineCount, Height: $height")
                padding = if (lineCount > 1) 8.dp else height
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun DynamicHeightSnackCardPreview() {
    Jetpack_Compose_LearningTheme {
        DynamicHeightSnackCard(snack = snacks.first())
    }
}