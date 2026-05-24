plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mapapp11"
    // Correction ici : syntaxe simplifiée
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mapapp11"
        minSdk = 24
        // Correction ici : 35 est plus stable que 36 pour l'instant
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Google Maps & Location
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    implementation("org.osmdroid:osmdroid-android:6.1.18")
}