package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
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
    // HorizontalPager 的狀態
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { 3 }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            (0..2).forEach { index ->
                Tab(
                    selected = pagerState.currentPage == index,
                    text = {
                        when (index) {
                            0 -> Text(text = "Fixed")
                            1 -> Text(text = "Adaptive")
                            else -> Text(text = "FixedSize")
                        }
                    },
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                columns = when (index) {
                    0 -> GridCells.Fixed(3)
                    1 -> GridCells.Adaptive(minSize = 128.dp)
                    else -> GridCells.FixedSize(100.dp)
                },
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(snacks) { snack ->
                    SmallSnackCard(snack = snack)
                }
            }
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