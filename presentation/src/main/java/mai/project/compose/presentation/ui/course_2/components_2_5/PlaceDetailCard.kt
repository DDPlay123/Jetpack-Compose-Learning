package mai.project.compose.presentation.ui.course_2.components_2_5

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.ui.course_2.model.Place
import mai.project.compose.presentation.ui.course_2.model.places
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import java.text.DecimalFormat

@Composable
fun PlaceDetailCard(
    modifier: Modifier = Modifier,
    place: Place,
    isFavorite: Boolean = false,
    onFavoriteChange: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier.width(250.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = {}
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text(
                    text = place.description,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                StarRatingBar(rating = place.properties.starRating.toFloat())
                Spacer(modifier = Modifier.height(4.dp))
                PropertiesCard(
                    modifier = Modifier,
                    place = place
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$${place.price}",
                        color = Color(0xff4CAF50)
                    )
                }
            }

            ImageAndFavoriteButton(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                imgRes = place.imgRes,
                isFavorite = isFavorite,
                onFavoriteChange = onFavoriteChange
            )
        }
    }
}

@Composable
private fun PropertiesCard(
    modifier: Modifier,
    place: Place
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(4.dp),
            color = place.properties.color
        ) {
            Text(
                text = DecimalFormat("0.0").format(place.rating),
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
            )
        }
        Text(
            text = place.properties.comment,
            color = place.properties.color,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun ImageAndFavoriteButton(
    modifier: Modifier,
    @DrawableRes
    imgRes: Int,
    isFavorite: Boolean,
    onFavoriteChange: (Boolean) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = imgRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Surface(
            shape = CircleShape,
            color = Color(0x77000000),
            modifier = Modifier
                .padding(8.dp)
        ) {
            FavoriteButton(
                isFavorite = isFavorite,
                onCheckedChange = { onFavoriteChange(!isFavorite) }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PlaceDetailCardPreview() {
    Jetpack_Compose_LearningTheme {
        PlaceDetailCard(place = places.first())
    }
}