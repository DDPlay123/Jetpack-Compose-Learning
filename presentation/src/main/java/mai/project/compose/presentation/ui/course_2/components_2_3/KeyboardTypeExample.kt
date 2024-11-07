package mai.project.compose.presentation.ui.course_2.components_2_3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun KeyboardTypeExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        var phone by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = { newValue -> phone = newValue },
            label = { Text(text = "KeyboardType.Phone") },
            placeholder = { Text(text = "0912345678") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        var decimal by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = decimal,
            onValueChange = { newValue -> decimal = newValue },
            label = { Text(text = "KeyboardType.Decimal") },
            placeholder = { Text(text = "123456789") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
}

@Preview
@Composable
private fun KeyboardTypeExamplePreview() {
    Jetpack_Compose_LearningTheme {
        KeyboardTypeExample()
    }
}