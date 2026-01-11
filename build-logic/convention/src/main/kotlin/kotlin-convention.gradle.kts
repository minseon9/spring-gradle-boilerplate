plugins {
    id("detekt-convention")
    id("ktlint-convention")

    id("org.jetbrains.kotlin.jvm")

    // Classes annotated with @Configuration, @Controller, @RestController, @Service or @Repository are automatically opened
    // https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support
    id("org.jetbrains.kotlin.plugin.spring")

    // The plugin specifies @Entity, @Embeddable, and @MappedSuperclass no-arg annotations automatically.
    // https://kotlinlang.org/docs/no-arg-plugin.html#jpa-support
    id("org.jetbrains.kotlin.plugin.jpa")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
kotlin {
    jvmToolchain {
        languageVersion.set(
            JavaLanguageVersion.of(libs.findVersion("jdk").get().toString()),
        )
    }
    compilerOptions {
        // https://kotlinlang.org/docs/java-interop.html#jsr-305-support
        freeCompilerArgs.addAll("-Xjsr305=strict")
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}
