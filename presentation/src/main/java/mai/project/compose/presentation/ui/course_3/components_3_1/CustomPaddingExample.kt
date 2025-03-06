package mai.project.compose.presentation.ui.course_3.components_3_1

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

/**
 * 自定義 padding 的 Modifier
 *
 * 與原版 padding 最大差異：
 * 1. 不會調整子 Composable 的測量空間（constraints），
 *    子內容仍使用父容器的完整空間測量尺寸。
 *
 * 2. 內容的實際大小不變，
 *    只是將內容在排版時往右、往下偏移對應 padding 距離。
 *
 * 3. Layout 最終寬高會在內容原始寬高上加上 padding，
 *    所以使用這個 Modifier 可能導致元件比父容器大，
 *    並可能造成 overflow 風險。
 *
 * ```
 * 假設元件設定大小 -> 寬：300.dp, 高：100.dp, all：16.dp
 * 最後出來的元件 -> 寬：332.dp, 高：132.dp
 * ```
 */
fun Modifier.paddingNoOffsetNoConstrain(all: Dp) = then(
    PaddingModifierPlain(
        start = all,
        top = all,
        end = all,
        bottom = all,
        rtlAware = true
    )
)

@Stable
private class PaddingModifierPlain(
    val start: Dp = 0.dp,
    val top: Dp = 0.dp,
    val end: Dp = 0.dp,
    val bottom: Dp = 0.dp,
    val rtlAware: Boolean,
) : LayoutModifier {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints,
    ): MeasureResult {
        // 計算水平和垂直的 padding 總和
        val horizontal = start.roundToPx() + end.roundToPx()
        val vertical = top.roundToPx() + bottom.roundToPx()

        // 測量內容大小
        val placeable = measurable.measure(constraints)

        // 計算內容寬高
        val width = placeable.width + horizontal
        val height = placeable.height + vertical

        return layout(width, height) {
            if (rtlAware) {
                placeable.placeRelative(start.roundToPx(), top.roundToPx())
            } else {
                placeable.place(start.roundToPx(), top.roundToPx())
            }
        }
    }
}

@Composable
fun CustomPaddingExample(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Custom Padding",
        modifier = modifier
            .background(Color(0xFF8BC34A))
            .paddingNoOffsetNoConstrain(all = 4.dp)
    )
}

@PreviewLightDark
@Composable
private fun CustomPaddingExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CustomPaddingExample()
    }
}