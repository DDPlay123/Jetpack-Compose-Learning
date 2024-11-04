package mai.project.compose.presentation.course_2.components_2_3

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun BasicTextFieldExample(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xff90A4AE)
    ) {
        var basicText by remember { mutableStateOf("") }
        BasicTextField(
            modifier = Modifier.padding(8.dp),
            value = basicText,
            onValueChange = { newValue ->
                basicText = newValue
            })

    }
}

@Preview
@Composable
private fun BasicTextFieldExamplePreview() {
    Jetpack_Compose_LearningTheme {
        BasicTextFieldExample()
    }
}