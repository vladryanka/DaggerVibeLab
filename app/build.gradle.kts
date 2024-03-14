
plugins {
    id ("kotlin-kapt")
    id ("kotlin-android")
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}


android {
    namespace = "com.example.services"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.services"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    kapt ("com.google.dagger:dagger-compiler:2.50")
//    implementation ("com.google.dagger:dagger:2.50")
//
//    implementation ("com.google.dagger:dagger-android:2.x")
//    implementation ("com.google.dagger:dagger-android-support:2.x")
//    kapt ("com.google.dagger:dagger-android-processor:2.x")

//    val daggerVer = 2.27
//    implementation("com.google.dagger:dagger:$daggerVer")
//    implementation("com.google.dagger:dagger-android-support:$daggerVer")
//    kapt("com.google.dagger:dagger-android-processor:$daggerVer")
//    kapt("com.google.dagger:dagger-compiler:$daggerVer")

    implementation ("com.google.dagger:dagger:2.24")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.24")
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.24")
    implementation ("com.google.dagger:dagger-android-support:2.24'")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.work.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation ("com.google.code.gson:gson:2.10.1")
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}