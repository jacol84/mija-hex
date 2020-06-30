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

val rootBuildDir = buildDir

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
            executionData(file("$rootBuildDir\\jacoco\\allTestCoverage.exec"))
            sourceSets(sourceSets.main.get())
            xml.isEnabled = true
        }
        onlyIf{
            file("$buildDir/jacoco/test.exec").exists().also { logger.error("$buildDir/jacoco/test.exec ->$it") }
        }
    }
}

tasks.register<JacocoMerge>("jacocoMergeTest") {
    destinationFile = file("$buildDir/jacoco/allTestCoverage.exec")
    subprojects.map { file("${it.buildDir}/jacoco/test.exec") }.filter {
        logger.error(it.name)
        it.exists()
    }.forEach { executionData(it) }
}

sonarqube {
    properties {
        property("sonar.projectKey", "jacol84_mija-hex")
        property("sonar.organization", "jacol84jacol84")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", System.getenv()?.get("SONAR_CLOUD_TOKEN")?:"")
        property("sonar.coverage.jacoco.xmlReportPaths","**/build/reports/jacoco/test/jacocoTestReport.xml")
        property("sonar.jacoco.reportPaths","**/build/jacoco/test.exec")
    }
}


