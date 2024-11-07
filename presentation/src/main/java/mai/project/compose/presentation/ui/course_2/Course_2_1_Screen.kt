package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.ui.course_2.components_2_1.ClickableTextExample
import mai.project.compose.presentation.ui.course_2.components_2_1.FontColorExample
import mai.project.compose.presentation.ui.course_2.components_2_1.FontFamilyExample
import mai.project.compose.presentation.ui.course_2.components_2_1.FontSizeExample
import mai.project.compose.presentation.ui.course_2.components_2_1.FontStyleExample
import mai.project.compose.presentation.ui.course_2.components_2_1.FontWeightExample
import mai.project.compose.presentation.ui.course_2.components_2_1.LetterSpacingExample
import mai.project.compose.presentation.ui.course_2.components_2_1.LineHeightExample
import mai.project.compose.presentation.ui.course_2.components_2_1.SelectableTextExample
import mai.project.compose.presentation.ui.course_2.components_2_1.SpannableTextExample
import mai.project.compose.presentation.ui.course_2.components_2_1.SubscriptTextExample
import mai.project.compose.presentation.ui.course_2.components_2_1.SuperscriptTextExample
import mai.project.compose.presentation.ui.course_2.components_2_1.TextBackgroundExample
import mai.project.compose.presentation.ui.course_2.components_2_1.TextBorderExample
import mai.project.compose.presentation.ui.course_2.components_2_1.TextDecorationExample
import mai.project.compose.presentation.ui.course_2.components_2_1.TextOverflowExample
import mai.project.compose.presentation.ui.course_2.components_2_1.TextShadowExample
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.ui.home.components.CourseTitleText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_1_ScreenRoot() {
    Course_2_1_Screen()
}

@Composable
private fun Course_2_1_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Text")
        CourseHintText(text = "字體顏色 Font Color")
        FontColorExample()
        CourseHintText(text = "字體大小 Font Size")
        FontSizeExample()
        CourseHintText(text = "字體風格 Font Style")
        FontStyleExample()
        CourseHintText(text = "字體粗細 Font Weight")
        FontWeightExample()
        CourseHintText(text = "字體家族 Font Family")
        FontFamilyExample()
        CourseHintText(text = "文字間距 Letter Spacing")
        LetterSpacingExample()
        CourseHintText(text = "文字裝飾 Text Decoration")
        TextDecorationExample()
        CourseHintText(text = "文字行高 Line Height")
        LineHeightExample()
        CourseHintText(text = "文字溢出 Text Overflow")
        TextOverflowExample()
        CourseHintText(text = "文字背景 Text Background")
        TextBackgroundExample()
        CourseHintText(text = "文字邊框 Text Border")
        TextBorderExample()
        CourseHintText(text = "文字陰影 Text Shadow")
        TextShadowExample()
        CourseHintText(text = "可擴展的文字 Spannable Text")
        SpannableTextExample()
        CourseHintText(text = "可點擊的文字 Clickable Text")
        ClickableTextExample()
        CourseHintText(text = "下標文字 Subscript Text")
        SubscriptTextExample()
        CourseHintText(text = "上標文字 Superscript Text")
        SuperscriptTextExample()
        CourseHintText(text = "可選擇的文字 Selectable Text")
        SelectableTextExample()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_2_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_1_Screen()
    }
}