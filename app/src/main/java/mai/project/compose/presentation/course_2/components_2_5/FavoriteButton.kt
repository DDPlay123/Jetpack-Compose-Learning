package mai.project.compose.presentation.course_2.components_2_5

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = onCheckedChange
    ) {
        Icon(
            tint = Color(0xffE91E63),
            modifier = modifier.graphicsLayer(
                scaleX = 1.3f,
                scaleY = 1.3f
            ),
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    Jetpack_Compose_LearningTheme {
        FavoriteButton()
    }
}