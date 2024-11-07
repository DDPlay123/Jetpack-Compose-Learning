package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.course_2.components_2_5.PlaceCard
import mai.project.compose.presentation.ui.course_2.components_2_5.PlaceDetailCard
import mai.project.compose.presentation.ui.course_2.components_2_5.SmallSnackCard
import mai.project.compose.presentation.ui.course_2.model.places
import mai.project.compose.presentation.ui.course_2.model.snacks
import mai.project.compose.presentation.ui.home.components.CourseTitleText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_5_3_ScreenRoot() {
    Course_2_5_3_Screen()
}

@Composable
private fun Course_2_5_3_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val snackFavoriteStates = remember {
            mutableStateListOf<Boolean>()
        }.apply {
            addAll(snacks.map { false })
        }
        CourseTitleText(text = "Snacks")
        DefaultLazyRow {
            items(snacks.size) { index ->
                SmallSnackCard(
                    snack = snacks[index],
                    isFavorite = snackFavoriteStates[index],
                    onFavoriteChange = { newState ->
                        snackFavoriteStates[index] = newState
                    }
                )
            }
        }

        CourseTitleText(text = "Places")
        DefaultLazyRow {
            items(places) { place ->
                PlaceCard(place = place)
            }
        }

        val placeFavoriteStates = remember {
            mutableStateListOf<Boolean>()
        }.apply {
            addAll(places.map { false })
        }
        CourseTitleText(text = "Places to Visit")
        DefaultLazyRow {
            items(places.size) { index ->
                PlaceDetailCard(
                    place = places[index],
                    isFavorite = placeFavoriteStates[index],
                    onFavoriteChange = { newState ->
                        placeFavoriteStates[index] = newState
                    }
                )
            }
        }
    }
}

@Composable
private fun DefaultLazyRow(
    content: LazyListScope.() -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}

@PreviewLightDark
@Composable
private fun Course_2_5_3_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_3_Screen()
    }
}