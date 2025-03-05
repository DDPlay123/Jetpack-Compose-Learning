package mai.project.compose.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * 設定 Application/Library Module 的 Compose 內容
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

        dependencies {
            "implementation"(libs.findLibrary("androidx.core.ktx").get())
            "implementation"(libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
            "implementation"(libs.findLibrary("androidx.activity.compose").get())

            val composeBom = libs.findLibrary("androidx.compose.bom").get()
            "implementation"(platform(composeBom))
            "implementation"(libs.findLibrary("androidx.ui").get())
            "implementation"(libs.findLibrary("androidx.ui.graphics").get())
            "implementation"(libs.findLibrary("androidx.ui.tooling.preview").get())
            "implementation"(libs.findLibrary("androidx.material3").get())
            "implementation"(libs.findLibrary("androidx.navigation.runtime.ktx").get())
            "implementation"(libs.findLibrary("androidx.navigation.compose").get())

            "testImplementation"(libs.findLibrary("junit").get())
            "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
            "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
            "androidTestImplementation"(platform(composeBom))
            "androidTestImplementation"(libs.findLibrary("androidx.ui.test.junit4").get())
            "debugImplementation"(libs.findLibrary("androidx.ui.tooling").get())
            "debugImplementation"(libs.findLibrary("androidx.ui.test.manifest").get())
        }
    }
}