plugins {
    alias(libs.plugins.mai.android.library)
}

android {
    namespace = "mai.project.compose.domain"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
}