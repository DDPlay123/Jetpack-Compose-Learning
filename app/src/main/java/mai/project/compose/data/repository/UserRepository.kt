package mai.project.compose.data.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun saveDarkTheme(isDarkTheme: Boolean)

    fun readDarkTheme(): Flow<Boolean>
}
