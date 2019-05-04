plugins {
    id(GradlePlugins.android)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
    kotlin(GradlePlugins.kotlinExt)
}

android {
    compileSdkVersion(Android.targetSdk)
    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)

            isCrunchPngs = false
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFiles(BuildType.proguardDebug)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    productFlavors {
        create(ProductFlavors.develop) {
            buildConfigField("String", "BASE_URL", "\"${Api.BASE_URL_TEST}\"")
            matchingFallbacks = listOf("debug")
        }

        create(ProductFlavors.production) {
            buildConfigField("String", "BASE_URL", "\"${Api.BASE_URL_RELEASE}\"")
            matchingFallbacks = listOf("release")
        }
    }

    flavorDimensions("tier")
}

dependencies {
    // ktx core
    implementation(Libs.ktx)
    implementation(Libs.stdLib)

    // support
    implementation(Libs.supportAppCompat)
    implementation(Libs.supportAnnotations)
    implementation(Libs.supportCardview)
    implementation(Libs.supportDesign)
    implementation(Libs.supportRecyclerview)
    implementation(Libs.supportV4)

    // lifecycle
    kapt(Libs.lifecycleCompiler)
    implementation(Libs.lifecycleExtensions)
    implementation(Libs.lifecycleJava8)
    implementation(Libs.lifecycleRuntime)

    // Constraint Layout
    implementation(Libs.constraintlayout)

    // Navigation
    implementation(Libs.navigationRuntimeKtx)
    implementation(Libs.navigationFragmentKtx)
//    implementation(Libs.navigationUiKtx)
//    implementation(Libs.navigationUi)

    // Glide
    kapt(Libs.glideCompiler)
    implementation(Libs.glideRuntime)

    // Retrofit
    implementation(Libs.retrofitRuntime)
    implementation(Libs.retrofitGson)
    implementation(Libs.retrofitAdapter)
    implementation(Libs.okLogging)

    // Room database
    implementation(Libs.roomRuntime)
    implementation(Libs.roomRxjava2)

    kapt(Libs.roomCompiler)
    kapt(Libs.lifecycleCompiler)

    // Rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    // Binding
    kapt(Libs.bindingCompiler)

    // Koin
    implementation(Libs.koinCore)
    implementation(Libs.koinJava)
    implementation(Libs.koinViewModel)

    // Permission
    implementation(Libs.permission)

    // Dependencies for local unit tests
    testImplementation(Libs.junit)
    testImplementation(Libs.mockitoAll)
    testImplementation(Libs.hamcrest)
    testImplementation(Libs.archTesting)
    testImplementation(Libs.stdLib)
    testImplementation(Libs.kotlinTest)

    // Android Testing Support Library's runner and rules

    androidTestImplementation(Libs.atslRunner)
    androidTestImplementation(Libs.atslRules)
    androidTestImplementation(Libs.roomTesting)
    androidTestImplementation(Libs.archTesting)

    // Dependencies for Android unit tests
    androidTestImplementation(Libs.junit)
    androidTestImplementation(Libs.mockitoCore) {
        exclude(group = "net.bytebuddy")
    }

    // Espresso UI Testing
    androidTestImplementation(Libs.espressoCore)
    androidTestImplementation(Libs.espressoContrib)
    androidTestImplementation(Libs.espressoIntents)

    // Resolve conflicts between main and test APK
    androidTestImplementation(Libs.supportAnnotations)
    androidTestImplementation(Libs.supportV4)
    androidTestImplementation(Libs.supportAppCompat)
    androidTestImplementation(Libs.supportDesign)

    // support testing
    testImplementation(Libs.mockitoWebServer)
    testImplementation(Libs.robolectric)
}