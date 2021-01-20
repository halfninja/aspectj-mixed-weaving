import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("io.freefair.aspectj.post-compile-weaving") version "5.3.0"
    application
}

group = "uk.co.halfninja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object Versions {
    val spring = "5.3.2"
}

dependencies {
    implementation("org.springframework:spring-context:${Versions.spring}")
    implementation("org.springframework:spring-tx:${Versions.spring}")
    implementation("org.springframework:spring-beans:${Versions.spring}")
    aspect("org.springframework:spring-aspects:${Versions.spring}")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}
