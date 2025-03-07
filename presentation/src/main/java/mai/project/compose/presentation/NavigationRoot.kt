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
import mai.project.compose.presentation.ui.bonus.Bonus_0_1_ScreenRoot
import mai.project.compose.presentation.ui.bonus.Bonus_0_2_ScreenRoot
import mai.project.compose.presentation.ui.bonus.Bonus_0_3_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_10_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_10_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_11_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_12_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_13_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_14_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_15_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_16_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_16_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_17_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_17_2_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_17_3_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_17_4_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_18_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_19_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_4_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_5_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_6_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_7_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_5_8_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_6_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_7_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_8_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_9_1_ScreenRoot
import mai.project.compose.presentation.ui.course_2.Course_2_9_2_ScreenRoot
import mai.project.compose.presentation.ui.course_3.Course_3_1_1_ScreenRoot
import mai.project.compose.presentation.ui.course_3.Course_3_1_2_ScreenRoot

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
                    // Bonus
                    "0-1" -> Bonus_0_1_ScreenRoot()
                    "0-2" -> Bonus_0_2_ScreenRoot()
                    "0-3" -> Bonus_0_3_ScreenRoot()
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
                    "2-5-5" -> Course_2_5_5_ScreenRoot()
                    "2-5-6" -> Course_2_5_6_ScreenRoot()
                    "2-5-7" -> Course_2_5_7_ScreenRoot()
                    "2-5-8" -> Course_2_5_8_ScreenRoot()
                    "2-6" -> Course_2_6_ScreenRoot()
                    "2-7" -> Course_2_7_ScreenRoot()
                    "2-8" -> Course_2_8_ScreenRoot()
                    "2-9-1" -> Course_2_9_1_ScreenRoot()
                    "2-9-2" -> Course_2_9_2_ScreenRoot()
                    "2-10-1" -> Course_2_10_1_ScreenRoot()
                    "2-10-2" -> Course_2_10_2_ScreenRoot()
                    "2-11" -> Course_2_11_ScreenRoot()
                    "2-12" -> Course_2_12_ScreenRoot()
                    "2-13" -> Course_2_13_ScreenRoot()
                    "2-14" -> Course_2_14_ScreenRoot()
                    "2-15" -> Course_2_15_ScreenRoot()
                    "2-16-1" -> Course_2_16_1_ScreenRoot()
                    "2-16-2" -> Course_2_16_2_ScreenRoot()
                    "2-17-1" -> Course_2_17_1_ScreenRoot()
                    "2-17-2" -> Course_2_17_2_ScreenRoot()
                    "2-17-3" -> Course_2_17_3_ScreenRoot()
                    "2-17-4" -> Course_2_17_4_ScreenRoot()
                    "2-18" -> Course_2_18_ScreenRoot()
                    "2-19" -> Course_2_19_ScreenRoot()
                    // Course 3
                    "3-1-1" -> Course_3_1_1_ScreenRoot()
                    "3-1-2" -> Course_3_1_2_ScreenRoot()
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