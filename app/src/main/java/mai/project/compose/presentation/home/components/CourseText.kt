package mai.project.compose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

/**
 * 標題文字
 */
@Composable
fun CourseTitleText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 12.dp, bottom = 6.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary,
        text = text
    )
}

private val boldRegex = Regex("(?<!\\*)\\*\\*(?!\\*).*?(?<!\\*)\\*\\*(?!\\*)")

/**
 * 內文文字
 *
 * - 當傳入的文本中，包含「**」包圍的文字，將使用特殊的樣式來顯示
 *
 * @param bullets 是否讓前 3 個字為粗體
 */
@Composable
fun CourseContentText(
    modifier: Modifier = Modifier,
    text: String,
    bullets: Boolean = true
) {
    var results: MatchResult? = boldRegex.find(text)
    val boldIndexes = mutableListOf<Pair<Int, Int>>()
    val keywords = mutableListOf<String>()

    var finalText = text

    while (results != null) {
        keywords.add(results.value)
        results = results.next()
    }

    keywords.forEach { keyword ->
        val newKeyWord = keyword.removeSurrounding("**")
        finalText = finalText.replace(keyword, newKeyWord)
        val indexOf = finalText.indexOf(newKeyWord)
        boldIndexes.add(Pair(indexOf, indexOf + newKeyWord.length))
    }

    val annotatedString = buildAnnotatedString {

        append(finalText)

        if (bullets) {
            addStyle(style = SpanStyle(fontWeight = FontWeight.Bold), start = 0, end = 3)
        }

        // 新增粗體部分
        boldIndexes.forEach {
            addStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff64B5F6),
                    fontSize = 15.sp
                ),
                start = it.first,
                end = it.second
            )
        }
    }

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        fontSize = 16.sp,
        color = if (isSystemInDarkTheme()) {
            Color.White
        } else {
            Color.Black
        },
        text = annotatedString
    )
}

/**
 * 提示文字
 */
@Composable
fun CourseHintText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Gray,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@PreviewLightDark
@Composable
private fun CourseTextPreview() {
    Jetpack_Compose_LearningTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            CourseTitleText(
                text = "我是標題"
            )
            CourseContentText(
                text = "1-1 我是很長的內文，我是**特殊文字**"
            )
            CourseHintText(
                text = "我是提示文字"
            )
        }
    }
}