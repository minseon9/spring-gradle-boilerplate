plugins {
    id("spring-boot-convention")
    id("testing-convention")
}

dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.actuator)

    developmentOnly(libs.spring.boot.devtools)

    testImplementation(libs.spring.boot.starter.test)
}

tasks.bootJar {
    enabled = true
}
