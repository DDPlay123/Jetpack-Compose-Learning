package mai.project.compose.presentation.ui.course_1.components_1_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun PaddingExample(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .background(Color(0xFFF06292))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                // 先設定背景為黃色，接著內縮 15dp
                .background(Color(0xFFFFEB3B))
                .padding(15.dp)
                // 再設定背景為白色，再內縮 8dp
                .background(Color(0xFFFFFFFF))
                .padding(8.dp)
        ) {
            Text(text = "Text A1")
            Text(text = "Text A2")
            Text(text = "Text A3")
        }

        Column(
            modifier = Modifier
                // 先內縮 10dp，接著設定背景為藍色，再內縮 15dp
                .padding(10.dp)
                .background(Color(0xFF80DEEA))
                .padding(end = 15.dp)
                // 再設定背景為紫色，再內縮頂部及底部分別為 12dp 和 22dp
                .background(Color(0xFF9575CD))
                .padding(top = 12.dp, bottom = 22.dp)
        ) {
            Text(text = "Text B1")
            Text(text = "Text B2")
            Text(text = "Text B3")
        }

        Column(
            modifier = Modifier
                // 先設定背景為深藍色，再內縮 15dp
                .background(Color(0xFF607D8B))
                .padding(15.dp)
                // 再設定背景為綠色
                .background(Color(0xFFB2FF59))
        ) {
            Text(text = "Text C1")
            Text(text = "Text C2")
            Text(text = "Text C3")
        }
    }
}

@PreviewLightDark
@Composable
private fun PaddingExamplePreview() {
    Jetpack_Compose_LearningTheme {
        PaddingExample()
    }
}