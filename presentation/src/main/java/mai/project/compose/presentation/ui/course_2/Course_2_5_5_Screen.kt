package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_5.SmallSnackCard
import mai.project.compose.presentation.ui.course_2.model.snacks

@Composable
fun Course_2_5_5_ScreenRoot() {
    Course_2_5_5_Screen()
}

@Composable
private fun Course_2_5_5_Screen(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(snacks) { snack ->
            SmallSnackCard(
                snack = snack
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_5_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_5_Screen()
    }
}