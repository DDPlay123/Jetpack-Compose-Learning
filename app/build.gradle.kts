plugins {
    alias(libs.plugins.mai.android.application)
}

android {
    namespace = "mai.project.compose"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))
}