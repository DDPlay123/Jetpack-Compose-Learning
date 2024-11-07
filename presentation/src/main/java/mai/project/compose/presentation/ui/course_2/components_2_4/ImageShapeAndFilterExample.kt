@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.ui.course_2.components_2_4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import mai.project.compose.core.R
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun ImageShapeAndFilterExample(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        val avatarBitmap1 = painterResource(id = R.drawable.avatar_1_raster)
        val avatarBitmap2 = painterResource(id = R.drawable.avatar_2_raster)
        val avatarBitmap3 = painterResource(id = R.drawable.avatar_3_raster)
        val avatarBitmap4 = painterResource(id = R.drawable.avatar_4_raster)

        CourseHintText(text = "形狀 Shape")
        FlowRow(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 10.dp)),
                painter = avatarBitmap1,
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        shape = CircleShape
                    )
                    .clip(CircleShape),
                painter = avatarBitmap2,
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp,
                        shape = CutCornerShape(size = 10.dp)
                    )
                    .clip(CutCornerShape(size = 10.dp)),
                painter = avatarBitmap3,
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        // 繪製菱形
                        shape = GenericShape { size: Size, _: LayoutDirection ->
                            // 頂部的中心
                            moveTo(size.width / 2f, 0f)
                            // 右側的中心
                            lineTo(size.width, size.height / 2f)
                            // 底部的中心
                            lineTo(size.width / 2f, size.height)
                            // 左側的中心
                            lineTo(0f, size.height / 2f)
                        },
                        clip = true
                    ),
                painter = avatarBitmap4,
                contentDescription = null
            )
        }

        CourseHintText(text = "濾鏡 Filter")
        FlowRow(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // BlendMode：混合模式，用於混和原始圖層和目標圖層的顏色。
            Image(
                painter = avatarBitmap1,
                colorFilter = ColorFilter.tint(
                    color = Color.Green,
                    // 只保留較暗的顏色
                    blendMode = BlendMode.Darken
                ),
                contentDescription = null
            )

            Image(
                painter = avatarBitmap1,
                colorFilter = ColorFilter.tint(
                    color = Color.Green,
                    // 只保留較亮的顏色
                    blendMode = BlendMode.Lighten
                ),
                contentDescription = null
            )

            Image(
                painter = avatarBitmap1,
                colorFilter = ColorFilter.tint(
                    color = Color.Green,
                    // 計算原圖與目標圖的差，並取絕對值
                    // 色彩相近的部分會較暗，呈現顏色反轉的效果
                    blendMode = BlendMode.Difference
                ),
                contentDescription = null
            )

            Image(
                painter = avatarBitmap1,
                colorFilter = ColorFilter.tint(
                    color = Color(0xFFEEEEEE),
                    // 改變飽和度，此圖顏色會變為更淡
                    blendMode = BlendMode.Saturation
                ),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun ImageShapeAndFilterExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ImageShapeAndFilterExample()
    }
}