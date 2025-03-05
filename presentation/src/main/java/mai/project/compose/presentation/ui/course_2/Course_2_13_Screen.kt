package mai.project.compose.presentation.ui.course_2

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_13_ScreenRoot() {
    Course_2_13_Screen()
}

@Composable
private fun Course_2_13_Screen(
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val scrollState = rememberLazyListState()
    val users = remember { mutableStateListOf<String>() }

    // 紀錄最近刪除的 Item
    var recentlyDeletedUser by remember { mutableStateOf<String?>(null) }
    var recentlyDeletedIndex by remember { mutableIntStateOf(-1) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    // 錯誤：這樣會造成多次重組
//                users.clear()
//                (0..20).forEach {
//                    users.add("User - $it")
//                }
                    // 正確：合併操作
                    users.apply {
                        clear()
                        addAll(List(21) { "User - $it" })
                    }
                }
            ) {
                Text(text = "重置")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                state = scrollState,
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = users,
                    key = { it }
                ) { user ->

                    // 滑動刪除 (右至左)
                    val dismissState = rememberSwipeToDismissBoxState(
                        confirmValueChange = {
                            if (it == SwipeToDismissBoxValue.EndToStart) {
                                // 先暫存刪除的 Item
                                recentlyDeletedUser = user
                                recentlyDeletedIndex = users.indexOf(user)

                                users.remove(user)

                                scope.launch {
                                    snackbarHostState.currentSnackbarData?.dismiss()
                                    val result = snackbarHostState.showSnackbar(
                                        message = "$recentlyDeletedUser 已刪除",
                                        actionLabel = "撤銷",
                                        duration = SnackbarDuration.Short
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {
                                        recentlyDeletedUser?.let { deleted ->
                                            users.add(recentlyDeletedIndex, deleted)
                                        }
                                    }
                                }
                            }
                            true
                        },
                        positionalThreshold = { totalDistance ->
                            // 滑動 Item 一半才觸發
                            totalDistance * .5f
                        }
                    )

                    val backgroundColor by animateColorAsState(
                        when (dismissState.targetValue) {
                            SwipeToDismissBoxValue.EndToStart -> Color.Red
                            else -> Color.LightGray
                        }
                    )

                    SwipeToDismissBox(
                        modifier = Modifier
                            // 動畫效果
                            .animateItem(
                                placementSpec = spring(),
                                fadeInSpec = tween(300),
                                fadeOutSpec = tween(300)
                            ),
                        state = dismissState,
                        enableDismissFromEndToStart = true,
                        enableDismissFromStartToEnd = false,
                        backgroundContent = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(backgroundColor),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.White,
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                            }
                        }
                    ) {
                        ListItem(
                            modifier = Modifier
                                .fillMaxWidth(),
                            headlineContent = { Text(text = user) },
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
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_13_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_13_Screen()
    }
}