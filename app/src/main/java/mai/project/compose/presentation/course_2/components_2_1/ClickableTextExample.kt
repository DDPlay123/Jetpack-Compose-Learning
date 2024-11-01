package mai.project.compose.presentation.course_2.components_2_1

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ClickableTextExample(
    modifier: Modifier = Modifier
) {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        // 完整的文字
        val fullText = "這是一段局部可點擊的文字串"
        // 可點擊的部分
        val targetText = "可點擊"

        val startIndex = fullText.indexOf(targetText)
        val endIndex = startIndex + targetText.length

        // 先加入完整的文字
        append(fullText)

        // 針對可點擊的部分加入特殊的 span
        addStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            ),
            start = startIndex,
            end = endIndex
        )

        // 設定可點擊的部分
        addStringAnnotation(
            tag = "URL",
            annotation = "https://google.com",
            start = startIndex,
            end = endIndex
        )
    }

    val uriHandler: UriHandler = LocalUriHandler.current
    var layoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }

    // TODO: Deprecated(已棄用) ClickableText
//    ClickableText(
//        modifier = modifier
//            .background(Color.LightGray)
//            .padding(8.dp)
//            .fillMaxWidth(),
//        text = annotatedLinkString,
//        onClick = { offset ->
//            annotatedLinkString
//                .getStringAnnotations("URL", offset, offset)
//                .firstOrNull()?.let { stringAnnotation ->
//                    uriHandler.openUri(stringAnnotation.item)
//                }
//        }
//    )

    Text(
        text = annotatedLinkString,
        modifier = modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    layoutResult?.let { result ->
                        val position = result.getOffsetForPosition(offset)
                        annotatedLinkString
                            .getStringAnnotations(tag = "URL", start = position, end = position)
                            .firstOrNull()
                            ?.let { stringAnnotation ->
                                uriHandler.openUri(stringAnnotation.item)
                            }
                    }
                }
            },
        onTextLayout = { textLayoutResult -> layoutResult = textLayoutResult }
    )
}

/**
 * 使用 [LinkAnnotation]
 *
 * @see <a href="https://stackoverflow.com/questions/65567412/jetpack-compose-text-hyperlink-some-section-of-the-text">Stack Overflow</a>
 */
@Composable
fun ClickableTextExample2(
    modifier: Modifier = Modifier
) {
    val uriHandler: UriHandler = LocalUriHandler.current

    val annotatedString = buildAnnotatedString {
        append("這是一段局部")
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "URL",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = Color.Red,
                        textDecoration = TextDecoration.Underline
                    )
                ),
                linkInteractionListener = {
                    uriHandler.openUri("https://google.com")
                }
            )
        ) {
            append("可點擊")
        }
        append("的文字串")
    }
    Text(
        text = annotatedString,
        modifier = modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@PreviewLightDark
@Composable
private fun ClickableTextExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ClickableTextExample()
    }
}