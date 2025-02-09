plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}
repositories {
    mavenCentral()
}
group = "org.venuspj"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

extra["webjarsFontawesomeVersion"] = "4.7.0"
extra["webjarsBootstrapVersion"] = "5.2.3"
extra["htmxOrgVersion"] = "2.0.2"
extra["assertjVersion"] = "3.26.3"
extra["guavaVersion"] = "33.3.1-jre"
// 他のバージョンもここに追加

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:${property("assertjVersion")}")
    runtimeOnly("com.github.ben-manes.caffeine:caffeine")
    runtimeOnly("com.h2database:h2")
    // https://mvnrepository.com/artifact/com.google.guava/guava
    implementation("com.google.guava:guava:${property("guavaVersion")}")

}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped")
    }
}
