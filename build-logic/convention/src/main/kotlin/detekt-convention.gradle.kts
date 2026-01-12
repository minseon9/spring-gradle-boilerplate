plugins {
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config.setFrom("$rootDir/detekt.yml")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    reports {
        xml.required.set(false)
        html.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
    }
    jvmTarget = libs.findVersion("jdk").get().toString()
}

tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask> {
    jvmTarget = libs.findVersion("jdk").get().toString()
}
