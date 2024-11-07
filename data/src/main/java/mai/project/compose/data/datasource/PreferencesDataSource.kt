package mai.project.compose.data.datasource

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.data.utils.DataStoreUtil.clearAll
import mai.project.compose.data.utils.DataStoreUtil.getData
import mai.project.compose.data.utils.DataStoreUtil.putData

val Context.dataStore by preferencesDataStore(
    name = "app_prefs",
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, "app_prefs"))
    }
)

/**
 * 使用者偏好設定資料來源
 *
 * @param context 使用 ApplicationContext
 */
class PreferencesDataSource(
    context: Context
) {
    private val dataStore = context.dataStore

    /**
     * 清除所有偏好設定
     */
    suspend fun clearAllPreferences() = dataStore.clearAll()

    /**
     * 讀寫系統的主題類型
     */
    val readThemeType: Flow<Int> = dataStore.getData(KEY_THEME_TYPE, ThemeType.DEFAULT)
    suspend fun saveThemeType(@ThemeType type: Int) { dataStore.putData(KEY_THEME_TYPE, type) }

    companion object {
        // Key：系統的主題類型
        private const val KEY_THEME_TYPE = "KEY_THEME_TYPE"
    }
}
