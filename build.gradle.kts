plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.3.21"
    id("com.google.devtools.ksp") version "2.3.7"
    id("io.micronaut.application") version "5.0.2"
    id("com.gradleup.shadow") version "9.4.1"
    id("io.micronaut.aot") version "5.0.2"
}

group = "no.nav.hm.imb.request.api"


val kotlinVersion=project.property("kotlinVersion")
val jsonSchemaValidatorVersion=project.property("json-schema-validatorVersion")
val jakartaPersistenceVersion = project.property("jakartaPersistenceVersion")
val postgresqlVersion = project.property("postgresqlVersion")
val flywayPostgresqlVersion = project.property("flywayPostgresqlVersion")
val logbackEncoderVersion = project.property("logbackEncoderVersion")

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.yaml:snakeyaml")
    implementation("net.logstash.logback:logstash-logback-encoder:${logbackEncoderVersion}")
    implementation("com.networknt:json-schema-validator:$jsonSchemaValidatorVersion")
    ksp("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    ksp("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.data:micronaut-data-jdbc")
    implementation("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("org.postgresql:postgresql:${postgresqlVersion}")
    implementation("io.micronaut.flyway:micronaut-flyway")
    testImplementation("org.testcontainers:testcontainers-postgresql")
    implementation("org.flywaydb:flyway-database-postgresql:${flywayPostgresqlVersion}")

    // OpenApi
    ksp("io.micronaut.openapi:micronaut-openapi")
    implementation("io.swagger.core.v3:swagger-annotations")
    ksp("io.micronaut.openapi:micronaut-openapi-annotations")

    // security
    implementation("io.micronaut.security:micronaut-security-jwt")
    ksp("io.micronaut.security:micronaut-security-annotations")

}



application {
    mainClass = "no.nav.hm.imb.request.api.Application"
}

java {
    sourceCompatibility = JavaVersion.toVersion("25")
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("no.nav.hm.imb.request.api.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        convertYamlToJava = false
        precomputeOperations = false
        cacheEnvironment = false
        optimizeClassLoading = true
        deduceEnvironment = false
        optimizeNetty = true
        replaceLogbackXml = true
    }

}

// https://docs.gradle.org/current/userguide/upgrading_major_version_9.html#test_task_fails_when_no_tests_are_discovered
tasks.withType<AbstractTestTask>().configureEach {
    failOnNoDiscoveredTests = false
}




