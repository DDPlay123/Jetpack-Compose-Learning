package mai.project.compose.presentation.ui.course_2.components_2_4

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import mai.project.compose.core.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ImageFromBlendModeExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        val imageBitmapSrc = ImageBitmap.imageResource(
            R.drawable.composite_src
        )
        val imageBitmapDst = ImageBitmap.imageResource(
            R.drawable.composite_dst
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                // 這裡設置了圖層的透明度為 0.99。
                // 是為了解決某些繪製細節顯示不完全的問題，
                // 這種情況在處理混合效果時有時候會遇到
                .graphicsLayer(alpha = .99f)
        ) {
            // Images on left
            drawImage(
                image = imageBitmapDst
            )
            drawImage(
                image = imageBitmapSrc,
                // 保留了 Src 中不與 Dst 重疊的部分
                blendMode = BlendMode.SrcOut
            )

            // Images on right
            drawImage(
                image = imageBitmapDst,
                dstOffset = IntOffset((size.width / 2f).toInt(), 0),
            )
            drawImage(
                image = imageBitmapSrc,
                dstOffset = IntOffset((size.width / 2f).toInt(), 0),
                // 保留了 Dst 中不與 Src 重疊的部分
                blendMode = BlendMode.DstOut
            )
        }
    }
}

@Preview
@Composable
private fun ImageFromBlendModeExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ImageFromBlendModeExample()
    }
}