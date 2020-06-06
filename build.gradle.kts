import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.72" apply false
    jacoco
}
// TODO - meyby onlu jdk 11 or 8
// java.sourceCompatibility = JavaVersion.VERSION_11




subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("groovy")
        plugin("jacoco")
    }
    version = "0.6.0-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }


    dependencies {
        // TODO sprawdzić ten loggger
        implementation("org.slf4j:slf4j-api:1.7.30")

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

        testImplementation("org.spockframework:spock-core:1.3-groovy-2.5") {
            exclude(module = "groovy-all")
        }
    }
}



