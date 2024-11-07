package mai.project.compose.presentation.ui.course_1

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
import mai.project.compose.presentation.ui.course_1.components_1_2.ClickableExample
import mai.project.compose.presentation.ui.course_1.components_1_2.SurfaceClickPropagationExample
import mai.project.compose.presentation.ui.course_1.components_1_2.SurfaceContentColorExample
import mai.project.compose.presentation.ui.course_1.components_1_2.SurfaceShapeExample
import mai.project.compose.presentation.ui.course_1.components_1_2.SurfaceZIndexExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_1_2_ScreenRoot() {
    Course_1_2_Screen()
}

@Composable
private fun Course_1_2_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Clickable")
        CourseContentText(text = "1-) 將 clickable 添加到 Modifier 會使組件變得可點擊。在 clickable 之前設置 padding 會使**點擊區域小於組件的總區域**")
        ClickableExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        // 在 Material Design 中，Surface 是核心隱喻。每個表面都存在於特定的高度，這會影響該表面與其他表面在視覺上的關係以及該表面投射陰影的方式。
        // 1. 裁剪：Surface 將其子組件裁剪為由 shape 指定的形狀。
        // 2. 高度：Surface 通過 elevation 像素提升其子組件在 Z 軸上的位置，並繪製相應的陰影。
        // 3. 邊框：如果 shape 包含邊框，則邊框也會被繪製。
        // 4. 背景：Surface 使用指定的形狀填充顏色。如果顏色設置為 Colors.surface，將應用 LocalElevationOverlay 的覆蓋層——默認情況下，這僅在深色主題中生效。覆蓋層的顏色取決於該 Surface 的高度以及由任何父級 Surface 設定的 LocalAbsoluteElevation。這樣可確保 Surface 的覆蓋層高度不會低於其祖先的高度，通過累加所有前置 Surface 的高度來實現。
        // 5. 內容顏色：Surface 使用 contentColor 為此 Surface 的內容指定首選顏色——這作為 Text 和 Icon 元件的默認顏色。
        CourseTitleText(text = "Surface")
        CourseContentText(text = "2-) Surface 可以將其子組件裁剪為選定的形狀")
        SurfaceShapeExample()
        CourseContentText(text = "3-) Surface 可以設置其子組件的 Z 軸索引（Z-index）和邊框")
        SurfaceZIndexExample()
        CourseContentText(text = "4-) Surface 可以為文字和圖片設置內容顏色")
        SurfaceContentColorExample()
        CourseContentText(text = "5-) 組件可以在 x 和 y 軸上設置偏移量。當 Surface 位於另一個 Surface 內且溢出其父容器時，會被裁剪")
        SurfaceClickPropagationExample()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_1_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_1_2_Screen()
    }
}