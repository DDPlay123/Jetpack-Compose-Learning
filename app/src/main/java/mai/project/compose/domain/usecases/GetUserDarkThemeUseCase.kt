package mai.project.compose.domain.usecases

import kotlinx.coroutines.flow.Flow
import mai.project.compose.data.repository.UserRepository

class GetUserDarkThemeUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return userRepository.readDarkTheme()
    }
}