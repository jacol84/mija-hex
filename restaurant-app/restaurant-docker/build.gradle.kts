plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":restaurant-app:restaurant-infrastructure"))
}

springBoot {
    mainClassName = "mija.hex.infrastructure.app.restaurant.RestaurantAppKt"
}

tasks{
    jar{
        enabled = false
    }
    bootJar {
        enabled = true
    }
    bootBuildImage {
        enabled = true
    }
    // kotlin
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}