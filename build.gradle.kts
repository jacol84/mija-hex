import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.72" apply false
    jacoco

    kotlin("plugin.spring") version "1.3.72" apply false
    id("org.springframework.boot") version "2.3.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("groovy")
        plugin("jacoco")
    }
    version = "0.8.0-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }


    dependencies {
        implementation("org.slf4j:slf4j-api:1.7.30")

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

        testImplementation("org.spockframework:spock-core:1.3-groovy-2.5") {
            exclude(module = "groovy-all")
        }

    }
//    tasks.withType<Test> {
//        useJUnitPlatform()
//    }
}



