plugins {
    alias(libs.plugins.mai.android.library.compose)
}

android {
    namespace = "mai.project.compose.presentation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(libs.glide)
    implementation(libs.bundles.coil)
}