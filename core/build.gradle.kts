plugins {
    alias(libs.plugins.mai.android.library)
}

android {
    namespace = "mai.project.compose.core"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}