import com.android.builder.core.DefaultApiVersion

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion = "android-30"
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdkVersion = DefaultApiVersion(16)
        targetSdkVersion = DefaultApiVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles = mutableListOf(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                File("proguard-rules.pro")
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0")
    implementation("com.google.android.material:material:1.3.0")
}