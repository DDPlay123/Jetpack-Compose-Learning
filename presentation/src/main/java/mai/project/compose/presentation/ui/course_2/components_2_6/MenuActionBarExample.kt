@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun MenuActionBarExample(
    modifier: Modifier = Modifier,
    title: String = "Menu ActionBar",
) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Color.Gray
        ),
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(
                onClick = { showMenu = !showMenu }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Refresh")
                    },
                    onClick = { showMenu = false },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = null
                        )
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Phone")
                    },
                    onClick = { showMenu = false },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun MenuActionBarExamplePreview() {
    Jetpack_Compose_LearningTheme {
        MenuActionBarExample()
    }
}