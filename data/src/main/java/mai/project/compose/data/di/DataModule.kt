package mai.project.compose.data.di

import mai.project.compose.data.datasource.PreferencesDataSource
import mai.project.compose.data.repository.UserRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    // datasource
    singleOf(::PreferencesDataSource)

    // repository
    singleOf(::UserRepository)
}