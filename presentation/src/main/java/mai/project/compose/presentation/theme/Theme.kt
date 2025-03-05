package mai.project.compose.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.domain.usecases.GetUserThemeUseCase
import org.koin.compose.koinInject

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Jetpack_Compose_LearningTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // 如果不在預覽模式下，則使用 Koin 注入
    getThemeType: GetUserThemeUseCase? = if (!LocalInspectionMode.current) koinInject() else null,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // 此處是為了修復在預覽模式下，無法讀取 UseCase 的情況
    val getThemeState = if (getThemeType != null) {
        getThemeType()
            .collectAsStateWithLifecycle(initialValue = ThemeType.DEFAULT)
    } else {
        remember { mutableIntStateOf(ThemeType.DEFAULT) }
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            when (getThemeState.value) {
                ThemeType.DEFAULT -> if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
                ThemeType.DARK -> dynamicDarkColorScheme(context)
                else -> dynamicLightColorScheme(context)
            }
        }

        getThemeState.value == ThemeType.DEFAULT -> if (darkTheme) DarkColorScheme else LightColorScheme
        getThemeState.value == ThemeType.DARK -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}