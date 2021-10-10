plugins {
    id("common-conventions")
    application
}

application {
    mainClass.set("MainKt")
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("script-runtime"))
    implementation(kotlin("script-util"))
    implementation(kotlin("compiler-embeddable"))
    implementation(kotlin("scripting-compiler-embeddable"))
    implementation(kotlin("script-util"))
    implementation("net.java.dev.jna:jna:4.2.2")

    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}
