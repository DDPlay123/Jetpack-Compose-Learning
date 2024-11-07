package mai.project.compose.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseItems
import mai.project.compose.presentation.ui.home.model.TabItem
import mai.project.compose.presentation.ui.home.model.getHomeTab

@Composable
fun HomeScreenRoot(
    onCourseClick: (TabItem.Course) -> Unit
) {
    HomeScreen(
        tabItems = getHomeTab,
        onCourseClick = onCourseClick
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    tabItems: List<TabItem>,
    onCourseClick: (TabItem.Course) -> Unit
) {
    // HorizontalPager 的狀態
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { tabItems.size }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = pagerState.currentPage
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = item.title) },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
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
            CourseItems(
                courses = tabItems[index].courses,
                onItemClick = onCourseClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    Jetpack_Compose_LearningTheme {
        HomeScreen(
            tabItems = getHomeTab,
            onCourseClick = {}
        )
    }
}