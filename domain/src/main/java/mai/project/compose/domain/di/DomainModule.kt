package mai.project.compose.domain.di

import mai.project.compose.domain.usecases.GetUserThemeUseCase
import mai.project.compose.domain.usecases.SaveUserThemeUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    // 系統的主題類型
    singleOf(::GetUserThemeUseCase)
    singleOf(::SaveUserThemeUseCase)
}