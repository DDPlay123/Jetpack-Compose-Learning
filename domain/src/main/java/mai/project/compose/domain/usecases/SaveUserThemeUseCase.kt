package mai.project.compose.domain.usecases

import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.data.repository.UserRepository

/**
 * 寫入系統的主題類型的 UseCase
 */
class SaveUserThemeUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(@ThemeType type: Int) {
        userRepository.saveThemeType(type)
    }
}