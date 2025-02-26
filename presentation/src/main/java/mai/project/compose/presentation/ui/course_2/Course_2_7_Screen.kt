package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_7.BottomNavigationExample
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_7_ScreenRoot() {
    Course_2_7_Screen()
}

@Composable
fun Course_2_7_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseTitleText(text = "BottomNavigation")
        BottomNavigationExample(showText = true, showIcon = false)
        BottomNavigationExample(showText = false, showIcon = true)
        BottomNavigationExample(showText = true, showIcon = true)
        BottomNavigationExample(alwaysShowLabel = false)
    }
}

@PreviewLightDark
@Composable
private fun Course_2_7_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_7_Screen()
    }
}