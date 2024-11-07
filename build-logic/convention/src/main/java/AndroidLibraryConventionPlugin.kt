import com.android.build.api.dsl.LibraryExtension
import mai.project.compose.convention.ExtensionType
import mai.project.compose.convention.configureBuildTypes
import mai.project.compose.convention.configureKotlinAndroid
import mai.project.compose.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

/**
 * 設定 Library Module 的 Plugin
 */
class AndroidLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                "testImplementation"(kotlin("test"))

                "implementation"(libs.findLibrary("timber").get())

                "implementation"(platform(libs.findLibrary("koin.bom").get()))
                "implementation"(libs.findBundle("koin").get())
            }
        }
    }
}