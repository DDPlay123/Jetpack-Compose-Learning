package mai.project.compose.presentation.ui.course_2.components_2_11

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.BasicText
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun CheckboxExample(
    modifier: Modifier = Modifier,
) {
    var checkedState1 by remember { mutableStateOf(false) }
    var checkedState2 by remember { mutableStateOf(true) }
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "基礎的 Checkbox")
        Checkbox(
            checked = checkedState1,
            onCheckedChange = { checkedState1 = !checkedState1 }
        )
        CourseHintText(text = "帶有文字訊息的 Checkbox")
        CheckBoxWithMessage(
            message = "Sample Checkbox and Message",
            checked = checkedState2,
            onCheckedChange = { checkedState2 = !checkedState2 }
        )
        CourseHintText(text = "具有三種狀態的 Checkbox")
        TriStateCheckBoxExample()
    }
}

@Composable
private fun CheckBoxWithMessage(
    modifier: Modifier = Modifier,
    message: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .toggleable(
                value = checked,
                onValueChange = onCheckedChange
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null
        )
        BasicText(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 12.dp),
            text = message
        )
    }
}

@Composable
private fun TriStateCheckBoxExample() {
    var checkedState1 by remember { mutableStateOf(false) }
    var checkedState2 by remember { mutableStateOf(true) }

    val parentState = remember(checkedState1, checkedState2) {
        if (checkedState1 && checkedState2)
            ToggleableState.On
        else if (!checkedState1 && !checkedState2)
            ToggleableState.Off
        else
            ToggleableState.Indeterminate
    }
    val onParentClick = {
        val state = parentState != ToggleableState.On
        checkedState1 = state
        checkedState2 = state
    }

    Column {
        Row(
            modifier = Modifier
                .triStateToggleable(
                    state = parentState,
                    onClick = onParentClick
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = onParentClick
            )
            BasicText(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                text = "All"
            )
        }

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            CheckBoxWithMessage(
                message = "Case A",
                checked = checkedState1,
                onCheckedChange = { checkedState1 = !checkedState1 }
            )
            CheckBoxWithMessage(
                message = "Case B",
                checked = checkedState2,
                onCheckedChange = { checkedState2 = !checkedState2 }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun CheckboxExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CheckboxExample()
    }
}