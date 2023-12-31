plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

dependencies {
    // impl project
    implementation(project(":high-core"))
    runtimeOnly(project(":high-internal-api-server"))

    // web
    implementation(Dependencies.SPRING_WEB)

    // validation
    implementation(Dependencies.SPRING_VALIDATION)

    // transaction
    implementation(Dependencies.SPRING_TRANSACTION)

    // security
    implementation(Dependencies.SPRING_SECURITY)

    // jwt
    implementation(Dependencies.JWT)

    // configuration
    kapt(Dependencies.CONFIGURATION_PROCESSOR)

    // jackson
    implementation(Dependencies.JACKSON_TYPE)

    // aop
    implementation(Dependencies.AOP)

}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}