package mai.project.compose.presentation.course_1

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
import mai.project.compose.presentation.components.CourseContentText
import mai.project.compose.presentation.components.CourseTitleText
import mai.project.compose.presentation.course_1.components.BoxExample
import mai.project.compose.presentation.course_1.components.ColumnExample
import mai.project.compose.presentation.course_1.components.PaddingExample
import mai.project.compose.presentation.course_1.components.RowExample
import mai.project.compose.presentation.course_1.components.ShadowExample
import mai.project.compose.presentation.course_1.components.SpacerExample
import mai.project.compose.presentation.course_1.components.WeightExample
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_1_1_ScreenRoot() {
    Course_1_1_Screen()
}

@Composable
private fun Course_1_1_Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        CourseTitleText(text = "Row")
        CourseContentText(text = "1-) **Row** 是一種佈局組件，用於將其子組件按水平方向排列")
        RowExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Column")
        CourseContentText(text = "2-) **Column** 是一種佈局組件，用於將其子組件按垂直方向排列")
        ColumnExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Box")
        CourseContentText(text = "3-) **Box** 將子組件像堆疊一樣對齊在彼此之上。最後宣告的組件位於最上層")
        BoxExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Padding 與 Margin")
        CourseContentText(text = "4-) **Padding** 屬性的順序決定該組件是內邊距（padding）還是外邊距（margin)")
        PaddingExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "陰影效果")
        CourseContentText(text = "5-) 自定義**陰影效果**")
        ShadowExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Spacer")
        CourseContentText(text = "6-) **Spacer** 用於產生一個空白區域，用於分隔不同組件")
        SpacerExample()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "Weight")
        CourseContentText(text = "7-) **Weight** 和 Column 和 Row 组件一起使用，根據總權重決定每個子組件應佔據父組件的多少空間")
        WeightExample()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun Course_1_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_1_1_Screen()
    }
}