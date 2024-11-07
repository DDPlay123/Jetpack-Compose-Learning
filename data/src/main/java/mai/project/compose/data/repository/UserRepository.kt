package mai.project.compose.data.repository

import kotlinx.coroutines.flow.Flow
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.data.datasource.PreferencesDataSource

/**
 * 使用者資料儲存庫
 *
 * - 使用者偏好設定的儲存
 */
class UserRepository(
    private val preferencesDataSource: PreferencesDataSource
) {
    /**
     * 清空所有偏好設定
     */
    suspend fun clearAllPreferences() =
        preferencesDataSource.clearAllPreferences()

    /**
     * 寫入系統的主題類型
     */
    suspend fun saveThemeType(@ThemeType type: Int) =
        preferencesDataSource.saveThemeType(type)

    /**
     * 讀取系統的主題類型
     */
    fun readThemeType(): Flow<Int> =
        preferencesDataSource.readThemeType
}
