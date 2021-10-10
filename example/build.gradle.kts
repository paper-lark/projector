plugins {
    id("common-conventions")
}

dependencies {
    implementation(project(":lib"))
    implementation(kotlin("script-runtime"))
}
