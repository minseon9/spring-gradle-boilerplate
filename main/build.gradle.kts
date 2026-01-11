plugins {
    id("kotlin-convention")
    id("spring-boot-convention")
    id("testing-convention")
}

dependencies {
    implementation(libs.bundles.spring.boot.core)
    testImplementation(libs.bundles.testing)
}

tasks.bootJar {
    enabled = true
}
