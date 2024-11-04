package mai.project.compose.presentation.course_2

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
import mai.project.compose.presentation.course_2.components_2_3.BasicTextFieldExample
import mai.project.compose.presentation.course_2.components_2_3.IMEAndActionExample
import mai.project.compose.presentation.course_2.components_2_3.KeyboardTypeExample
import mai.project.compose.presentation.course_2.components_2_3.TextFieldExample
import mai.project.compose.presentation.course_2.components_2_3.TextFieldWithIconsExample
import mai.project.compose.presentation.course_2.components_2_3.VisualTransformationExample
import mai.project.compose.presentation.home.components.CourseContentText
import mai.project.compose.presentation.home.components.CourseTitleText
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_3_ScreenRoot() {
    Course_2_3_Screen()
}

@Composable
private fun Course_2_3_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "TextField")
        CourseContentText(text = "1-) **TextField** 允許用戶輸入和編輯文字。remember 與 MutableState 一起使用，用於儲存文字或 TextFieldValue 的狀態")
        TextFieldExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "2-) 可以更改 TextField 的輸入類型 (KeyboardType)")
        KeyboardTypeExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "3-) TextField 可以設置前置（leading）和後置（trailing）的圖標")
        TextFieldWithIconsExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "4-) 更改 IME 及 Actions 會更改鍵盤的完成按鈕功能性")
        IMEAndActionExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "5-) 使用 **VisualTransformation** 和正則表達式，可以根據格式（如密碼、電話號碼、信用卡）來轉換文字")
        VisualTransformationExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "6-) 基本的 TextField 可組合元件，允許用戶通過硬體或軟體鍵盤編輯文字，但不提供提示或佔位符等裝飾")
        BasicTextFieldExample()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_3_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_3_Screen()
    }
}
