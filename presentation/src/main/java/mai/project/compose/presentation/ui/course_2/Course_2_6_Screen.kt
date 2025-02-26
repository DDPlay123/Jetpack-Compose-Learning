package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_6.ActionBarExample
import mai.project.compose.presentation.ui.course_2.components_2_6.CustomTabRowExample2
import mai.project.compose.presentation.ui.course_2.components_2_6.CustomTabRowExample
import mai.project.compose.presentation.ui.course_2.components_2_6.MenuActionBarExample
import mai.project.compose.presentation.ui.course_2.components_2_6.ScrollableTabRowExample
import mai.project.compose.presentation.ui.course_2.components_2_6.TabRowExample
import mai.project.compose.presentation.ui.course_2.components_2_6.WhatsappActionBarExample
import mai.project.compose.presentation.ui.home.components.CourseContentText

@Composable
fun Course_2_6_ScreenRoot() {
    Course_2_6_Screen()
}

@Composable
private fun Course_2_6_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseContentText(text = "1-) 基礎的 TopAppBar")
        ActionBarExample()
        ActionBarExample(title = "ActionBar No Icon", showIcon = false)

        CourseContentText(text = "2-) 基礎的 TopAppBar，帶有 Menu 選單")
        MenuActionBarExample()

        CourseContentText(text = "3-) Whatsapp Clone 的 TopAppBar")
        WhatsappActionBarExample()

        CourseContentText(text = "4-) 基礎的 TabRow")
        TabRowExample(showText = true, showIcon = false)
        TabRowExample(showText = false, showIcon = true)
        TabRowExample(showText = true, showIcon = true)

        CourseContentText(text = "5-) 可滾動的 TabRow")
        ScrollableTabRowExample()

        CourseContentText(text = "6-) 自定義樣式的 TabRow")
        CustomTabRowExample()
        CustomTabRowExample2()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_6_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_6_Screen()
    }
}