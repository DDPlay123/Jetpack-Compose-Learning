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
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_11.CheckboxExample
import mai.project.compose.presentation.ui.course_2.components_2_11.ProgressExample
import mai.project.compose.presentation.ui.course_2.components_2_11.RadioButtonExample
import mai.project.compose.presentation.ui.course_2.components_2_11.SliderExample
import mai.project.compose.presentation.ui.course_2.components_2_11.SnackbarExample
import mai.project.compose.presentation.ui.course_2.components_2_11.SwitchExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_11_ScreenRoot() {
    Course_2_11_Screen()
}

@Composable
private fun Course_2_11_Screen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Snackbar")
        CourseContentText(text = "1-) Snackbar 用於在螢幕底部提供關於應用程式的簡短訊息。")
        SnackbarExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Progress")
        CourseContentText(text = "2-) Progress Indicators 用於表示等待狀態或處理過程中。")
        ProgressExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Checkbox")
        CourseContentText(text = "3-) Checkbox 用於選取項目。")
        CheckboxExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Switch")
        CourseContentText(text = "4-) Switch 用於切換事件，On 或 Off。")
        SwitchExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "RadioButton")
        CourseContentText(text = "5-) RadioButton 用於選取項目。\n它與 CheckBox 不同之處在於它能夠設定群組（Group）。")
        RadioButtonExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Slider")
        CourseContentText(text = "6-) Slider 用於拖曳並選擇單一數值，如音量、亮度。")
        SliderExample()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_11_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_11_Screen()
    }
}