package mai.project.compose.presentation.course_2

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
import mai.project.compose.presentation.course_2.components_2_2.ButtonBackgroundExample
import mai.project.compose.presentation.course_2.components_2_2.ButtonEnableExample
import mai.project.compose.presentation.course_2.components_2_2.ButtonGradientExample
import mai.project.compose.presentation.course_2.components_2_2.ButtonShapeExample
import mai.project.compose.presentation.course_2.components_2_2.ButtonWithIconExample
import mai.project.compose.presentation.course_2.components_2_2.ChipExample
import mai.project.compose.presentation.course_2.components_2_2.CustomChipExample
import mai.project.compose.presentation.course_2.components_2_2.FloatingActionButtonExample
import mai.project.compose.presentation.course_2.components_2_2.IconButtonExample
import mai.project.compose.presentation.home.components.CourseHintText
import mai.project.compose.presentation.home.components.CourseTitleText

@Composable
fun Course_2_2_ScreenRoot() {
    Course_2_2_Screen()
}

@Composable
private fun Course_2_2_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Button")
        CourseHintText(text = "Button Enable 樣式")
        ButtonEnableExample(enabled = true)
        CourseHintText(text = "Button Disable 樣式")
        ButtonEnableExample(enabled = false)
        CourseHintText(text = "Button Shape 樣式")
        ButtonShapeExample()
        CourseHintText(text = "Button + Icon 樣式")
        ButtonWithIconExample()
        CourseHintText(text = "Button + Background 樣式")
        ButtonBackgroundExample()
        CourseHintText(text = "Button + Gradient 樣式")
        ButtonGradientExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Icon Button")
        CourseHintText(text = "IconButton 樣式")
        IconButtonExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Floating Action Button")
        CourseHintText(text = "Floating Action Button 樣式")
        FloatingActionButtonExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Chip")
        CourseHintText(text = "chip 樣式")
        ChipExample()
        CourseHintText(text = "自定義 chip 樣式")
        CustomChipExample()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_2_ScreenPreview() {
    Course_2_2_Screen()
}