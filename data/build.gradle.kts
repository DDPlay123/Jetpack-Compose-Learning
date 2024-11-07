plugins {
    alias(libs.plugins.mai.android.library)
}

android {
    namespace = "mai.project.compose.data"
}

dependencies {
    implementation(project(":core"))

    implementation(libs.datastore.preferences)
}