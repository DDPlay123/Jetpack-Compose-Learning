package mai.project.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mai.project.compose.presentation.home.HomeScreenRoot
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_Compose_LearningTheme {
                HomeScreenRoot()
            }
        }
    }
}