package mai.project.compose.presentation.ui.course_3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_3_1_2_ScreenRoot() {
    Course_3_1_2_Screen()
}

@Composable
private fun Course_3_1_2_Screen(
    modifier: Modifier = Modifier,
) {
    val textMeasurer = rememberTextMeasurer()
    var marksWidth by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            // 繪製內容（只在背景）
            // -> 每次重組都會執行
            .drawBehind {
                // 畫在 Composable 內容之下
                drawHeightMarks(textMeasurer) { width ->
                    if (marksWidth != width) {
                        marksWidth = width
                    }
                }
            }
//            // 繪製內容（可在內容前後插入）
//            // -> 每次重組都會執行
//            .drawWithContent {
//                inBottomContent() // 畫在內容之前（背景）
//                drawContent()     // 原始 Composable 內容
//                inTopContent()    // 畫在內容之上（前景）
//            }
//            // 繪製內容（帶 Cache 機制）
//            .drawWithCache {
//                // Cache 區塊：
//                // -> 只會在第一次或依賴改變（colors 改變）時執行
//                val gradient = Brush.linearGradient(colors)
//
//                // Method 1：
//                // -> 每次重組都執行
//                // -> 可畫在內容前後（支援 drawContent）
//                onDrawWithContent {
//                    inBottomContent() // 背景
//                    drawContent()     // 原始內容
//                    inTopContent()    // 前景
//                }
//
//                // Method 2：
//                // -> 每次重組都執行
//                // -> 只畫背景（不可畫內容）
//                onDrawBehind {
//                    inBottomContent() // 背景
//                }
//            }
    ) {
        val density = LocalDensity.current
        Content(
            modifier = Modifier.padding(start = with(density) { marksWidth.toDp() + 8.dp })
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current

    var box1Position by remember { mutableStateOf(Offset.Zero) }
    var box2Position by remember { mutableStateOf(Offset.Zero) }

    Column(
        modifier = modifier
    ) {
        CourseTitleText(
            text = "onGloballyPositioned"
        )
        CourseContentText(
            text = "onGloballyPositioned 可取得 Composable 相對於父層、根層或 window（含狀態列、導航列偏移）的座標位置。",
            bullets = false,
            textAlign = null
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.primary)
                .onGloballyPositioned { coordinates ->
                    box1Position = coordinates.positionInWindow()
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "高度：${with(density) { 100.dp.toPx() }} px\n" +
                        "positionInWindow\n" +
                        "-左上位置：$box1Position",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 4.dp,
                    color = Color.Green,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Yellow)
                    .onGloballyPositioned { coordinates ->
                        box2Position = coordinates.positionInWindow()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "高度：${with(density) { 150.dp.toPx() }}px\n" +
                            "positionInWindow\n-左上位置：$box2Position",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            DetailContent()
        }
    }
}

@Composable
private fun DetailContent() {
    val density = LocalDensity.current
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
            .border(1.dp, Color.Red)
            .onGloballyPositioned {
                // 該元件相對於父層左上角 (0,0) 的偏移位置
                val positionInParent: Offset = it.positionInParent()
                // 該元件相對於根層 (setContent {} 的最外層) 左上角的偏移位置。
                val positionInRoot: Offset = it.positionInRoot()
                // 該元件相對於螢幕 Window 左上角的偏移位置，包含 StatusBar、NavigationBar 等系統欄位的高度。
                val positionInWindow: Offset = it.positionInWindow()

                // 該元件相對於在父層座標系統中的完整範圍 (包含大小、位置)。
                val boundsInParent: Rect = it.boundsInParent()
                // 該元件相對於在根層座標中的完整範圍。
                val boundsInRoot: Rect = it.boundsInRoot()
                // 該元件相對於在螢幕 Window 座標中的完整範圍 (包含系統欄位偏移)。
                val boundsInWindow: Rect = it.boundsInWindow()

                /*
                 * Column ← (parentLayoutCoordinates)
                    │
                    └── Modifier.offset(10.dp) ← (parentCoordinates)
                        │
                        └── Box (你的 Composable)
                * */

                // parentCoordinates：
                // - 抓父層元件的相對位置，不是該元件
                // - 若父層有 LayoutModifier（如 Modifier.offset、padding 等），則為該 Modifier 應用後的座標。
                // - 若父層沒有 LayoutModifier，則與 parentLayoutCoordinates 相同。
                val parentCoordinates = it.parentCoordinates

                // parentLayoutCoordinates：
                // - 抓父層元件的相對位置，不是該元件
                // - 始終是父層 Layout（如 Column、Row 等）的座標。
                // - 不受 Modifier 影響，只是 Layout 結構的層級位置。
                val parentLayoutCoordinates = it.parentLayoutCoordinates

                // 整體結構大概為以下：
                /*
                 (由於啟用 EdgeToEdge Mode，所以 Window 和 Root 的起點相同)

                  Window ←---- (positionInWindow, boundsInWindow)
                   │
                   └── Root Column (modifier.fillMaxSize()) ←---- (positionInRoot, boundsInRoot)
                        │
                        ├── Column (父層A)
                        │   ├── Text
                        │   ├── Text
                        │   ├── Box (modifier.fillMaxWidth().height(100.dp))
                        │   └── Column (父層B, modifier.fillMaxWidth()) ←----
                        │            (MyColumn 的 positionInParent, boundsInParent 計算基準)
                        │            (parentCoordinates：包含自身 Modifier，例如 padding、offset)
                        │            (parentLayoutCoordinates：不含自身 Modifier)
                        │       ├── Box (modifier.fillMaxWidth().height(150.dp))
                        │       └── MyColumn (modifier.fillMaxWidth().wrapContentHeight().border(1.dp, Color.Red))
                */

                text = "使用 padding-all：16.dp => ${with(density) { 16.dp.toPx().toInt() }}px\n\n"

                text +=
                    "- onGloballyPositioned:\n" +
                            "positionInParent：$positionInParent\n" +
                            "positionInRoot：$positionInRoot\n" +
                            "positionInWindow：$positionInWindow\n----\n" +
                            "boundsInParent：$boundsInParent\n" +
                            "boundsInRoot：$boundsInRoot\n" +
                            "boundsInWindow：$boundsInWindow\n----\n"

                parentCoordinates?.let { parent ->
                    text +=
                        "- parentCoordinates:\n" +
                                "positionInParent：${parent.positionInParent()}\n" +
                                "positionInRoot：${parent.positionInRoot()}\n" +
                                "positionInWindow：${parent.positionInWindow()}\n----\n"
                }

                parentLayoutCoordinates?.let { parent ->
                    text +=
                        "- parentLayoutCoordinates:\n" +
                                "positionInParent：${parent.positionInParent()}\n" +
                                "positionInRoot：${parent.positionInRoot()}\n" +
                                "positionInWindow：${parent.positionInWindow()}\n"
                }
            }
    ) {
        Text(text = text)
    }
}

// 繪製刻度 (單位為 Pixel)
private fun DrawScope.drawHeightMarks(
    textMeasurer: TextMeasurer,
    onMaxWidth: (Float) -> Unit = {},
) {
    val height = size.height.toInt()
    var maxWidth = 0f

    for (i in 0..height step 100) {
        if (i != 0) {
            val text = "$i"
            val textLayoutResult = textMeasurer.measure(
                text = text,
                style = TextStyle(color = Color.Red, fontWeight = FontWeight.Bold)
            )

            val textWidth = textLayoutResult.size.width.toFloat()
            val lineWidth = 80f
            val baseline = textLayoutResult.firstBaseline

            maxWidth = maxOf(maxWidth, lineWidth, textWidth)

            drawLine(
                color = Color.Red,
                start = Offset(0f, i.toFloat()),
                end = Offset(lineWidth, i.toFloat()),
                strokeWidth = 3.dp.toPx()
            )

            drawText(
                textMeasurer = textMeasurer,
                text = text,
                topLeft = Offset(
                    x = 0f,
                    y = i - baseline - 10f
                ),
                style = TextStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

    onMaxWidth(maxWidth)
}

@PreviewLightDark
@Composable
private fun Course_3_1_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_3_1_2_Screen()
    }
}