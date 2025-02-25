@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ActionBarExample(
    modifier: Modifier = Modifier,
    title: String = "ActionBar",
    showIcon: Boolean = true,
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Color.Gray
        ),
        title = {
            Text(text = title)
        },
        navigationIcon = if (showIcon) {
            {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        } else {
            {}
        },
        actions = {
            if (showIcon) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun ActionBarExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ActionBarExample()
    }
}