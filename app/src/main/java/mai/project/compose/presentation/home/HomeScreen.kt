@file:OptIn(ExperimentalFoundationApi::class)

package mai.project.compose.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.model.TabItem
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun HomeScreenRoot() {
    HomeScreen(TabItem.getHomeTab)
}

@Composable
private fun HomeScreen(
    tabItems: List<TabItem>
) {
    // HorizontalPager 的狀態
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { tabItems.size }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tabItems[index].title,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    Jetpack_Compose_LearningTheme {
        HomeScreen(TabItem.getHomeTab)
    }
}