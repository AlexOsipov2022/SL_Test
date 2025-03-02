plugins {
    kotlin("jvm") version "2.1.10"
}

group = "OSA"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.codeborne:selenide:7.7.3")

    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.5")

//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.0")
//    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.12.0")
//    testImplementation("org.junit.jupiter:junit-jupiter-params:5.12.0")
//    testImplementation("junit:junit:4.13.2")
//    testImplementation("io.rest-assured:rest-assured:5.5.1")
//    implementation("org.slf4j:slf4j-api:2.0.15")
//    implementation("org.junit:junit-bom:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}