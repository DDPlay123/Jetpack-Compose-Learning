@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2.components_2_11

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import mai.project.compose.presentation.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.BasicText
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun SliderExample(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "基礎的 Slider")
        BasicSlider()

        CourseHintText(text = "帶有步數限制的 Slider")
        StepSlider()

        CourseHintText(text = "自定義外觀的 Slider")
        CustomSlider()

        CourseHintText(text = "基礎的 RangeSlider")
        BasicRangeSlider()
    }
}

@Composable
private fun BasicSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    BasicText(text = "%.2f".format(sliderPosition))
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it }
    )
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        colors = SliderDefaults.colors().copy(
            thumbColor = Color(0xffF44336),
            disabledThumbColor = Color(0xff795548),
            activeTrackColor = Color(0xff009688),
            inactiveTrackColor = Color(0xffFFEA00),
            disabledActiveTrackColor = Color(0xffFF9800),
            disabledInactiveTrackColor = Color(0xff616161),
            activeTickColor = Color(0xff673AB7),
            inactiveTickColor = Color(0xff2196F3),
            disabledActiveTickColor = Color(0xffE0E0E0),
            disabledInactiveTickColor = Color(0xff607D8B)
        )
    )
}

@Composable
private fun StepSlider() {
    val context = LocalContext.current
    var sliderPosition by remember { mutableFloatStateOf(50f) }

    BasicText(text = "%.2f".format(sliderPosition))
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        steps = 9,
        onValueChangeFinished = {
            Toast.makeText(context, "Position：$sliderPosition", Toast.LENGTH_SHORT).show()
        }
    )
}

@Composable
private fun CustomSlider() {
    var sliderPosition by remember { mutableFloatStateOf(.5f) }
    val interactionSource = remember { MutableInteractionSource() }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        interactionSource = interactionSource,
        thumb = {
            Label(
                isPersistent = false,
                label = {
                    PlainTooltip(
                        modifier = Modifier
                            .sizeIn(45.dp, 25.dp)
                            .wrapContentWidth(),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "%.2f".format(sliderPosition),
                            color = Color.Black
                        )
                    }
                },
                interactionSource = interactionSource
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    imageVector = ImageVector.vectorResource(R.drawable.vector_run_circle),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        },
        track = { sliderState ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            ) {
                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // inactive track
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(x = 0f, y = size.height / 2),
                        end = Offset(x = size.width, y = size.height / 2),
                        strokeWidth = size.height
                    )
                    // active track
                    drawLine(
                        color = Color(0xff009688),
                        start = Offset(x = 0f, y = size.height / 2),
                        end = Offset(x = size.width * sliderState.value, y = size.height / 2),
                        strokeWidth = size.height
                    )
                }
            }
        }
    )
}

@Composable
private fun BasicRangeSlider() {
    val rangeSliderState = remember {
        RangeSliderState(
            activeRangeStart = 0f,
            activeRangeEnd = 100f,
            valueRange = 0f..100f,
        )
    }

    val rangeStart = "%.2f".format(rangeSliderState.activeRangeStart)
    val rangeEnd = "%.2f".format(rangeSliderState.activeRangeEnd)
    BasicText(text = "$rangeStart - $rangeEnd")
    RangeSlider(state = rangeSliderState)
}

@PreviewLightDark
@Composable
private fun SliderExamplePreview() {
    Jetpack_Compose_LearningTheme {
        SliderExample()
    }
}