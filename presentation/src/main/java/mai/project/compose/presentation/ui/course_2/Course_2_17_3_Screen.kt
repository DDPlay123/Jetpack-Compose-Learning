@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
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
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_17_3_ScreenRoot() {
    Course_2_17_3_Screen()
}

@Composable
private fun Course_2_17_3_Screen(
    modifier: Modifier = Modifier,
) {
    var itemCount by remember { mutableIntStateOf(15) }
    var isRefreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val onRefresh: () -> Unit = {
        isRefreshing = true
        scope.launch {
            delay(1500)
            itemCount += 5
            isRefreshing = false
        }
    }

    val state = remember {
        object : PullToRefreshState {
            private val anim = Animatable(0f, Float.VectorConverter)

            override val distanceFraction get() = anim.value

            override val isAnimating: Boolean = true

            override suspend fun animateToThreshold() {
                anim.animateTo(1f, spring(dampingRatio = Spring.DampingRatioHighBouncy))
            }

            override suspend fun animateToHidden() {
                anim.animateTo(0f)
            }

            override suspend fun snapTo(targetValue: Float) {
                anim.snapTo(targetValue)
            }
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar")
                },
                actions = {
                    IconButton(
                        onClick = onRefresh
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
            isRefreshing = isRefreshing,
            onRefresh = onRefresh
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                if (!isRefreshing) {
                    items(itemCount) {
                        ListItem(
                            headlineContent = {
                                Text(text = "Item ${itemCount - it}")
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
private fun Course_2_17_3_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_17_3_Screen()
    }
}