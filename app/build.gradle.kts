val kotlinVersion: String by project

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.tatsuro.app.bottomsheetdialogfragmentsample"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true

            // 同一端末内でデバッグビルドとリリースビルドを共存させるため、
            // デバッグビルドのパッケージ名にsuffixを付与する。
            applicationIdSuffix = ".debug"

            // アプリのバージョン名からデバッグビルドであることがわかるようにする。
            versionNameSuffix = "debug"
        }

        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro")
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
        viewBinding = true
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.fragment:fragment-ktx:1.3.5")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1")

    implementation("com.google.android.material:material:1.3.0")

    // Flipper
    debugImplementation("com.facebook.flipper:flipper:0.96.1")
    debugImplementation("com.facebook.soloader:soloader:0.10.1")
    releaseImplementation("com.facebook.flipper:flipper-noop:0.96.1")

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
