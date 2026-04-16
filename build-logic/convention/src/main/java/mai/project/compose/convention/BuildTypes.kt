package mai.project.compose.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project

/**
 * 設定 Application/Library Module 的 BuildType 內容
 */
internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension,
    extensionType: ExtensionType
) {
    commonExtension.run {
        buildFeatures.buildConfig = true
        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

    // AGP 9.x: buildTypes 不在 CommonExtension 上，需透過具體型別存取
    // debug/release 快捷語法已移除，改用 named("debug")/named("release")
    when (extensionType) {
        ExtensionType.APPLICATION -> (commonExtension as ApplicationExtension).buildTypes {
            named("debug") { }
            named("release") {
                isMinifyEnabled = true
                proguardFiles(
                    commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        ExtensionType.LIBRARY -> (commonExtension as LibraryExtension).buildTypes {
            named("debug") { }
            named("release") {
                isMinifyEnabled = true
                proguardFiles(
                    commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}