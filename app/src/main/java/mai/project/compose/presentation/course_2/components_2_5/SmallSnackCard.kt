package mai.project.compose.presentation.course_2.components_2_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import mai.project.compose.R
import mai.project.compose.presentation.course_2.model.Snack
import mai.project.compose.presentation.course_2.model.snacks
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme
import kotlin.random.Random

@Composable
fun SmallSnackCard(
    modifier: Modifier = Modifier,
    snack: Snack,
    isFavorite: Boolean = false,
    onFavoriteChange: (Boolean) -> Unit = {}
) {
    val randomColor = remember(snack.id) {
        Color(
            Random.nextInt(255),
            Random.nextInt(255),
            Random.nextInt(255)
        )
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = {}
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            AsyncImage(
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(150.dp),
                model = snack.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )

            FavoriteButton(
                tintColor = randomColor,
                isFavorite = isFavorite,
                onCheckedChange = { onFavoriteChange(!isFavorite) }
            )
        }

        Text(
            color = randomColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = snack.name,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun SmallSnackCardPreview() {
    Jetpack_Compose_LearningTheme {
        SmallSnackCard(snack = snacks.first())
    }
}