package mai.project.compose.presentation.ui.course_2.components_2_2

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun IconButtonExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = Color(0xffE91E63),
                contentDescription = null
            )
        }

        var checked by remember { mutableStateOf(false) }

        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier
        ) {
            val tint by animateColorAsState(
                targetValue = if (checked) Color(0xffE91E63) else Color(0xffB0BEC5),
                animationSpec = tween(durationMillis = 400),
                label = "Favorite Button"
            )

            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = tint,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun IconButtonExamplePreview() {
    Jetpack_Compose_LearningTheme {
        IconButtonExample()
    }
}