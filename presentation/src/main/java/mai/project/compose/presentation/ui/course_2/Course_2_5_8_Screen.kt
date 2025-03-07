package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_5_8_ScreenRoot() {
    Course_2_5_8_Screen()
}

@Composable
private fun Course_2_5_8_Screen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseTitleText(text = "LazyListLayoutInfo")
        CourseContentText(
            text = "LazyListLayoutInfo 是在佈局計算時產生的，你可以用它來計算當前可見的項目。\n" +
                    "需要注意，這個物件屬性是可觀察的，並且會在每次滾動或重新測量後更新。如果你在可組合函式 (composable function) 中使用它，每次變更時都會觸發重新組合 (recomposition)，可能會導致效能問題，例如無限重新組合的情況。因此，建議避免在組合中直接使用它。\n" +
                    "如果你需要根據此值執行一些副作用 (Side Effects)，例如發送分析事件或更新狀態，請考慮使用 snapshotFlow。",
            bullets = false
        )

        val scrollState = rememberLazyListState()
        val startPadding = remember { mutableFloatStateOf(0f) }
        val endPadding = remember { mutableFloatStateOf(0f) }

        LazyRow(
            modifier = Modifier,
            state = scrollState,
            contentPadding = PaddingValues(
                start = startPadding.floatValue.toInt().dp,
                end = endPadding.floatValue.toInt().dp,
                top = 0.dp,
                bottom = 0.dp
            )
        ) {
            items(10) { index ->
                Text(
                    modifier = Modifier
                        .background(Color.Red, RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    text = "Item：$index",
                    fontSize = 22.sp,
                    color = Color.White
                )
                if (index < 10)
                    Spacer(modifier = Modifier.width(4.dp))
            }
        }

        CourseContentText(
            text = "Start Padding ${startPadding.floatValue.toInt()}.dp",
            bullets = false
        )
        Slider(
            modifier = Modifier.padding(horizontal = 8.dp),
            value = startPadding.floatValue,
            valueRange = 0f..50f,
            onValueChange = { startPadding.floatValue = it }
        )

        CourseContentText(
            text = "End Padding ${endPadding.floatValue.toInt()}.dp",
            bullets = false
        )
        Slider(
            modifier = Modifier.padding(horizontal = 8.dp),
            value = endPadding.floatValue,
            valueRange = 0f..50f,
            onValueChange = { endPadding.floatValue = it }
        )

        val info = remember {
            derivedStateOf {
                val lazyLayoutInfo = scrollState.layoutInfo
                val visibleItemsInfo = lazyLayoutInfo.visibleItemsInfo
                val viewportSize = lazyLayoutInfo.viewportSize
                val viewportStartOffset = lazyLayoutInfo.viewportStartOffset
                val viewportEndOffset = lazyLayoutInfo.viewportEndOffset
                val beforeContentPadding = lazyLayoutInfo.beforeContentPadding
                val afterContentPadding = lazyLayoutInfo.afterContentPadding

                var tempText = "firstVisibleItemIndex: ${scrollState.firstVisibleItemIndex}\n" +
                    "firstVisibleItemScrollOffset: ${scrollState.firstVisibleItemScrollOffset}\n" +
                    "viewportSize: $viewportSize\n" +
                    "viewportStartOffset: $viewportStartOffset\n" +
                    "viewportEndOffset: $viewportEndOffset\n" +
                    "beforeContentPadding: $beforeContentPadding\n" +
                    "afterContentPadding: $afterContentPadding\n"

                val visibleItemSize = visibleItemsInfo.size

                tempText += "visibleItemsInfo size: $visibleItemSize\n"

                visibleItemsInfo.forEach { lazyListItemInfo: LazyListItemInfo ->
                    val index = lazyListItemInfo.index
                    val offset = lazyListItemInfo.offset
                    val size = lazyListItemInfo.size
                    tempText += "index: $index, offset: $offset, size: $size\n"
                }

                tempText
            }
        }

        CourseHintText(text = info.value)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_8_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_8_Screen()
    }
}