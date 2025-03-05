package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun TabRowExample(
    modifier: Modifier = Modifier,
    showText: Boolean,
    showIcon: Boolean,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf(
        "Home" to Icons.Filled.Home,
        "Notifications" to Icons.Filled.Notifications,
        "Settings" to Icons.Filled.Settings
    )

    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedIndex,
        containerColor = Color.Gray
    ) {
        list.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                text = if (showText) {
                    { Text(text = item.first) }
                } else null,
                icon = if (showIcon) {
                    { Icon(imageVector = item.second, contentDescription = null) }
                } else null,
                onClick = { selectedIndex = index }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun TabRowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TabRowExample(showText = true, showIcon = true)
    }
}