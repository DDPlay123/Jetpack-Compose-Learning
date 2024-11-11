package mai.project.compose.presentation.ui.course_2.components_2_5

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun CombinedListItemExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        var switched by remember { mutableStateOf(false) }
        val onSwitchedChange: (Boolean) -> Unit = { switched = it }

        ListItem(
            headlineContent = {
                Text(text = "Switch ListItem：$switched")
            },
            leadingContent = {
                Switch(
                    checked = false,
                    onCheckedChange = onSwitchedChange
                )
            }
        )

        HorizontalDivider()

        var checked by remember { mutableStateOf(true) }
        val onCheckedChange: (Boolean) -> Unit = { checked = it }

        ListItem(
            headlineContent = {
                Text(text = "Switch ListItem：$checked")
            },
            leadingContent = {
                Checkbox(
                    checked = false,
                    onCheckedChange = onCheckedChange
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun CombinedListItemExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CombinedListItemExample()
    }
}