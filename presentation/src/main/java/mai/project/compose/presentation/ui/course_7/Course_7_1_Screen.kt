package mai.project.compose.presentation.ui.course_7

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun Course_7_1_ScreenRoot() {
    Course_7_1_Screen()
}

@Composable
private fun Course_7_1_Screen(
    modifier: Modifier = Modifier,
    viewModel: Course7ViewModel = koinViewModel()
) {
    val isDarkTheme = isSystemInDarkTheme()
    val getThemeState = viewModel.readThemeType
        .collectAsStateWithLifecycle(initialValue = ThemeType.DEFAULT)

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                val newTheme = when (getThemeState.value) {
                    ThemeType.DEFAULT -> if (isDarkTheme) {
                        ThemeType.LIGHT
                    } else {
                        ThemeType.DARK
                    }
                    ThemeType.DARK -> ThemeType.LIGHT
                    else -> ThemeType.DARK
                }
                scope.launch(Dispatchers.IO) {
                    viewModel.saveThemeType(newTheme)
                }
            }
        ) {
            Text(
                text = when (getThemeState.value) {
                    ThemeType.DEFAULT -> if (isDarkTheme) {
                        "Default：Light Theme"
                    } else {
                        "Default：Dark Theme"
                    }

                    ThemeType.DARK -> {
                        "Light Theme"
                    }

                    else -> {
                        "Dark Theme"
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun Course_7_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_7_1_Screen()
    }
}