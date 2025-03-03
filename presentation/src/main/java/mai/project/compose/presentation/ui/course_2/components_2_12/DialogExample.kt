package mai.project.compose.presentation.ui.course_2.components_2_12

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun DialogExample(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var isShowDialog by rememberSaveable { mutableStateOf(false) }

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        onClick = { isShowDialog = !isShowDialog }
    ) {
        Text(
            text = "Show Dialog"
        )

        if (isShowDialog) {
            ColorPickDialog(
                initialColor = MaterialTheme.colorScheme.primary,
                onDismiss = { isShowDialog = false },
                onCancel = { isShowDialog = false },
                onConfirm = {
                    isShowDialog = false
                    Toast.makeText(context, it.toHex(), Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

private fun Color.toHex(includeAlpha: Boolean = true): String {
    val alpha = (alpha * 255).toInt()
    val red = (red * 255).toInt()
    val green = (green * 255).toInt()
    val blue = (blue * 255).toInt()
    return if (includeAlpha) {
        String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
    } else {
        String.format("#%02X%02X%02X", red, green, blue)
    }
}

@Composable
private fun ColorPickDialog(
    initialColor: Color,
    onDismiss: () -> Unit,
    onCancel: () -> Unit,
    onConfirm: (Color) -> Unit,
) {
    var targetColor by remember { mutableStateOf(initialColor) }

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            tonalElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ColorPick",
                    color = initialColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp, vertical = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                initialColor,
                                shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                            )
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                targetColor,
                                shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                            )
                    )
                }

                ColorPicker(
                    modifier = Modifier
                        .fillMaxWidth(.8f),
                    initialColor = initialColor,
                    onColorChanged = { targetColor = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(
                        modifier = Modifier.weight(1f),
                        onClick = onCancel
                    ) {
                        Text(
                            text = "取消"
                        )
                    }
                    TextButton(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onConfirm.invoke(targetColor)
                        }
                    ) {
                        Text(
                            text = "確認"
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun DialogExamplePreview() {
    Jetpack_Compose_LearningTheme {
        DialogExample()
    }
}

@PreviewLightDark
@Composable
private fun ColorPickDialogPreview() {
    Jetpack_Compose_LearningTheme {
        ColorPickDialog(
            initialColor = MaterialTheme.colorScheme.primary,
            onDismiss = {},
            onCancel = {},
            onConfirm = {}
        )
    }
}