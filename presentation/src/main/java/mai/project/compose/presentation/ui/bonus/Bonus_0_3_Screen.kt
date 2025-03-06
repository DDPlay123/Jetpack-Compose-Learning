@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.bonus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.bonus.components_0_3.PullToRefreshLazyColumn
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun Bonus_0_3_ScreenRoot(
    viewModel: Bonus03ViewModel = koinViewModel()
) {
    Bonus_0_3_Screen(
        items = viewModel.items.collectAsStateWithLifecycle().value,
        isRefreshing = viewModel.isRefreshing,
        isLoadingMore = viewModel.isLoadingMore,
        isLoadFinished = viewModel.isLoadFinished,
        onRefresh = viewModel::refresh,
        onLoadMore = viewModel::loadMore
    )
}

@Composable
private fun Bonus_0_3_Screen(
    modifier: Modifier = Modifier,
    items: List<Int> = emptyList(),
    isRefreshing: Boolean = false,
    isLoadingMore: Boolean = false,
    isLoadFinished: Boolean = false,
    onRefresh: () -> Unit = {},
    onLoadMore: () -> Unit = {},
) {
    val lazyListState = rememberLazyListState()
    val refreshState = rememberPullToRefreshState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        PullToRefreshLazyColumn(
            modifier = Modifier,
            items = items,
            isRefreshing = isRefreshing,
            isLoadingMore = isLoadingMore,
            isLoadFinished = isLoadFinished,
            onRefresh = onRefresh,
            onLoadMore = onLoadMore,
            lazyListState = lazyListState,
            refreshState = refreshState
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

@PreviewLightDark
@Composable
private fun Bonus_0_3_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Bonus_0_3_Screen(
            items = (0..20).toList()
        )
    }
}

class Bonus03ViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<Int>>(emptyList())
    val items = _items.asStateFlow()

    var isRefreshing by mutableStateOf(false)
        private set
    var isLoadingMore by mutableStateOf(false)
        private set
    var isLoadFinished by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
//            _items.value = (1..20).toList()
        }
    }

    fun refresh() {
        Timber.d(message = "Refresh")
        viewModelScope.launch {
            isRefreshing = true
            delay(1000)
            _items.update { (1..20).toList() }
            isRefreshing = false
            isLoadFinished = false
        }
    }

    fun loadMore() {
        if (isLoadingMore || isLoadFinished) return
        Timber.d(message = "LoadMore")
        viewModelScope.launch {
            isLoadingMore = true
            delay(1000)
            val nextItems = (items.value.size + 1)..(items.value.size + 20)
            if (nextItems.last > 100) {
                isLoadFinished = true
            } else {
                _items.update { it + nextItems.toList() }
            }
            isLoadingMore = false
        }
    }
}