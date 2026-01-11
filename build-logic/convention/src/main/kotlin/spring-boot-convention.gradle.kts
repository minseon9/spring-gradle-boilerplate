plugins {
    id("java-convention")

    // Allows to package executable jar or war archives, run Spring Boot applications, and use the dependency management
    // https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/
    id("org.springframework.boot")

    // This plugin enables the spring dependency management
    id("io.spring.dependency-management")
}

dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = false
}
