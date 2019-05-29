plugins {
    java
    idea
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

group = "ru.antonkuzvalid"

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
}