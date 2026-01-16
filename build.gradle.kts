import de.itemis.mps.gradle.tasks.MpsCheck

plugins {
    id("com.specificlanguages.mps") version "2.0.1"
    id("de.itemis.mps.gradle.common") version "1.29.3.1.19b70ba"
}

repositories {
    maven("https://artifacts.itemis.cloud/repository/maven-mps")
    mavenCentral()
}

dependencies {
    api("org.mpsqa:all-in-one:2025.1.1232.67d7738")
    api("org.iets3:opensource:2025.1.9673.2c543e3")

    mps("com.jetbrains:mps:2025.1.2")
    jbr("com.jetbrains.jdk:jbr_jcef:21.0.8-b1138.52")

    modelcheckBackend("de.itemis.mps.build-backends:modelcheck:1.24.3.167.c51149b")
}

tasks.register<MpsCheck>("checkModels") {
    projectLocation = projectDir

    mpsHome = mpsDefaults.mpsHome

    javaLauncher = jbrToolchain.javaLauncher
    pluginRoots.add(mpsDefaults.mpsLibrariesDirectory)
}
