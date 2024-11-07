plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

val mCompileSdk = libs.versions.compileSdk.get().toInt()
val mMinSdk = libs.versions.minSdk.get().toInt()

android {
    namespace = "mai.project.compose.domain"
    compileSdk = mCompileSdk

    defaultConfig {
        minSdk = mMinSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.timber)

    implementation(platform(libs.koin.bom))
    implementation(libs.bundles.koin)
}