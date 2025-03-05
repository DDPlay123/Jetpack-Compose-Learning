package mai.project.compose.presentation.ui.course_2.components_2_11

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.BasicText
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun RadioButtonExample(
    modifier: Modifier = Modifier
) {
    var buttonState by remember { mutableStateOf(true) }
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "基礎的 RadioButton")
        RadioButton(
            selected = buttonState,
            onClick = { buttonState = !buttonState }
        )
        CourseHintText(text = "群組的 RadioButton")
        GroupRadioButton()
    }
}

@Composable
private fun GroupRadioButton() {
    val radioOptions = listOf("Case A", "Case B", "Case C")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.selectableGroup()
    ) {
        radioOptions.forEach { name ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = name == selectedOption,
                        onClick = { selectedOption = name }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = name == selectedOption,
                    onClick = { selectedOption = name }
                )
                BasicText(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    text = name
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun RadioButtonExamplePreview() {
    Jetpack_Compose_LearningTheme {
        RadioButtonExample()
    }
}