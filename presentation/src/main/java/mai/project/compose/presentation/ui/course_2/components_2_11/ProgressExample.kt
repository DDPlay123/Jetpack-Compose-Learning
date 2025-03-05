package mai.project.compose.presentation.ui.course_2.components_2_11

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.home.components.CourseHintText

@Composable
fun ProgressExample(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CourseHintText(text = "無限循環的 Progress")
        CircularProgressIndicator()
        LinearProgressIndicator()

        CourseHintText(text = "帶有進度的 Progress")
        DeterminateProgress(false)

        CourseHintText(text = "帶有動畫進度的 Progress")
        DeterminateProgress(true)
    }
}

private val progressFlow by lazy {
    flow {
        repeat(100) {
            emit(it + 1f)
            delay(50)
        }
    }
}

@Composable
private fun DeterminateProgress(
    isAnimate: Boolean
) {
    var resetTrigger by remember { mutableStateOf(false) }

    val progress by produceState(initialValue = 0f, key1 = resetTrigger) {
        progressFlow.collect { value ->
            this.value = value / 100f
        }
    }

    val animProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    CircularProgressIndicator(progress = { if (isAnimate) animProgress else progress })
    LinearProgressIndicator(progress = { if (isAnimate) animProgress else progress })
    Spacer(modifier = Modifier.height(8.dp))
    Button(
        onClick = { resetTrigger = !resetTrigger }
    ) {
        Text(text = "Reset")
    }
}

@PreviewLightDark
@Composable
private fun ProgressExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ProgressExample()
    }
}