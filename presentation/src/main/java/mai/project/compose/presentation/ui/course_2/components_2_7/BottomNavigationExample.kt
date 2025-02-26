package mai.project.compose.presentation.ui.course_2.components_2_7

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
fun BottomNavigationExample(
    modifier: Modifier = Modifier,
    showText: Boolean = true,
    showIcon: Boolean = true,
    alwaysShowLabel: Boolean = true,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf(
        "Home" to Icons.Filled.Home,
        "Notifications" to Icons.Filled.Notifications,
        "Settings" to Icons.Filled.Settings
    )
    val indicator = if (!showIcon) {
        NavigationBarItemDefaults.colors().copy(
            selectedIndicatorColor = Color.Transparent,
            selectedTextColor = Color.Yellow
        )
    } else {
        NavigationBarItemDefaults.colors()
    }

    NavigationBar(
        modifier = modifier
    ) {
        list.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                alwaysShowLabel = alwaysShowLabel,
                label = {
                    if (showText) {
                        Text(text = item.first)
                    }
                },
                icon = {
                    if (showIcon) {
                        Icon(
                            imageVector = item.second,
                            contentDescription = null
                        )
                    }
                },
                onClick = { selectedIndex = index },
                colors = indicator
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun BottomNavigationExamplePreview() {
    Jetpack_Compose_LearningTheme {
        Column {
            BottomNavigationExample(showText = true, showIcon = false)
            BottomNavigationExample(showText = false, showIcon = true)
            BottomNavigationExample(showText = true, showIcon = true)
            BottomNavigationExample(alwaysShowLabel = false)
        }
    }
}