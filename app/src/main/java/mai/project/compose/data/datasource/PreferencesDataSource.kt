package mai.project.compose.data.datasource

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import mai.project.compose.data.utils.DataStoreUtil.clearAll
import mai.project.compose.data.utils.DataStoreUtil.getData
import mai.project.compose.data.utils.DataStoreUtil.putData

val Context.dataStore by preferencesDataStore(
    name = "app_prefs",
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, "app_prefs"))
    }
)

class PreferencesDataSource(
    // INFO ApplicationContext
    context: Context
) {

    private val dataStore = context.dataStore

    suspend fun clearAllPreferences() = dataStore.clearAll()

    val readDarkTheme: Flow<Boolean> = dataStore.getData(KEY_DARK_THEME, false)

    suspend fun saveDarkTheme(isDarkTheme: Boolean) = dataStore.putData(KEY_DARK_THEME, isDarkTheme)

    companion object {
        // 是否為暗色模式
        private const val KEY_DARK_THEME = "dark_theme"
    }
}
