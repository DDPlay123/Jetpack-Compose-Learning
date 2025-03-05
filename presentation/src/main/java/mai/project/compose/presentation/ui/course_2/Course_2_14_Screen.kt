@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.ui.course_2

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import mai.project.compose.core.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.model.ImageChip
import mai.project.compose.presentation.ui.course_2.model.mockImageChip
import mai.project.compose.presentation.ui.home.components.BasicText
import java.util.UUID

@Composable
fun Course_2_14_ScreenRoot() {
    Course_2_14_Screen()
}

@Composable
private fun Course_2_14_Screen(
    modifier: Modifier = Modifier,
    testChips: List<ImageChip> = emptyList(),
) {
    val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }
    val chips = remember { mutableStateListOf<ImageChip>() }.apply {
        addAll(testChips)
    }

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri ->
        uri?.let {
            // 保留媒體檔案存取權
            val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
            context.contentResolver.takePersistableUriPermission(uri, flag)
            chips.add(
                ImageChip(
                    id = UUID.randomUUID().toString(),
                    image = uri,
                    text = textFieldValue.value.text
                )
            )
            textFieldValue.value = TextFieldValue("")
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue.value,
            singleLine = true,
            placeholder = { Text("請輸入名稱") },
            onValueChange = { newValue -> textFieldValue.value = newValue },
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
                if (textFieldValue.value.text.isNotEmpty()) {
                    photoPicker.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            chips.forEach {
                ImageChip(
                    data = it,
                    onDeleted = { chip -> chips.remove(chip) }
                )
            }
        }
    }
}

@Composable
private fun ImageChip(
    modifier: Modifier = Modifier,
    data: ImageChip,
    onDeleted: (ImageChip) -> Unit = {},
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .padding(4.dp)
                .clip(CircleShape),
            model = data.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.avatar_1_raster),
            error = painterResource(R.drawable.avatar_1_raster)
        )

        BasicText(
            modifier = Modifier.padding(start = 4.dp),
            text = data.text
        )

        IconButton(
            onClick = { onDeleted(data) }
        ) {
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = .6f))
                    .size(20.dp),
                imageVector = Icons.Filled.Close,
                tint = Color(0xFFE0E0E0),
                contentDescription = null
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_14_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_14_Screen(
            testChips = listOf(
                mockImageChip,
                mockImageChip,
                mockImageChip,
                mockImageChip,
                mockImageChip
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun ImageChipPreview() {
    Jetpack_Compose_LearningTheme {
        ImageChip(data = mockImageChip)
    }
}