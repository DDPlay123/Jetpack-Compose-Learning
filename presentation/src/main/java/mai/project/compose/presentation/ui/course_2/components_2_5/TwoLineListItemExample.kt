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
fun TwoLineListItemExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CreateListItem(
            headText = "兩行 ListItem，沒有 Icon",
            supportText = "Secondary text"
        )

        CreateListItem(
            headText = "兩行 ListItem，沒有 Icon",
            overViewText = "Overview text"
        )

        CreateListItem(
            headText = "兩行 ListItem，加上 24 x 24 Icon",
            supportText = "Secondary text",
            size = 24.dp,
            showLeadingIcon = true
        )

        CreateListItem(
            headText = "兩行 ListItem，加上尾部 24 x 24 Icon",
            supportText = "Secondary text",
            size = 24.dp,
            showTrailingIcon = true
        )

        CreateListItem(
            headText = "兩行 ListItem，前後 24 x 24 Icon",
            supportText = "Secondary text",
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
    headText: String,
    overViewText: String = "",
    supportText: String = "",
    size: Dp = 0.dp,
    showLeadingIcon: Boolean = false,
    showTrailingIcon: Boolean = false,
    showDivider: Boolean = true
) {
    ListItem(
        modifier = modifier.clickable { },
        headlineContent = { Text(text = headText) },
        overlineContent = if (overViewText.isNotEmpty()) {
            { Text(text = overViewText) }
        } else null,
        supportingContent = if (supportText.isNotEmpty()) {
            { Text(text = supportText) }
        } else null,
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
private fun TwoLineListItemExamplePreview() {
    Jetpack_Compose_LearningTheme {
        TwoLineListItemExample()
    }
}