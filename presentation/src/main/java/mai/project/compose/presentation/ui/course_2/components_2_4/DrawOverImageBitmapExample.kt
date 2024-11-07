package mai.project.compose.presentation.ui.course_2.components_2_4

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.core.R
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun DrawOverImageBitmapExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        CourseHintText(text = "使用 Painter 在 ImageBitmap 上繪製內容")
        val imageBitmap = ImageBitmap.imageResource(
            id = R.drawable.landscape3
        )

        val painter = object : Painter() {
            override val intrinsicSize: Size
                // 原始 Bitmap 的寬高
                get() = Size(
                    width = imageBitmap.width.toFloat(),
                    height = imageBitmap.height.toFloat()
                )

            override fun DrawScope.onDraw() {
                // 繪製圖片
                drawImage(imageBitmap)

                // 繪製對角線
                drawLine(
                    color = Color.Red,
                    // Bitmap 的左上角
                    start = Offset(
                        x = 0f,
                        y = 0f
                    ),
                    // Bitmap 的右下角
                    end = Offset(
                        x = imageBitmap.width.toFloat(),
                        y = imageBitmap.height.toFloat()
                    ),
                    strokeWidth = 5f
                )
            }
        }
        Image(painter = painter, contentDescription = null)

        CourseHintText(text = "使用 androidx.compose.foundation.Canvas 在 ImageBitmap 上繪製內容")
        // 根據螢幕密度，將 ImageBitmap 的寬高(Px)轉換為 Dp
        val (widthDp, heightDp) =
            LocalDensity.current.run { imageBitmap.width.toDp() to imageBitmap.height.toDp() }
        // 記住 TextMeasurer，用於測量文字
        val measurer = rememberTextMeasurer()

        Canvas(
            modifier = Modifier
                .background(Color.Green)
                .width(widthDp)
                .height(heightDp)
        ) {
            // 繪製圖片
            drawImage(imageBitmap)

            // 繪製圓角矩形
            drawRoundRect(
                color = Color.Yellow,
                topLeft = Offset(
                    x = imageBitmap.width / 4f,
                    y = imageBitmap.height / 4f
                ),
                size = Size(
                    width = imageBitmap.width / 2f,
                    height = imageBitmap.height / 2f
                ),
                style = Stroke(width = 5f),
                cornerRadius = CornerRadius(5f)
            )

            // 使用 TextMeasurer 測量文字尺寸及風格
            val textLayoutResult = measurer.measure(
                text = "Android",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Red
                )
            )

            // 取得文字的寬度和高度
            val textWidth = textLayoutResult.size.width.toFloat()
            val textHeight = textLayoutResult.size.height.toFloat()

            // 計算使文字正中顯示的左上角位置
            val textTopLeftX = center.x - (textWidth / 2f)
            val textTopLeftY = center.y - (textHeight / 2f)

            // 繪製文字在 Canvas 的正中間
            drawText(
                textLayoutResult = textLayoutResult,
                topLeft = Offset(
                    x = textTopLeftX,
                    y = textTopLeftY
                )
            )
        }
    }
}

@Preview
@Composable
private fun DrawOverImageBitmapExamplePreview() {
    Jetpack_Compose_LearningTheme {
        DrawOverImageBitmapExample()
    }
}