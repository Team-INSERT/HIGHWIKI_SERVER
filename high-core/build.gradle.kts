plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

dependencies {

    // transaction
    implementation(Dependencies.SPRING_TRANSACTION)

    // aop
    implementation(Dependencies.AOP)
}
