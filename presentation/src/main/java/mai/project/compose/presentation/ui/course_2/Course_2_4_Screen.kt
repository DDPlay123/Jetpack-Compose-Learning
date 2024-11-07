package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.course_2.components_2_4.CoilLoadExample
import mai.project.compose.presentation.ui.course_2.components_2_4.ContentScaleExample
import mai.project.compose.presentation.ui.course_2.components_2_4.DrawOnImageBitmapExample
import mai.project.compose.presentation.ui.course_2.components_2_4.DrawOverImageBitmapExample
import mai.project.compose.presentation.ui.course_2.components_2_4.GlideLoadExample
import mai.project.compose.presentation.ui.course_2.components_2_4.ImageExample
import mai.project.compose.presentation.ui.course_2.components_2_4.ImageFromBlendModeExample
import mai.project.compose.presentation.ui.course_2.components_2_4.ImageGraphicLayerExample
import mai.project.compose.presentation.ui.course_2.components_2_4.ImageShapeAndFilterExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_4_ScreenRoot() {
    Course_2_4_Screen()
}

@Composable
private fun Course_2_4_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Image")
        CourseContentText(text = "1-) **Image** 組件用於佈局並繪製給定的 ImageBitmap、ImageVector 或 Painter 物件")
        ImageExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "2-) 使用 **Painter** 和 **androidx.compose.foundation.Canvas**，我們可以在 ImageBitmap 上進行繪製，並將該 ImageBitmap 設置為 Image 的內容")
        DrawOverImageBitmapExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "3-) 使用 **androidx.compose.ui.graphics.Canvas**，我們可以在 ImageBitmap 上添加水印，然後將該 ImageBitmap 用於 Image，或者將其保存到檔案中")
        DrawOnImageBitmapExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "4-) 設定 Image 的形狀或濾鏡")
        ImageShapeAndFilterExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "5-) **graphicLayer** 修飾符可用於對內容應用效果，例如縮放（scaleX、scaleY）、旋轉（rotationX、rotationY、rotationZ）、不透明度（alpha）、陰影（shadowElevation、shape）以及裁剪（clip、shape）")
        ImageGraphicLayerExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "6-) 將 **graphicLayer** 的 alpha 設置為 0.99 並在 **drawImage** 上設置 **blendMode**，可以對來源（src）和目標（dst）圖像應用 Porter-Duff 模式")
        ImageFromBlendModeExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "7-) 使用 Glide 庫從網路獲取圖像資源，並將其設置為 Image 組件的內容")
        GlideLoadExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "8-) 使用 Coil 庫從網路獲取圖像資源，並將其設置為 Image 組件的內容")
        CoilLoadExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "9-) ContentScale 表示一種規則，用於將來源圖片縮放以適應目標物件的大小")
        ContentScaleExample()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_4_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_4_Screen()
    }
}