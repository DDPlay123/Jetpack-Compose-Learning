package mai.project.compose.presentation.ui.course_2.components_2_3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.core.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun VisualTransformationExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        PasswordTextField()
        MaskCharsTextField()
        PhoneTextField()
    }
}

@Composable
private fun PasswordTextField(
    modifier: Modifier = Modifier
) {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var showPassword by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = password,
        label = { Text("Password") },
        placeholder = { Text(text = "請輸入您的密碼") },
        onValueChange = { newValue -> password = newValue },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            IconButton(
                onClick = { showPassword = !showPassword }
            ) {
                Icon(
                    imageVector = if (showPassword) {
                        ImageVector.vectorResource(R.drawable.baseline_visibility_off_24)
                    } else {
                        ImageVector.vectorResource(R.drawable.baseline_visibility_24)
                    },
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun MaskCharsTextField(
    modifier: Modifier = Modifier
) {
    var chars by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = chars,
        label = { Text("Mask Characters") },
        placeholder = { Text(text = "請輸入任意文字") },
        onValueChange = { newValue -> chars = newValue },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        visualTransformation = object : VisualTransformation {
            override fun filter(text: AnnotatedString): TransformedText {
                return TransformedText(
                    AnnotatedString(text.text.replace(".".toRegex(), "!")),
                    maskOffsetMap
                )
            }

            private val maskOffsetMap = object : OffsetMapping {
                override fun originalToTransformed(offset: Int) = offset
                override fun transformedToOriginal(offset: Int) = offset
            }
        }
    )
}

@Composable
private fun PhoneTextField(
    modifier: Modifier = Modifier
) {
    val maxNumber = 10
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = phone,
        label = { Text("Phone") },
        placeholder = { Text(text = "請輸入您的手機號碼") },
        onValueChange = { newValue -> if (newValue.text.length <= maxNumber) phone = newValue },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        visualTransformation = object : VisualTransformation {
            override fun filter(text: AnnotatedString): TransformedText {
                // Making XXXX-XXX-XXX format
                // ex. 0912-345-678
                val trimmed = if (text.text.length > maxNumber)
                    text.text.substring(0 until maxNumber)
                else
                    text.text

                val output = buildString {
                    for (i in trimmed.indices) {
                        append(trimmed[i])
                        if (i == 3 || i == 6) {
                            append("-")
                        }
                    }
                }

                return TransformedText(AnnotatedString(output), phoneOffsetMap(trimmed))
            }

            private fun phoneOffsetMap(trimmed: String): OffsetMapping {
                return object : OffsetMapping {
                    override fun originalToTransformed(offset: Int): Int {
                        return when {
                            offset <= 3 -> offset
                            offset in 4..6 -> offset + 1
                            offset in 7..9 -> offset + 2
                            else -> 12 // 超出範圍的話，返回最大可用長度
                        }
                    }

                    override fun transformedToOriginal(offset: Int): Int {
                        return when {
                            offset <= 3 -> offset
                            offset in 4..7 -> offset - 1
                            offset in 8..11 -> offset - 2
                            else -> trimmed.length // 返回 trimmed 的長度，而不是 10，以避免超出邊界
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun VisualTransformationExamplePreview() {
    Jetpack_Compose_LearningTheme {
        VisualTransformationExample()
    }
}