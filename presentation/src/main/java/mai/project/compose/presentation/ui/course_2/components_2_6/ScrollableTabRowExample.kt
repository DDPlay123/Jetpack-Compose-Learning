package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ScrollableTabRowExample(
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf("Home", "Maps", "Dashboard", "Explore", "Notifications", "Settings")

    ScrollableTabRow(
        modifier = modifier,
        edgePadding = 0.dp,
        selectedTabIndex = selectedIndex,
        containerColor = Color.Gray
    ) {
        list.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                text = { Text(text = item) },
                onClick = { selectedIndex = index }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun ScrollableTabRowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ScrollableTabRowExample()
    }
}