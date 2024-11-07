package mai.project.compose.presentation.ui.course_2.components_2_5

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import mai.project.compose.core.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun StarRatingBar(
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
    rating: Float,
    onRatingChanged: (Float) -> Unit = {}
) {
    // 由於星星的大小需要動態計算，所以使用 BoxWithConstraints 來取得可使用的寬高
    BoxWithConstraints(
        modifier = modifier
    ) {
        // 星星之間的間距
        val starSpace = 4.dp
        // 計算在可使用寬度中的星星大小
        val starSize = (maxWidth - (starSpace * (maxStars - 1))) / maxStars
        // 確保星星大小不小於 16.dp
        val constrainedStarSize = if (starSize < 16.dp) 16.dp else starSize

        Row(
            // 使用 selectableGroup() 確保同一時間，只能有一個 Star 被點擊
            modifier = Modifier
                .selectableGroup(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            for (i in 1..maxStars) {
                val isSelected = i <= rating

                Icon(
                    imageVector = if (isSelected) {
                        ImageVector.vectorResource(id = R.drawable.baseline_star_24)
                    } else {
                        ImageVector.vectorResource(id = R.drawable.baseline_star_border_24)
                    },
                    contentDescription = null,
                    tint = Color(0xFFFFC700),
                    modifier = Modifier
                        .selectable(
                            selected = isSelected,
                            onClick = { onRatingChanged(i.toFloat()) }
                        )
                        .size(constrainedStarSize)
                )

                if (i < maxStars) {
                    Spacer(modifier = Modifier.width(starSpace))
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
private fun StarRatingBarPreview() {
    Jetpack_Compose_LearningTheme {
        var rating by remember { mutableFloatStateOf(4f) }
        StarRatingBar(
            rating = rating,
            onRatingChanged = { rating = it }
        )
    }
}