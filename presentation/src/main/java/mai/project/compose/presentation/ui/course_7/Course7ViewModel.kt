package mai.project.compose.presentation.ui.course_7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.domain.usecases.GetUserThemeUseCase
import mai.project.compose.domain.usecases.SaveUserThemeUseCase
import timber.log.Timber

class Course7ViewModel(
    private val getUserThemeUseCase: GetUserThemeUseCase,
    private val saveUserThemeUseCase: SaveUserThemeUseCase
) : ViewModel() {

    val readThemeType = getUserThemeUseCase()
        .catch { e -> Timber.e(message = "Failed to fetch theme type", t = e) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(stopTimeoutMillis = 500L), ThemeType.DEFAULT)

    fun saveThemeType(@ThemeType type: Int) {
        viewModelScope.launch { saveUserThemeUseCase(type) }
    }
}