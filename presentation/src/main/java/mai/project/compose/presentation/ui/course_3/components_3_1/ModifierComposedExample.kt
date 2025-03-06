package mai.project.compose.presentation.ui.course_3.components_3_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseHintText
import kotlin.random.Random

fun Modifier.composedBackground(
    width: Dp, height: Dp, index: Int,
) = composed(
    // Debug 資訊 (可在 Layout Inspector 檢查)
    inspectorInfo = debugInspectorInfo {
        name = "composedBackground"
        properties["width"] = width
        properties["height"] = height
        properties["index"] = index
    },
    // 產生 Modifier 方法的地方
    factory = {
        // 其實不需要取得 LocalDensity，此處是為了示範取得 LocalXXX 的方式
        val density = LocalDensity.current

        // 只有 index 改變時，顏色才會改變
        val color: Color = remember(index) {
            Color(
                red = Random.nextInt(256),
                green = Random.nextInt(256),
                blue = Random.nextInt(256)
            )
        }

        Modifier.drawBehind {
            val widthInPx = with(density) { width.toPx() }
            val heightInPx = with(density) { height.toPx() }

            drawRect(color = color, topLeft = Offset.Zero, size = Size(widthInPx, heightInPx))
        }
    }
)

fun Modifier.nonComposedBackground(
    width: Dp, height: Dp
) = then(
    // NOTE 無法使用 remember 等 composable 的狀態
    Modifier.drawBehind {
        val color = Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256)
        )

        val widthInPx = width.toPx()
        val heightInPx = height.toPx()

        drawRect(color = color, topLeft = Offset.Zero, size = Size(widthInPx, heightInPx))
    }
)

@Composable
fun ModifierComposedExample(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var count by remember { mutableIntStateOf(0) }

        Button(
            onClick = { count++ },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = "Click me: $count")
        }

        CourseHintText(text = "Modifier.composed\n由於 index 固定，所以顏色不會改變")

        Box(
            modifier = Modifier
                .composedBackground(150.dp, 20.dp, 0)
                .width(150.dp)
        ) {
            Text(text = "Recomposed $count")
        }

        CourseHintText(text = "Modifier that is not composed\n每次點擊，顏色都會改變")

        Box(
            modifier = Modifier
                .nonComposedBackground(150.dp, 20.dp)
                .width(150.dp)
        ) {
            Text(text = "Recomposed $count")
        }
    }
}

@PreviewLightDark
@Composable
private fun ModifierComposedExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ModifierComposedExample()
    }
}