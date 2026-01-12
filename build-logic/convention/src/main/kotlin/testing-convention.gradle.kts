plugins {
    id("java-convention")
    id("jacoco")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
dependencies {
   testImplementation(libs.findBundle("testing").get())
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<Test>("test") {
    finalizedBy("jacocoTestReport")
}

tasks.named<JacocoReport>("jacocoTestReport") {
    dependsOn("test")
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.named<JacocoCoverageVerification>("jacocoTestCoverageVerification") {
    dependsOn("jacocoTestReport")
    violationRules {
        rule {
            limit {
                minimum = "0.90".toBigDecimal()
            }
        }
    }
}
