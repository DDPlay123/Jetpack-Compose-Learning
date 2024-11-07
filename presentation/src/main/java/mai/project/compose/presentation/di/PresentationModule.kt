package mai.project.compose.presentation.di

import mai.project.compose.presentation.ui.course_7.Course7ViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::Course7ViewModel)
}