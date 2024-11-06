package mai.project.compose.presentation.course_2.components_2_5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.course_2.model.Place
import mai.project.compose.presentation.course_2.model.places
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun PlaceCard(
    modifier: Modifier = Modifier,
    place: Place
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = {}
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = painterResource(id = place.imgRes),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = place.description,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(8.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PlaceCardPreview() {
    Jetpack_Compose_LearningTheme {
        PlaceCard(place = places.first())
    }
}