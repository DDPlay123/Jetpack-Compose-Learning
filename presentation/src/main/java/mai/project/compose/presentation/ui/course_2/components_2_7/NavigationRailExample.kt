package mai.project.compose.presentation.ui.course_2.components_2_7

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
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
fun NavigationRailExample(
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
        NavigationRailItemDefaults.colors().copy(
            selectedIndicatorColor = Color.Transparent,
            selectedTextColor = Color.Yellow
        )
    } else {
        NavigationRailItemDefaults.colors()
    }

    NavigationRail(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        list.forEachIndexed { index, item ->
            NavigationRailItem(
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
private fun NavigationRailExamplePreview() {
    Jetpack_Compose_LearningTheme {
        Column {
            NavigationRailExample(showText = true, showIcon = false)
            NavigationRailExample(showText = false, showIcon = true)
            NavigationRailExample(showText = true, showIcon = true)
            NavigationRailExample(alwaysShowLabel = false)
        }
    }
}