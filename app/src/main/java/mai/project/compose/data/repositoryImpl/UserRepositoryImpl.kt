package mai.project.compose.data.repositoryImpl

import kotlinx.coroutines.flow.Flow
import mai.project.compose.data.datasource.PreferencesDataSource
import mai.project.compose.data.repository.UserRepository

class UserRepositoryImpl(
    private val preferencesDataSource: PreferencesDataSource
) : UserRepository {

    override suspend fun saveDarkTheme(isDarkTheme: Boolean) {
        preferencesDataSource.saveDarkTheme(isDarkTheme)
    }

    override fun readDarkTheme(): Flow<Boolean> {
        return preferencesDataSource.readDarkTheme
    }
}