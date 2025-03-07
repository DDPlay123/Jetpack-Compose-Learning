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
import mai.project.compose.presentation.ui.course_2.components_2_5.CombinedListItemExample
import mai.project.compose.presentation.ui.course_2.components_2_5.OneLineListItemExample
import mai.project.compose.presentation.ui.course_2.components_2_5.ThreeLineListItemExample
import mai.project.compose.presentation.ui.course_2.components_2_5.TwoLineListItemExample
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_5_7_ScreenRoot() {
    Course_2_5_7_Screen()
}

@Composable
private fun Course_2_5_7_Screen(
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
        CourseTitleText(text = "ListItem")
        CourseContentText(text = "單行 one line", bullets = false)
        OneLineListItemExample()

        CourseContentText(text = "兩行 two line", bullets = false)
        TwoLineListItemExample()

        CourseContentText(text = "三行 three line", bullets = false)
        ThreeLineListItemExample()

        CourseContentText(text = "組合 combined line", bullets = false)
        CombinedListItemExample()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_7_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_7_Screen()
    }
}