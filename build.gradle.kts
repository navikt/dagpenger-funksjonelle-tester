plugins {
    id("application")
    kotlin("jvm") version "1.3.10"
    id("com.diffplug.gradle.spotless") version "3.13.0"
    id("com.palantir.docker") version "0.20.1"
    id("com.palantir.git-version") version "0.11.0"
}

apply {
    plugin("com.diffplug.gradle.spotless")
}

repositories {
    mavenCentral()
    maven("http://packages.confluent.io/maven/")
}

val gitVersion: groovy.lang.Closure<Any> by extra
version = gitVersion()
group = "no.nav.dagpenger"

application {
    applicationName = "dagpenger-funksjonelle-tester"
    mainClassName = "no.nav.dagpenger.features.Features"
}

docker {
    name = "repo.adeo.no:5443/navikt/${application.applicationName}"
    buildArgs(
        mapOf(
            "APP_NAME" to application.applicationName,
            "DIST_TAR" to "${application.applicationName}-${project.version}"
        )
    )
    files(tasks.findByName("distTar")?.outputs)
    pull(true)
    tags(project.version.toString())
}

val cucumberVersion = "4.0.0"

dependencies {
    implementation(kotlin("stdlib"))

    testCompile("io.cucumber:cucumber-java8:$cucumberVersion")
    testCompile("io.cucumber:cucumber-junit:$cucumberVersion")
}

spotless {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        target("*.gradle.kts", "additionalScripts/*.gradle.kts")
        ktlint()
    }
}
