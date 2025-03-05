@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.BasicTooltipBox
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseHintText
import mai.project.compose.presentation.ui.home.components.CourseTitleText

@Composable
fun Course_2_19_ScreenRoot() {
    Course_2_19_Screen()
}

@Composable
private fun Course_2_19_Screen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseTitleText(text = "TooltipBox + PlainTooltip")
        CourseHintText(text = "PlainTooltip 提供描述性訊息的普通工具提示。")
        TooltipBoxWithPlainTooltip()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "TooltipBox + RichTooltip")
        CourseHintText(text = "RichTooltip 允許使用者傳遞標題、文字和動作。用於提供描述詳細訊息的提示。")
        TooltipBoxWithRichTooltip()
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))

        CourseTitleText(text = "BasicTooltipBox + 自訂 Tooltip")
        BasicTooltipBoxWithCustomTooltip()

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun TooltipBoxWithPlainTooltip() {
    val tooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()

    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text(text = "這是 PlainTooltip")
            }
        },
        state = tooltipState
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    tooltipState.show()
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun TooltipBoxWithRichTooltip() {
    val tooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()

    TooltipBox(
        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
        tooltip = {
            RichTooltip(
                title = { Text(text = "刪除") },
                text = { Text(text = "刪除此項目，此操作不可復原") },
                action = {
                    TextButton(
                        onClick = {
                            scope.launch {
                                tooltipState.dismiss()
                            }
                        }
                    ) {
                        Text(text = "確認")
                    }
                },
                tonalElevation = 4.dp
            )
        },
        state = tooltipState
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    tooltipState.show()
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun BasicTooltipBoxWithCustomTooltip() {
    val tooltipState = rememberBasicTooltipState()
    val scope = rememberCoroutineScope()

    BasicTooltipBox(
        tooltip = {
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color.LightGray
            ) {
                Text(
                    "這是 Tooltip",
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp)
                )
            }
        },
        state = tooltipState,
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider()
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    tooltipState.show()
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Course_2_19_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_19_Screen()
    }
}