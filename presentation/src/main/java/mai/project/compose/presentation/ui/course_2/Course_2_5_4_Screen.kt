@file:OptIn(ExperimentalFoundationApi::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_5.SnackCard
import mai.project.compose.presentation.ui.course_2.model.Snack
import mai.project.compose.presentation.ui.course_2.model.snacksOrdered

@Composable
fun Course_2_5_4_ScreenRoot() {
    Course_2_5_4_Screen()
}

@Composable
private fun Course_2_5_4_Screen(
    modifier: Modifier = Modifier
) {
    // 根據名稱排序並分組
    val grouped: Map<String, List<Snack>> = snacksOrdered.groupBy {
        it.name.last().toString()
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        grouped.keys.sorted().forEach { title ->
            stickyHeader {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    color = Color(0xff039BE5),
                    modifier = Modifier
                        .background(Color(0xffE3F2FD))
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }

            items(
                items = grouped[title] ?: emptyList(),
                key = { it.id }
            ) { snack ->
                SnackCard(
                    snack = snack,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_5_4_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_5_4_Screen()
    }
}