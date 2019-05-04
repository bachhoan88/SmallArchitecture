object Versions {
    val kotlin = "1.3.31"
    val androidPlugin = "3.4.0"

    val androidxCore = "2.0.0-rc01"
    val archCore = "2.0.0-beta01"
    val room = "2.1.0-alpha06"
    val lifecycle = "2.0.0-beta01"
    val support = "1.0.0-rc02"

    val glide = "4.8.0"

    val koin = "1.3.20"

    val junit = "4.12"
    val espresso = "3.1.1"
    val mockito = "2.25.0"
    val mockitoAll = "1.10.19"
    val hamcrest = "1.3"
    val atslRunner = "1.1.0-alpha1"
    val atslRules = "1.1.0-alpha1"
    val mockWebserver = "3.8.1"
    val robolectric = "3.4.2"

    val retrofit = "2.3.0"
    val okLogging = "3.9.0"

    val constraintLaout = "2.0.0-alpha2"

    val rxJava = "2.2.2"
    val rxAndroid = "2.1.0"

    val timber = "4.5.1"

    val easyPermission = "3.0.1"
    val navigation = "2.1.0-alpha01"
    val dexmaker = "2.2.0"

    /**
    versions.multi_dex = '1.0.3'
    versions.dagger = "2.16"
    versions.apache_commons = "2.5"
    versions.dexmaker = "2.2.0"
    versions.paging = "1.0.0"
    versions.work = "1.0.0-alpha02"
    versions.navigation = "1.0.0-alpha01"
    versions.easy_permission = "1.3.1"
     */
}

object BuildPlugins {
    val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
}

object Android {
    val minSdk = 19
    val targetSdk = 28
    val applicationId = "com.example.mvvm"
    val versionCode = 1
    val versionName = "1.0.1"
}

object GradlePlugins {
    val android = "com.android.application"
    val kotlin = "kotlin"
    val kotlinAndroid = "android"
    val kotlinExt = "android.extensions"
    val kotlinApt = "kapt"
    val javaLib = "java-library"
    val androidLib = "com.android.library"
    val navigationSafe = "androidx.navigation.safeargs"

}

object Modules {
    val domain = ":domain"
    val data = ":data"
}

object AndroidJUnit {
    val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildType {
    val debug = "debug"
    val release = "release"

    val minifyRelease = true
    val proguardRelease = "proguard-rules.pro"

    val minifyDebug = false
    val proguardDebug = "proguard-rules.pro"
}

object ProductFlavors {
    val develop = "develop"
    val production = "production"
}

object Types {
    val string = "String"
    val integer = "Integer"
}

object Api {
    val BASE_URL_TEST = "https://api.github.com/"
    val BASE_URL_RELEASE = "https://api.github.com/"
}

object Libs {
    //KTX
    val ktx = "androidx.core:core-ktx:${Versions.androidxCore}"
    val archTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Support libs
    val supportAnnotations = "androidx.annotation:annotation:${Versions.support}"
    val supportAppCompat = "androidx.appcompat:appcompat:${Versions.support}"
    val supportRecyclerview = "androidx.recyclerview:recyclerview:${Versions.support}"
    val supportCardview = "androidx.cardview:cardview:${Versions.support}"
    val supportDesign = "com.google.android.material:material:${Versions.support}"
    val supportV4 = "androidx.legacy:legacy-support-v4:${Versions.support}"

    // Constraint Layout
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLaout}"

    // databinding compiler
    val bindingCompiler = "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"

    // room database
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    val roomTesting = "androidx.room:room-testing:${Versions.room}"

    // lifecycle
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    // Navigation
    val navigationRuntime = "android.arch.navigation:navigation-runtime:${Versions.navigation}"
    val navigationRuntimeKtx = "android.arch.navigation:navigation-runtime-ktx:${Versions.navigation}"
    val navigationFragment = "android.arch.navigation:navigation-fragment:${Versions.navigation}"
    val navigationFragmentKtx = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUiKtx = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigationUi = "android.arch.navigation:navigation-ui:${Versions.navigation}"
    val navigationSafeArgsPlugin = "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    // RxKotlin & RxJava
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    // retrofit
    val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"

    // Glide for image loader
    val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Permission for AndroidX
    val permission = "pub.devrel:easypermissions:${Versions.easyPermission}"

    // Timber for logging
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // JUnit for testing
    val junit = "junit:junit:${Versions.junit}"

    // KTX testing
    val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinAllopen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"

    // Ruler & Runner testing
    val atslRunner = "androidx.test:runner:$${Versions.atslRunner}"
    val atslRules = "androidx.test:rules:${Versions.atslRules}"

    // espresso for testing
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"

    // robolectric for testing
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    // Mockito for testing
    val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoAll = "org.mockito:mockito-all:${Versions.mockitoAll}"
    val mockitoWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserver}"

    // Hamcrest for testing
    val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"

    // KOIN
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koinJava = "org.koin:koin-java:${Versions.koin}"

    val koinTest = "org.koin:koin-test:${Versions.koin}"

    // support test
    val androidNavigationTesting = "android.arch.navigation:navigation-testing-ktx:${Versions.navigation}"

    val dexmaker = "com.linkedin.dexmaker:dexmaker-mockito:${Versions.dexmaker}"
}