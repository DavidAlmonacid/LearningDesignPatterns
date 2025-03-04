plugins {
    kotlin("jvm") version "2.1.10"
}

group = "dev.designpatterns"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Logger
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.4")
    runtimeOnly("ch.qos.logback:logback-classic:1.5.17")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}