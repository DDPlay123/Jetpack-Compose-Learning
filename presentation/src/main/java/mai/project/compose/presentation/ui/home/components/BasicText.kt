package mai.project.compose.presentation.ui.home.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mai.project.compose.core.annotations.ThemeType
import mai.project.compose.domain.usecases.GetUserThemeUseCase
import org.koin.compose.koinInject

@Composable
fun BasicText(
    modifier: Modifier = Modifier,
    text: String,
    getThemeType: GetUserThemeUseCase? = if (!LocalInspectionMode.current) koinInject() else null,
) {
    val getThemeState = if (getThemeType != null) {
        getThemeType().collectAsStateWithLifecycle(initialValue = ThemeType.DEFAULT)
    } else {
        remember { mutableIntStateOf(ThemeType.DEFAULT) }
    }

    Text(
        modifier = modifier,
        text = text,
        fontSize = 16.sp,
        color = when (getThemeState.value) {
            ThemeType.DEFAULT -> if (isSystemInDarkTheme()) Color.White else Color.Black
            ThemeType.DARK -> Color.White
            else -> Color.Black
        }
    )
}