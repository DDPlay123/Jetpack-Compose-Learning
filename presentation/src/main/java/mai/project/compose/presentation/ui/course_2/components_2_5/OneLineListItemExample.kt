package mai.project.compose.presentation.ui.course_2.components_2_5

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun OneLineListItemExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CreateListItem(
            text = "單行 ListItem，沒有 Icon"
        )

        CreateListItem(
            text = "單行 ListItem，加上 24 x 24 Icon",
            size = 24.dp,
            showLeadingIcon = true
        )

        CreateListItem(
            text = "單行 ListItem，加上 40 x 40 Icon",
            size = 40.dp,
            showLeadingIcon = true
        )

        CreateListItem(
            text = "單行 ListItem，加上 56 x 56 Icon",
            size = 56.dp,
            showLeadingIcon = true
        )

        CreateListItem(
            text = "單行 ListItem，加上尾部 24 x 24 Icon",
            size = 24.dp,
            showTrailingIcon = true
        )

        CreateListItem(
            text = "單行 ListItem，加上前後 24 x 24 Icon",
            size = 24.dp,
            showLeadingIcon = true,
            showTrailingIcon = true,
            showDivider = false
        )
    }
}

@Composable
private fun CreateListItem(
    modifier: Modifier = Modifier,
    text: String,
    size: Dp = 0.dp,
    showLeadingIcon: Boolean = false,
    showTrailingIcon: Boolean = false,
    showDivider: Boolean = true
) {
    ListItem(
        modifier = modifier.clickable { },
        headlineContent = { Text(text = text) },
        leadingContent = if (showLeadingIcon && size > 0.dp) {
            {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(size)
                )
            }
        } else null,
        trailingContent = if (showTrailingIcon && size > 0.dp) {
            {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(size)
                )
            }
        } else null
    )
    if (showDivider) HorizontalDivider()
}

@PreviewLightDark
@Composable
private fun OneLineListItemExamplePreview() {
    Jetpack_Compose_LearningTheme {
        OneLineListItemExample()
    }
}