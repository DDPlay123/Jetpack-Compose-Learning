@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_9_2_ScreenRoot() {
    Course_2_9_2_Screen()
}

@Composable
private fun Course_2_9_2_Screen(
    modifier: Modifier = Modifier
) {val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDrawer: () -> Unit = { scope.launch { drawerState.open() } }
    val closeDrawer: () -> Unit = { scope.launch { drawerState.close() } }
    var selectedIndex by remember { mutableIntStateOf(0) }
    val list = listOf("Home", "Profile", "Settings")

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Side Navigation") },
                navigationIcon = {
                    IconButton(onClick = openDrawer) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Open Navigation Drawer"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        ModalNavigationDrawer(
            modifier = modifier.padding(paddingValues),
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    list.forEach {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth(.7f)
                                .clickable {
                                    selectedIndex = list.indexOf(it)
                                    closeDrawer()
                                }
                                .padding(16.dp)
                        )
                    }
                }
            }
        ) {
            Page(
                title = list[selectedIndex]
            )
        }
    }
}

@Composable
private fun Page(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("$title Content")
    }
}

@PreviewLightDark
@Composable
private fun Course_2_9_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_9_2_Screen()
    }
}