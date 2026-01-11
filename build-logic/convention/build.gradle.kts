plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.spring.boot.plugin)
    implementation(libs.spring.dependency.management.plugin)

    implementation(libs.kotlin.jvm.plugin)
    implementation(libs.kotlin.allopen)
    implementation(libs.kotlin.noarg)

    implementation(libs.ktlint.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.detekt.formatting)
}
