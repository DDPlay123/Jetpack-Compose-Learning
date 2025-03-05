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
import mai.project.compose.presentation.ui.course_2.components_2_12.AlertDialogExample
import mai.project.compose.presentation.ui.course_2.components_2_12.DialogExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_12_ScreenRoot() {
    Course_2_12_Screen()
}

@Composable
private fun Course_2_12_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "AlertDialog")
        CourseContentText(text = "1-) AlertDialog 是一個具備 Material Design 樣式 與 語意支援 的提示對話框，適合用於 確認、警告、通知 等需求。")
        AlertDialogExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Dialog")
        CourseContentText(text = "2-) Dialog 是一個 純粹的容器，提供完全自訂內容的空間，適合製作 任何形式的自訂彈窗，但需自行處理無障礙語意")
        DialogExample()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_12_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_12_Screen()
    }
}