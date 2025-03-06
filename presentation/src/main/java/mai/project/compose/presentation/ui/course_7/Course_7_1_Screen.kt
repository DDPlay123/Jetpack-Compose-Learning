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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.domain.usecases.GetUserThemeUseCase
import mai.project.compose.domain.usecases.SaveUserThemeUseCase
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

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

class Course7ViewModel(
    getUserThemeUseCase: GetUserThemeUseCase,
    private val saveUserThemeUseCase: SaveUserThemeUseCase
) : ViewModel() {

    val readThemeType = getUserThemeUseCase()
        .catch { e -> Timber.e(message = "Failed to fetch theme type", t = e) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(stopTimeoutMillis = 500L), ThemeType.DEFAULT)

    fun saveThemeType(@ThemeType type: Int) {
        viewModelScope.launch { saveUserThemeUseCase(type) }
    }
}