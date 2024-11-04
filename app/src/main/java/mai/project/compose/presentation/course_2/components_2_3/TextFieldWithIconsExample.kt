package mai.project.compose.presentation.course_2.components_2_3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun TextFieldWithIconsExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        var email by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            label = { Text("Email") },
            placeholder = { Text(text = "test@example.com") },
            onValueChange = { newValue -> email = newValue },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { email = TextFieldValue("") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun TextFieldWithIconsExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TextFieldWithIconsExample()
    }
}