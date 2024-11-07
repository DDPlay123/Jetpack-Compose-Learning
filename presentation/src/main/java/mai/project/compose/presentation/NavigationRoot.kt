package mai.project.compose.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import mai.project.compose.presentation.ui.course_1.Course_1_1_ScreenRoot
import mai.project.compose.presentation.ui.course_1.Course_1_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_3_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_4_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_3_ScreenRoot
import mai.project.compose.presentation.ui.course_7.Course_7_1_ScreenRoot
import mai.project.compose.presentation.ui.home.HomeScreenRoot
import mai.project.compose.presentation.ui.home.model.getHomeTab
import timber.log.Timber
import mai.project.compose.core.R
import mai.project.compose.presentation.ui.course_2.Course_2_5_4_ScreenRoot

private const val ROUTE_HOME = "ROUTE_HOME"

@Composable
fun NavigationRoot(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ) {
        homeGraph(
            context = context,
            navController = navController
        )
    }
}

private fun NavGraphBuilder.homeGraph(
    context: Context,
    navController: NavHostController
) {
    navigation(
        startDestination = "home",
        route = ROUTE_HOME
    ) {
        composable(route = "home") {
            HomeScreenRoot(onCourseClick = { course ->
                try {
                    navController.navigate(course.index)
                } catch (e: Exception) {
                    Timber.e(message = "Error navigation to ${course.index}", t = e)
                    Toast.makeText(context, context.getString(R.string.not_found), Toast.LENGTH_SHORT).show()
                }
            })
        }
        getHomeTab.flatMap { it.courses }.forEach { course ->
            composable(route = course.index) {
                when (course.index) {
                    // Course 1
                    "1-1" -> Course_1_1_ScreenRoot()
                    "1-2" -> Course_1_2_ScreenRoot()
                    // Course 2
                    "2-1" -> Course_2_1_ScreenRoot()
                    "2-2" -> Course_2_2_ScreenRoot()
                    "2-3" -> Course_2_3_ScreenRoot()
                    "2-4" -> Course_2_4_ScreenRoot()
                    "2-5-1" -> Course_2_5_1_ScreenRoot()
                    "2-5-2" -> Course_2_5_2_ScreenRoot()
                    "2-5-3" -> Course_2_5_3_ScreenRoot()
                    "2-5-4" -> Course_2_5_4_ScreenRoot()
                    // TODO Course 3
                    // TODO Course 4
                    // TODO Course 5
                    // TODO Course 6
                    // Course 7
                    "7-1" -> Course_7_1_ScreenRoot()
                    // TODO Course 8
                    // TODO Course 9
                }
            }
        }
    }
}