package mai.project.compose.domain.usecases

import mai.project.compose.data.repository.UserRepository

class SaveUserDarkThemeUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(isDarkTheme: Boolean) {
        userRepository.saveDarkTheme(isDarkTheme)
    }
}