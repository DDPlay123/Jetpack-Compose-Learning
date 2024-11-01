package mai.project.compose

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
import mai.project.compose.presentation.course_1.Course_1_1_ScreenRoot
import mai.project.compose.presentation.course_1.Course_1_2_ScreenRoot
import mai.project.compose.presentation.home.HomeScreenRoot

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
            HomeScreenRoot(onCourseClick = { index, course ->
                when {
                    index == 1 && course.index == 1 -> navController.navigate("1-1")

                    index == 1 && course.index == 2 -> navController.navigate("1-2")

                    else -> Toast.makeText(context, context.getString(R.string.not_found), Toast.LENGTH_SHORT).show()
                }
            })
        }
        // Course 1
        composable(route = "1-1") { Course_1_1_ScreenRoot() }
        composable(route = "1-2") { Course_1_2_ScreenRoot() }
        // TODO Course 2
        // TODO Course 3
        // TODO Course 4
        // TODO Course 5
        // TODO Course 6
        // TODO Course 7
        // TODO Course 8
        // TODO Course 9
    }
}