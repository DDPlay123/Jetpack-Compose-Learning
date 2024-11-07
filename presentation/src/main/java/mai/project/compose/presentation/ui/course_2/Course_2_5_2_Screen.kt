package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.ui.course_2.components_2_5.SnackCard
import mai.project.compose.presentation.ui.course_2.model.Snack
import mai.project.compose.presentation.ui.course_2.model.snacks
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_5_2_ScreenRoot() {
    Course_2_5_2_Screen()
}

@Composable
private fun Course_2_5_2_Screen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val items = remember { mutableStateListOf<Pair<Snack, Boolean>>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = scrollState,
            contentPadding = PaddingValues(
                horizontal = 12.dp,
                vertical = 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.size) { index ->
                SnackCard(
                    snack = items[index].first,
                    isFavorite = items[index].second,
                    onFavoriteChange = { newState ->
                        items[index] = items[index].copy(second = newState)
                    }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    coroutineScope.launch { scrollState.animateScrollToItem(index = 0) }
                }
            ) {
                Text(text = "置頂")
            }

            Button(
                onClick = {
                    coroutineScope.launch { scrollState.animateScrollToItem(index = items.lastIndex) }
                }
            ) {
                Text(text = "置底")
            }

            Button(
                onClick = {
                    if (items.size < snacks.size)
                        coroutineScope.launch {
                            items.add(snacks[items.size] to false)
                            scrollState.animateScrollToItem(index = items.lastIndex)
                        }
                }
            ) {
                Text(text = "新增")
            }

            Button(
                onClick = {
                    if (items.size > 0)
                        items.removeLastOrNull()
                }
            ) {
                Text(text = "移除")
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_2_Screen()
    }
}