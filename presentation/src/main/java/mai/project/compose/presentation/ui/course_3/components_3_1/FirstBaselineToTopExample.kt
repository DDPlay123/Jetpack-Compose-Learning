package mai.project.compose.presentation.ui.course_3.components_3_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

/**
 * 自定義 FirstBaseline 對齊的 Modifier
 *
 * 1. 只有 Composable 具有 [FirstBaseline] 對齊線時才能使用（例如 Text, BasicText, TextField 等），
 *    否則會拋出 Exception。
 *
 * 2. FirstBaseline 指的是第一行文字的 baseline（基線），
 *    是字體中底部對齊參考線，
 *    不等於整個元件的底部或視覺上的最下緣。
 *
 * 3. 此 Modifier 會調整 Composable 的排版位置，
 *    讓第一行文字的 baseline 距離父容器頂部精確為 [firstBaselineToTop]。
 *
 * 4. 實際做法是計算 Y 軸偏移量（目標 baseline 距離 - 原始 baseline 距離），
 *    並將元件整體往下移動該距離，
 *    並增加額外高度以容納這個偏移。
 */
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp,
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    // 檢查該 Modifier 是否有 FirstBaseline (Ex. Text, BasicText, TextField等...)
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]
    // 計算 Y 軸偏移量 (目標位置 - 當前 First Baseline 位置)
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    // 計算高度 (內容高度 + 偏移量)
    val height = placeable.height + placeableY

    // 設定 Layout 尺寸 (寬度為內容寬度，高度為計算的高度)
    layout(placeable.width, height) {
        placeable.placeRelative(0, placeableY)
    }
}

@Composable
fun FirstBaselineToTopExample(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .wrapContentHeight()
    ) {
        Text(
            text = "Padding 32dp",
            modifier = Modifier
                .background(Color(0xFF8BC34A))
                .padding(top = 32.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Baseline To Top 32dp",
            modifier = Modifier
                .background(Color(0xFF8BC34A))
                .firstBaselineToTop(32.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun FirstBaselineToTopExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FirstBaselineToTopExample()
    }
}