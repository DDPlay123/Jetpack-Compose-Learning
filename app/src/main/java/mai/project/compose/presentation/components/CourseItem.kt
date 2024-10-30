package mai.project.compose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.R
import mai.project.compose.presentation.home.model.TabItem
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun CourseItems(
    courses: List<TabItem.Course>,
    onItemClick: (TabItem.Course) -> Unit
) {
    if (courses.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(courses) { course ->
                CourseItem(
                    course = course,
                    onClick = onItemClick
                )
                HorizontalDivider()
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.not_found),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun CourseItem(
    course: TabItem.Course,
    onClick: (TabItem.Course) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(course) })
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp),
    ) {
        Text(
            text = course.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = course.content,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}

@PreviewLightDark
@Composable
private fun CourseItemPreview() {
    Jetpack_Compose_LearningTheme {
        CourseItem(
            course = TabItem.Course(
                index = 1,
                title = "我是標題",
                content = "我是很長的內文我是很長的內文我是很長的內文我是很長的內文我是很長的內文我是很長的內文"
            ),
            onClick = {}
        )
    }
}