plugins {
    java
    idea
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}

group = "ru.antonkuzvalid"

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    implementation("edu.princeton.cs:algs4")
}