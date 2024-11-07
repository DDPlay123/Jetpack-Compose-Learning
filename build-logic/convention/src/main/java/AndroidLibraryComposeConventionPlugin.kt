import com.android.build.api.dsl.LibraryExtension
import mai.project.compose.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * 設定 Library Module 的 Plugin
 *
 * - 引用 AndroidLibraryConventionPlugin 的內容
 * - 同時添加 Compose 的屬性
 */
class AndroidLibraryComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("mai.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}