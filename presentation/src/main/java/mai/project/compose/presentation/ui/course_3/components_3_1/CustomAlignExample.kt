package mai.project.compose.presentation.ui.course_3.components_3_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

enum class HorizontalAlign {
    START, CENTER, END
}

/**
 * 自定義水平對齊的 Modifier
 *
 * 功能說明：
 * 1. 在原 Composable 的基礎上，額外增加 [space] 空間來擴大總寬度，
 *    最終寬度 = 內容寬度 + 2 * [space]。
 *
 * 2. 根據 [align] 參數決定內容在擴展後寬度中的擺放位置：
 *    - [HorizontalAlign.START]：靠左對齊（不偏移）。
 *    - [HorizontalAlign.CENTER]：內容向右偏移 [space]，置中。
 *    - [HorizontalAlign.END]：內容向右偏移 2 * [space]，靠右對齊。
 *
 * 注意事項：
 * - 這個 Modifier 只改變水平方向的 layout 行為，垂直方向不受影響。
 * - 寬度的增加是強制性的，不考慮父容器 constraints 是否允許超出，可能導致超出父容器範圍。
 * - 不會改變子 Composable 本身的尺寸，只是透過偏移調整位置。
 */
fun Modifier.customAlign(
    space: Int = 60,
    align: HorizontalAlign = HorizontalAlign.CENTER,
): Modifier {
    // 自定義 Layout Modifier
    // measurable：要擺放的內容
    // constraints：父層給的尺寸限制
    return layout { measurable: Measurable, constraints: Constraints ->
        // 測量內容大小
        val placeable = measurable.measure(constraints)
        // 定義新寬度，為 內容寬度 加上 左右的空間
        val width = placeable.measuredWidth + 2 * space

        // 設定 Layout 尺寸 (新寬度 與 內容高度)
        layout(width, placeable.measuredHeight) {
            // 根據對齊方式，設定偏移值
            when (align) {
                HorizontalAlign.START -> placeable.placeRelative(0, 0)

                HorizontalAlign.CENTER -> placeable.placeRelative(space, 0)

                HorizontalAlign.END -> placeable.placeRelative(2 * space, 0)
            }
        }
    }
}

@Composable
fun CustomAlignExample(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Align Start with space",
            modifier = Modifier
                .background(Color(0xFF8BC34A))
                .customAlign(align = HorizontalAlign.START)
        )

        Text(
            text = "Align Center with space",
            modifier = Modifier
                .background(Color(0xFF8BC34A))
                .customAlign(align = HorizontalAlign.CENTER)
        )

        Text(
            text = "Align End with space",
            modifier = Modifier
                .background(Color(0xFF8BC34A))
                .customAlign(align = HorizontalAlign.END)
        )
    }
}

@PreviewLightDark
@Composable
private fun CustomAlignExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CustomAlignExample()
    }
}