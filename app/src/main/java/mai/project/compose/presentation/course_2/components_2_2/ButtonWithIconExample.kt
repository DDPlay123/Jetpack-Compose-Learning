@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.course_2.components_2_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ButtonWithIconExample(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth(),
        maxItemsInEachRow = 2,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {},
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(end = 4.dp),
                contentDescription = null
            )
            Text(text = "Icon+Text")
        }

        Button(
            onClick = {},
            modifier = Modifier
        ) {
            Text(text = "Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }

        Button(
            onClick = {},
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                modifier = Modifier.padding(end = 4.dp),
                contentDescription = null
            )
            Text(text = "Icon+Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(20),
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
        }

        Button(
            onClick = {},
            modifier = Modifier
        ) {
            Text(text = "Text+")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(horizontal = 4.dp),
                contentDescription = null
            )
            Text(text = "+Text")
        }
    }
}

@Preview
@Composable
private fun ButtonWithIconExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ButtonWithIconExample()
    }
}