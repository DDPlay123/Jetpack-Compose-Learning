package mai.project.compose.di

import mai.project.compose.data.datasource.PreferencesDataSource
import mai.project.compose.data.repository.UserRepository
import mai.project.compose.data.repositoryImpl.UserRepositoryImpl
import mai.project.compose.domain.usecases.GetUserDarkThemeUseCase
import mai.project.compose.domain.usecases.SaveUserDarkThemeUseCase
import org.koin.dsl.module

val appModule = module {
    single { PreferencesDataSource(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single { SaveUserDarkThemeUseCase(get()) }
    single { GetUserDarkThemeUseCase(get()) }
}