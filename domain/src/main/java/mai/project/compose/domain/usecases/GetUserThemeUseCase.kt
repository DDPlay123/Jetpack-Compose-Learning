package mai.project.compose.domain.usecases

import kotlinx.coroutines.flow.Flow
import mai.project.compose.data.repository.UserRepository

/**
 * 取得系統的主題類型的 UseCase
 */
class GetUserThemeUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<Int> {
        return userRepository.readThemeType()
    }
}