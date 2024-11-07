import com.android.build.api.dsl.ApplicationExtension
import mai.project.compose.convention.ExtensionType
import mai.project.compose.convention.configureAndroidCompose
import mai.project.compose.convention.configureBuildTypes
import mai.project.compose.convention.configureKotlinAndroid
import mai.project.compose.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * 設定 Application Module 的 Plugin
 */
class AndroidApplicationConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion("applicationId").get().toString()
                    targetSdk = libs.findVersion("targetSdk").get().toString().toInt()

                    versionCode = libs.findVersion("versionCode").get().toString().toInt()
                    versionName = libs.findVersion("versionName").get().toString()
                }

                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )

                configureAndroidCompose(this)

                dependencies {
                    "implementation"(libs.findLibrary("timber").get())

                    "implementation"(platform(libs.findLibrary("koin.bom").get()))
                    "implementation"(libs.findBundle("koin").get())
                }
            }
        }
    }
}