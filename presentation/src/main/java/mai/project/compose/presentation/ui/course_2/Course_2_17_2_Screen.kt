@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_17_2_ScreenRoot() {
    Course_2_17_2_Screen()
}

@Composable
private fun Course_2_17_2_Screen(
    modifier: Modifier = Modifier,
) {
    val state = rememberPullToRefreshState()
    val viewModel = remember {
        object : ViewModel() {
            private val refreshRequests = Channel<Unit>(1)
            var isRefreshing by mutableStateOf(false)
                private set
            var itemCount by mutableIntStateOf(15)
                private set

            init {
                viewModelScope.launch {
                    for (request in refreshRequests) {
                        isRefreshing = true
                        try {
                            itemCount += 5
                            delay(1000)
                        } finally {
                            isRefreshing = false
                        }
                    }
                }
            }

            fun refresh() {
                refreshRequests.trySend(Unit)
            }
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Title")
                },
                actions = {
                    IconButton(
                        enabled = !viewModel.isRefreshing,
                        onClick = { viewModel.refresh() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Trigger Refresh"
                        )
                    }
                }
            )
        }
    ) { padding ->
        PullToRefreshBox(
            modifier = Modifier.padding(padding),
            state = state,
            isRefreshing = viewModel.isRefreshing,
            onRefresh = { viewModel.refresh() }
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                if (!viewModel.isRefreshing) {
                    items(viewModel.itemCount) {
                        ListItem(
                            headlineContent = {
                                Text("Item ${viewModel.itemCount - it}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_17_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_17_2_Screen()
    }
}