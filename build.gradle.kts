plugins {
    application
    kotlin("jvm") version Kotlin.version
    id(Spotless.spotless) version Spotless.version
    id(Shadow.shadow) version Shadow.version
    id("com.palantir.git-version") version "0.11.0"
}

buildscript {
    repositories {
        mavenCentral()
    }
}

apply {
    plugin(Spotless.spotless)
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

val gitVersion: groovy.lang.Closure<Any> by extra
version = gitVersion()
group = "no.nav.dagpenger"

application {
    applicationName = "dagpenger-funksjonelle-tester"
    mainClass.set("no.nav.dagpenger.cucumber.RunCucumberKt")
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(Cucumber.java8)
    implementation(Cucumber.junit)

    implementation(Fuel.fuel) {
        exclude(group = "org.jetbrains.kotlin")
    }
    implementation(Fuel.fuelMoshi)

    implementation(Junit5.api)

    implementation(Konfig.konfig)

    implementation(Moshi.moshi)
    implementation(Moshi.moshiKotlin) {
        exclude(group = "org.jetbrains.kotlin")
    }
    implementation(Moshi.moshiAdapters)

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:${Kotlin.version}")
}

spotless {
    kotlin {
        ktlint(Ktlint.version)
    }
    kotlinGradle {
        target("*.gradle.kts", "buildSrc/**/*.kt*")
        ktlint(Ktlint.version)
    }
}
