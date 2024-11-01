package mai.project.compose.presentation.course_2.components_2_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ButtonEnableExample(
    modifier: Modifier = Modifier,
    enabled: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {},
            modifier = Modifier,
            enabled = enabled
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {},
            modifier = Modifier,
            enabled = enabled
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier,
            enabled = enabled
        ) {
            Text(text = "Outlined")
        }
    }
}

@Preview
@Composable
private fun ButtonEnableExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ButtonEnableExample(enabled = true)
    }
}