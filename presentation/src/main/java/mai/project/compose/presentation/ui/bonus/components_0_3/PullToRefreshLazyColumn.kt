@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.bonus.components_0_3

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.BasicText
import kotlin.math.roundToInt

@Composable
fun <T> PullToRefreshLazyColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    items: List<T>,
    isRefreshing: Boolean,
    isLoadingMore: Boolean,
    isLoadFinished: Boolean,
    onRefresh: () -> Unit,
    onLoadMore: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
    refreshState: PullToRefreshState = rememberPullToRefreshState(),
    headerContent: (@Composable () -> Unit)? = null,
    footerContent: (@Composable () -> Unit)? = null,
    itemContent: @Composable (T) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .pullToRefresh(
                threshold = 100.dp,
                state = refreshState,
                isRefreshing = isRefreshing,
                onRefresh = onRefresh
            )
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            state = lazyListState,
        ) {
            // Header
            item {
                if (headerContent != null) {
                    headerContent()
                } else {
                    DefaultHeaderContent(
                        pullDistanceFraction = refreshState.distanceFraction,
                        isRefreshing = isRefreshing
                    )
                }
            }

            // Content
            itemsIndexed(items) { index, item ->
                itemContent(item)
                if (items.isNotEmpty() &&
                    index == items.size - 1 &&
                    !isLoadFinished &&
                    !isLoadingMore
                ) {
                    // 避免無限次的觸發
                    LaunchedEffect(items.size) {
                        onLoadMore()
                    }
                }
            }

            // Footer
            if (isLoadingMore) {
                item {
                    if (footerContent != null) {
                        footerContent()
                    } else {
                        DefaultFooterContent()
                    }
                }
            }
        }

        if (items.isEmpty() && !isRefreshing) {
            DefaultEmptyContent()
        }
    }
}

@Composable
private fun DefaultHeaderContent(
    pullDistanceFraction: Float,
    isRefreshing: Boolean,
) {
    val rowHeight by animateDpAsState(
        targetValue = if (isRefreshing) 56.dp else (pullDistanceFraction * 50).roundToInt().dp,
        label = "HeaderHeightAnimation"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(rowHeight)
            .padding(top = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        if (pullDistanceFraction >= 1 || isRefreshing) {
            CircularProgressIndicator(
                modifier = Modifier.size(30.dp)
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun DefaultFooterContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
private fun DefaultEmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(100.dp),
            imageVector = ImageVector.vectorResource(R.drawable.vector_sad),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )
        BasicText(
            text = "Empty",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@PreviewLightDark
@Composable
private fun PullToRefreshLazyColumnPreview() {
    Jetpack_Compose_LearningTheme {
        PullToRefreshLazyColumn(
            items = (0..20).toList(),
            isRefreshing = false,
            isLoadingMore = false,
            isLoadFinished = false,
            onRefresh = {},
            onLoadMore = {},
        ) { item ->
            ListItem(
                modifier = Modifier,
                headlineContent = {
                    Text(text = "User - $item")
                },
                leadingContent = {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                }
            )
        }
    }
}
