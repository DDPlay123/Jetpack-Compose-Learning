package mai.project.compose.presentation.ui.course_2.components_2_11

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun SnackbarExample(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "基礎的 Snackbar")
        Snackbar(
            modifier = Modifier
        ) {
            Text(text = "這是 Snackbar 的內容")
        }

        CourseHintText(text = "待有 Action 按鈕的 Snackbar")
        Snackbar(
            modifier = Modifier,
            action = {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable {
                            Toast.makeText(context, "Action", Toast.LENGTH_SHORT).show()
                        },
                    text = "Action"
                )
            }
        ) {
            Text(text = "這是 Snackbar 的內容")
        }

        CourseHintText(text = "Action 按鈕在下一行的 Snackbar")
        Snackbar(
            modifier = Modifier,
            actionOnNewLine = true,
            action = {
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            Toast.makeText(context, "Action", Toast.LENGTH_SHORT).show()
                        },
                    text = "Action"
                )
            }
        ) {
            Text(text = "這是 Snackbar 的內容")
        }

        CourseHintText(text = "自定義風格的 Snackbar")
        Snackbar(
            modifier = Modifier,
            containerColor = Color(0xff4CAF50),
            contentColor = Color.Yellow,
            actionContentColor = Color.Red,
            shape = CutCornerShape(12.dp),
            action = {
                Surface(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50))
                        .clickable {
                            Toast.makeText(context, "Action", Toast.LENGTH_SHORT).show()
                        },
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Red
                    ),
                    color = Color(0xff4CAF50)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Action"
                    )
                }
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "這是 Snackbar 的內容",
                textAlign = TextAlign.Center
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun SnackbarExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SnackbarExample()
    }
}