@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2.components_2_12

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun AlertDialogExample(
    modifier: Modifier = Modifier
) {
    // 建議使用 rememberSaveable，這樣在畫面旋轉時，也能夠保存狀態
    var isShowAlertDialog by rememberSaveable { mutableStateOf(false) }

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        onClick = { isShowAlertDialog = !isShowAlertDialog }
    ) {
        Text(
            text = "Show AlertDialog"
        )

        if (isShowAlertDialog) {
            AlertDialogSample(
                onDismiss = { isShowAlertDialog = false },
                onConfirm = { isShowAlertDialog = false }
            )
        }
    }
}

@Composable
private fun AlertDialogSample(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            // 圓角外框
            shape = MaterialTheme.shapes.large,
            tonalElevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "此區域通常包含輔助文字，用於說明對話框目的的相關細節。"
                )
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = onConfirm
                ) {
                    Text(text = "確認")
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AlertDialogExamplePreview() {
    Jetpack_Compose_LearningTheme {
        AlertDialogExample()
    }
}

@PreviewLightDark
@Composable
private fun AlertDialogSamplePreview() {
    Jetpack_Compose_LearningTheme {
        AlertDialogSample(
            onDismiss = {},
            onConfirm = {}
        )
    }
}