@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.course_2.components_2_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
fun FloatingActionButtonExample(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth(),
        maxItemsInEachRow = 2,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FloatingActionButton(
            onClick = {},
            modifier = modifier,
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }

        FloatingActionButton(
            onClick = {},
            modifier = modifier,
            containerColor = Color(0xffFFA000)
        ) {
            Icon(
                Icons.Filled.Done, tint = Color.White,
                contentDescription = null
            )
        }

        var isExtended by remember { mutableStateOf(false) }

        ExtendedFloatingActionButton(
            icon = {},
            text = { Text("Extended") },
            onClick = { isExtended = !isExtended },
            expanded = isExtended,
            modifier = modifier
        )

        ExtendedFloatingActionButton(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    tint = Color.White,
                    contentDescription = null
                )
            },
            text = { Text("Like", color = Color.White) },
            containerColor = Color(0xffEC407A),
            onClick = { isExtended = !isExtended },
            expanded = isExtended,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun FloatingActionButtonExamplePreview() {
    Jetpack_Compose_LearningTheme {
        FloatingActionButtonExample()
    }
}