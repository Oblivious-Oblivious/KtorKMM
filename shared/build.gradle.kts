plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.21";
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val ktor_version = "2.3.2";
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("io.ktor:ktor-client-core:${ktor_version}");
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1");
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1");
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:${ktor_version}");
            }
        }

        val iosMain by getting {
            dependsOn(commonMain);
//            iosX64Main.dependsOn(this);
//            iosArm64Main.dependsOn(this);
//            iosSimulatorArm64Main.dependsOn(this);
            dependencies {
                implementation("io.ktor:ktor-client-darwin:${ktor_version}");
            }
        }
    }
}

android {
    namespace = "com.example.ktorkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}