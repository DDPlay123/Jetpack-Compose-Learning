package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_16_2_ScreenRoot() {
    Course_2_16_2_Screen()
}

@Composable
private fun Course_2_16_2_Screen(
    modifier: Modifier = Modifier,
) {
    val state = rememberPagerState { 10 }

    VerticalPager(
        modifier = modifier.fillMaxSize(),
        state = state
    ) { page ->
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = page.toString(),
                fontSize = 32.sp,
                color = Color.White
            )
        }
    }

}

@PreviewLightDark
@Composable
private fun Course_2_16_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_16_2_Screen()
    }
}