package mai.project.compose.presentation.ui.course_2.components_2_2

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.BasicText

@Composable
fun MultiChoiceSegmentedButton(
    modifier: Modifier = Modifier
) {
    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Home", "Favorite", "Settings")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Favorite,
        Icons.Filled.Settings
    )

    MultiChoiceSegmentedButtonRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        options.forEachIndexed { index, s ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                icon = {
                    // 選中時，Icon 會替換為 SegmentedButtonDefaults.Icon
                    // 否則顯示 Icon
//                    SegmentedButtonDefaults.Icon(
//                        active = index in checkedList
//                    ) {
//                        Icon(
//                            imageVector = icons[index],
//                            contentDescription = null
//                        )
//                    }
                    // 無論選中與否，都會顯示該 Icon
                    Icon(
                        imageVector = icons[index],
                        contentDescription = null
                    )
                },
                onCheckedChange = {
                    if (index in checkedList) {
                        checkedList.remove(index)
                    } else {
                        checkedList.add(index)
                    }
                },
                checked = index in checkedList
            ) {
                BasicText(
                    text = s
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun MultiChoiceSegmentedButtonPreview() {
    Jetpack_Compose_LearningTheme {
        MultiChoiceSegmentedButton()
    }
}