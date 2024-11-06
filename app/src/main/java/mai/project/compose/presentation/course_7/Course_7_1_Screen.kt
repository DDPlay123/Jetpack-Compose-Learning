package mai.project.compose.presentation.course_7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mai.project.compose.domain.usecases.GetUserDarkThemeUseCase
import mai.project.compose.domain.usecases.SaveUserDarkThemeUseCase
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme
import org.koin.java.KoinJavaComponent.inject

@Composable
fun Course_7_1_ScreenRoot() {
    Course_7_1_Screen()
}

@Composable
private fun Course_7_1_Screen(
    modifier: Modifier = Modifier
) {
    val saveDarkTheme: SaveUserDarkThemeUseCase by inject(SaveUserDarkThemeUseCase::class.java)
    val getDarkTheme: GetUserDarkThemeUseCase by inject(GetUserDarkThemeUseCase::class.java)
    val isDarkTheme = getDarkTheme().collectAsStateWithLifecycle(initialValue = false)

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                val newTheme = !isDarkTheme.value
                scope.launch(Dispatchers.IO) {
                    saveDarkTheme(newTheme)
                }
            }
        ) {
            Text(
                text = if (isDarkTheme.value) {
                    "Light Theme"
                } else {
                    "Dark Theme"
                }
            )
        }
    }
}

@Preview
@Composable
private fun Course_7_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_7_1_Screen()
    }
}