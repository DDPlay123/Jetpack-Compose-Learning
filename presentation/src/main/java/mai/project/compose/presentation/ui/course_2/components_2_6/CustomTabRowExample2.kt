package mai.project.compose.presentation.ui.course_2.components_2_6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun CustomTabRowExample2(
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val backgroundColor = Color(0xFF1E76DA)
    val selectedColor = Color.White
    val textColor = Color(0xFF6FAAEE)
    val list = listOf("Left Tab", "Right Tab")

    TabRow(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .padding(2.dp),
        selectedTabIndex = selectedIndex,
        containerColor = backgroundColor,
        indicator = {},
        divider = {}
    ) {
        list.forEachIndexed { index, item ->
            val selected = selectedIndex == index
            Tab(
                modifier = Modifier
                    .background(
                        if (selected) selectedColor else backgroundColor,
                        RoundedCornerShape(50)
                    ),
                selected = selected,
                onClick = { selectedIndex = index },
                text = { Text(text = item, color = textColor) }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun CustomTabRowExamplePreview() {
    Jetpack_Compose_LearningTheme {
        CustomTabRowExample2()
    }
}