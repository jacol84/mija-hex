plugins {
    java
    kotlin("jvm") version "1.3.72" apply false
    jacoco
    id("org.sonarqube") version "2.8"
    kotlin("plugin.spring") version "1.3.72" apply false
    id("org.springframework.boot") version "2.3.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
}
repositories {
    mavenCentral()
    jcenter()
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

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        testImplementation("org.spockframework:spock-core:1.3-groovy-2.5") {
            exclude(module = "groovy-all")
        }

    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
    tasks.jacocoTestReport {
        reports {
            xml.isEnabled = true
            csv.isEnabled = false
        }
    }
}

tasks.register<JacocoReport>("codeCoverageReport") {
    subprojects {
        //FIXME check project when hass esult
        if (this.project.name !in listOf("command-bus", "delivery-app", "food-order-app", "restaurant-app", "delivery-api", "food-order-api", "restaurant-api", "delivery-infrastructure", "food-order-infrastructure", "restaurant-infrastructure")) {
            val subProjectIt = this
            subProjectIt.plugins.withType<JacocoPlugin>().configureEach {
                subProjectIt.tasks.matching { it.extensions.findByType<JacocoTaskExtension>() != null }.configureEach {
                    val testTask = this
                    sourceSets(subProjectIt.sourceSets.main.get())
                    executionData(testTask)
                }
                subProjectIt.tasks.matching { it.extensions.findByType<JacocoTaskExtension>() != null }.forEach {
                    rootProject.tasks["codeCoverageReport"].dependsOn(it)
                }
            }
        }
    }

    reports {
        xml.isEnabled = true
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "jacol84_mija-hex")
        property("sonar.organization", "jacol84jacol84")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", "4f21315ee7d74305bd8b0454b461b4f536c9d644")
        property("sonar.junit.reportPaths", "**/test-results/test")
        property("sonar.coverage.jacoco.xmlReportPaths","**/build/reports/jacoco/test/jacocoTestReport.xml")
    }
}


