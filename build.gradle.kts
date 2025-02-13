plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "edu.bsu.cs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.1")

    // https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20250107")


    implementation("org.slf4j:slf4j-nop:2.0.11")
}

tasks.test {
    useJUnitPlatform()
}
javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}
application {
    mainClass.set("bsuCS.GraphicalUserInterface")
}