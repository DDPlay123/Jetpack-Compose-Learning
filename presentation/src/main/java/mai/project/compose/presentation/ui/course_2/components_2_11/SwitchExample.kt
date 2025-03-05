package mai.project.compose.presentation.ui.course_2.components_2_11

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun SwitchExample(
    modifier: Modifier = Modifier,
) {
    var switchState by remember { mutableStateOf(true) }
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "基礎的 Switch")
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it }
        )
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    imageVector = if (switchState) Icons.Filled.Check else Icons.Filled.Close,
                    tint = Color.Red,
                    contentDescription = null
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun SwitchExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SwitchExample()
    }
}