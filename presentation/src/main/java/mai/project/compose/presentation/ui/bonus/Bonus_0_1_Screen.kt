package mai.project.compose.presentation.ui.bonus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.bonus.components_0_1.CenteredSliderImpl
import mai.project.compose.presentation.ui.bonus.components_0_1.LineSliderImpl
import mai.project.compose.presentation.ui.bonus.components_0_1.StretchySlider
import mai.project.compose.presentation.ui.home.components.CourseContentText
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun Bonus_0_1_ScreenRoot() {
    Bonus_0_1_Screen()
}

@Composable
private fun Bonus_0_1_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseContentText(text = "1-) Custom Sliders in Jetpack Compose")
        CourseHintText(text = "https://www.sinasamaki.com/custom-material-3-sliders-in-jetpack-compose/")
        LineSliderImpl()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "2-) Implementing Overslide interaction in Jetpack Compose")
        CourseHintText(text = "https://www.sinasamaki.com/implementing-overslide-slider-interaction-in-jetpack-compose/")
        StretchySlider()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseContentText(text = "1-) Centered Slider in Jetpack Compose")
        CourseHintText(text = "https://www.sinasamaki.com/centered-slider-in-jetpack-compose/")
        CenteredSliderImpl()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Bonus_0_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Bonus_0_1_Screen()
    }
}