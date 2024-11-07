package mai.project.compose.data.utils

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber

object DataStoreUtil {
    /**
     * Clear All DataStore
     */
    suspend fun DataStore<Preferences>.clearAll() = edit { it.clear() }

    /**
     * PUT Any Variable
     */
    suspend inline fun <reified T> DataStore<Preferences>.putData(key: String, value: T) =
        edit {
            when (T::class) {
                Int::class -> it[intPreferencesKey(key)] = value as Int
                Long::class -> it[longPreferencesKey(key)] = value as Long
                String::class -> it[stringPreferencesKey(key)] = value as String
                Boolean::class -> it[booleanPreferencesKey(key)] = value as Boolean
                Float::class -> it[floatPreferencesKey(key)] = value as Float
                Double::class -> it[doublePreferencesKey(key)] = value as Double
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }

    /**
     * GET Any Variable
     */
    inline fun <reified T> DataStore<Preferences>.getData(key: String, default: T): Flow<T> {
        return data.catch { exception ->
            if (exception is IOException) {
                Timber.e(message = "Error get data", t = exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            when (T::class) {
                Int::class -> (it[intPreferencesKey(key)] ?: default) as T
                Long::class -> (it[longPreferencesKey(key)] ?: default) as T
                String::class -> it[stringPreferencesKey(key)] as T
                Boolean::class -> (it[booleanPreferencesKey(key)] ?: default) as T
                Float::class -> (it[floatPreferencesKey(key)] ?: default) as T
                Double::class -> (it[doublePreferencesKey(key)] ?: default) as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }
    }
}