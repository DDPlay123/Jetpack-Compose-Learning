package mai.project.compose.presentation.course_2.components_2_4

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.R
import mai.project.compose.presentation.home.components.CourseHintText
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun DrawOnImageBitmapExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        CourseHintText(text = "在 ImageBitmap 上進行繪製並返回該 ImageBitmap")
        val context = LocalContext.current

        // 定義圖片載入時的選項
        val options = BitmapFactory.Options().apply {
            // 使用 ARGB_8888 格式的 Bitmap
            inPreferredConfig = Bitmap.Config.ARGB_8888
            // 允許修改 Bitmap 的像素 (這樣才能進行繪製)
            inMutable = true
        }

        // 載入圖片並轉換為 Bitmap
        val imageBitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.landscape3,
            options
        ).asImageBitmap()

        // 建立 Canvas 並繪製到 Bitmap 上
        val canvas = Canvas(imageBitmap)

        // 建立畫筆並設置畫筆的屬性
        val paint = remember {
            Paint().apply {
                style = PaintingStyle.Stroke
                strokeWidth = 10f
                color = Color(color = 0xff29B6F6)
            }
        }

        // 繪製矩形
        canvas.drawRect(
            left = 0f,
            top = 0f,
            right = 200f,
            bottom = 200f,
            paint = paint
        )

        // 繪製圓形
        canvas.drawCircle(
            center = Offset(
                x = imageBitmap.width / 2 - 75f,
                y = imageBitmap.height / 2 - 75f
            ),
            radius = 100f,
            paint = paint
        )

        // 顯示圖片
        Image(bitmap = imageBitmap, contentDescription = null)
    }
}

@Preview
@Composable
private fun DrawOnImageBitmapExamplePreview() {
    Jetpack_Compose_LearningTheme {
        DrawOnImageBitmapExample()
    }
}