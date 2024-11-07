package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.course_2.components_2_5.SnackCard
import mai.project.compose.presentation.ui.course_2.model.Snack
import mai.project.compose.presentation.ui.course_2.model.snacks
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_5_1_ScreenRoot() {
    Course_2_5_1_Screen()
}

@Composable
private fun Course_2_5_1_Screen(
    modifier: Modifier = Modifier,
    items: List<Snack> = snacks
) {
    val favoriteStates = remember {
        mutableStateListOf<Boolean>()
    }.apply {
        addAll(items.map { false })
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            SnackCard(
                snack = items[index],
                isFavorite = favoriteStates[index],
                onFavoriteChange = { newState ->
                    favoriteStates[index] = newState
                }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_1_Screen()
    }
}