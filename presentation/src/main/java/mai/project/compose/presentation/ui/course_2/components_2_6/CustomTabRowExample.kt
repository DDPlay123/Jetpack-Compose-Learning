package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun CustomTabRowExample(
    modifier: Modifier = Modifier,
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
        containerColor = Color.Gray,
        indicator = { tabPositions ->
            val currentTab = tabPositions[selectedIndex]
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier
                    // 讓 指示線 顯示在 Tab 底部
                    .tabIndicatorOffset(currentTab),
                width = 48.dp,
                height = 4.dp,
                color = Color.Red,
                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
            )
        }
    ) {
        list.forEachIndexed { index, item ->
            CustomTab(
                item = item,
                onClick = { selectedIndex = index }
            )
        }
    }
}

@Composable
private fun CustomTab(
    modifier: Modifier = Modifier,
    item: Pair<String, ImageVector>,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = item.first)
        Icon(imageVector = item.second, contentDescription = null)
    }
}

@PreviewLightDark
@Composable
private fun CustomTabRowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CustomTabRowExample()
    }
}

@Preview
@Composable
private fun CustomTabPreview() {
    Jetpack_Compose_LearningTheme {
        CustomTab(
            item = "Home" to Icons.Filled.Home,
            onClick = {}
        )
    }
}