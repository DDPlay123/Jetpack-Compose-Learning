package mai.project.compose.presentation.ui.course_3

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
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_3.components_3_1.CustomAlignExample
import mai.project.compose.presentation.ui.course_3.components_3_1.CustomPaddingExample
import mai.project.compose.presentation.ui.course_3.components_3_1.FirstBaselineToTopExample
import mai.project.compose.presentation.ui.course_3.components_3_1.ModifierComposedExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_3_1_1_ScreenRoot() {
    Course_3_1_1_Screen()
}

@Composable
private fun Course_3_1_1_Screen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Custom Modifier")
        CourseContentText(text = "1-) 自定義元件擺放位置。\n使用 Modifier 的 layout 擴展函式，該函式會回傳一個 Modifier。")
        CourseHintText(text = "Custom Align Modifier")
        CustomAlignExample()
        CourseHintText(text = "First Baseline To Top Modifier")
        FirstBaselineToTopExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "2-) 使用 LayoutModifier 物件，來計算元件的擺放方式。")
        CourseHintText(text = "Custom Padding Modifier")
        CustomPaddingExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "3-) Modifier.composed 是用來建立可以擁有獨立狀態或副作用\n（如 remember、SideEffect）\n的自定義 Modifier，讓每個 Composable 使用時各自維護自己的記憶與行為。")
        ModifierComposedExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_3_1_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_3_1_1_Screen()
    }
}