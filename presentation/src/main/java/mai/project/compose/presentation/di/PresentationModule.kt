package mai.project.compose.presentation.di

import mai.project.compose.presentation.ui.bonus.Bonus03ViewModel
import mai.project.compose.presentation.ui.course_7.Course7ViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::Bonus03ViewModel)
    viewModelOf(::Course7ViewModel)
}