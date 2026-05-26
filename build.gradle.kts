import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
}

dependencies {
    testImplementation(libs.junit)

    intellijPlatform {
        intellijIdea("261-EAP-SNAPSHOT") {
            useInstaller = false
        }
        testFramework(TestFrameworkType.Platform)
    }
}
