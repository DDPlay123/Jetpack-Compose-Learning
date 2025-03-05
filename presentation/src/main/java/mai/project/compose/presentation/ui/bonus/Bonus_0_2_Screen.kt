package mai.project.compose.presentation.ui.bonus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.bonus.components_0_2.Sunflower
import mai.project.compose.presentation.ui.bonus.components_0_2.Sunflower2
import mai.project.compose.presentation.ui.home.components.BasicText
import kotlin.math.roundToInt

@Composable
fun Bonus_0_2_ScreenRoot() {
    Bonus_0_2_Screen()
}

@Composable
private fun Bonus_0_2_Screen(
    modifier: Modifier = Modifier,
) {
    val pages = listOf("Sunflower", "Sunflower2")

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { pages.size }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            pages.forEach {
                val index = pages.indexOf(it)
                Tab(
                    selected = it == pages[pagerState.currentPage],
                    text = { Text(text = it) },
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Page(index)
            }
        }
    }
}

@Composable
private fun Page(
    index: Int,
) {
    val maxSeeds = 100
    var seeds by remember { mutableIntStateOf(maxSeeds / 2) }

    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (index == 0) {
            Sunflower(maxSeeds = maxSeeds, seeds = seeds)
        } else {
            Sunflower2(maxSeeds = maxSeeds, seeds = seeds)
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    BasicText(text = "Showing $seeds seeds")

    Slider(
        value = seeds.toFloat(),
        onValueChange = { seeds = it.roundToInt() },
        valueRange = 0f..maxSeeds.toFloat(),
        modifier = Modifier.width(300.dp)
    )
}

@PreviewLightDark
@Composable
private fun Bonus_0_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Bonus_0_2_Screen()
    }
}