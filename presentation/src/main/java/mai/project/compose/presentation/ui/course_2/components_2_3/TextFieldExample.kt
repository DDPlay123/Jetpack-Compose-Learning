package mai.project.compose.presentation.ui.course_2.components_2_3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun TextFieldExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue }
        )

        CourseHintText(text = "錯誤顯示")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            isError = textFieldValue.value.text.isEmpty(),
        )

        CourseHintText(text = "背景顏色")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xff2E7D32),
                unfocusedContainerColor = Color(0xff2E7D32)
            )
        )

        CourseHintText(text = "背景顏色 + 文字風格")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xff2E7D32),
                unfocusedContainerColor = Color(0xff2E7D32)
            ),
            textStyle = TextStyle(
                color = Color(color = 0xff039BE5),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )

        CourseHintText(text = "形狀 Shape")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xffEC407A),
                unfocusedContainerColor = Color(0xffEC407A),
                // 隱藏底部的指示線
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
        )

        CourseHintText(text = "Outlined TextField")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            value = textFieldValue.value,
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Yellow,
                unfocusedContainerColor = Color.Yellow,
                focusedLabelColor = Color(0xff66BB6A),
                unfocusedLabelColor = Color(0xff66BB6A),
            ),
            textStyle = TextStyle(
                color = Color(color = 0xff039BE5)
            )
        )

        CourseHintText(text = "Single Line")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            label = { Text("Single Line") },
            placeholder = { Text("Placeholder") },
            onValueChange = { newValue ->
                textFieldValue.value = newValue
            },
            singleLine = true
        )
    }
}

@Preview
@Composable
private fun TextFieldExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TextFieldExample()
    }
}