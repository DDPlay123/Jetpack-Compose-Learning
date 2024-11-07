package mai.project.compose.di

import mai.project.compose.presentation.course_7.Course7ViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::Course7ViewModel)
}