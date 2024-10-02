plugins {
	java
	id("org.springframework.boot") version "3.4.0-M3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "org.venuspj"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

extra["webjarsFontawesomeVersion"] =  "4.7.0"
extra["webjarsBootstrapVersion"] =  "5.2.3"
extra["htmxSpringBootThymeleafVersion"] =  "3.5.1"
extra["htmxOrgVersion"] =  "2.0.2"
extra["assertjVersion"] =  "3.26.3"
// 他のバージョンもここに追加

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")
	implementation("org.springframework:spring-jdbc")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.postgresql:r2dbc-postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.assertj:assertj-core:${property("assertjVersion")}")
	implementation ("io.github.wimdeblauwe:htmx-spring-boot-thymeleaf:${property("htmxSpringBootThymeleafVersion")}")
	runtimeOnly ("org.webjars.npm:bootstrap:${property("webjarsBootstrapVersion")}")
	runtimeOnly ("org.webjars.npm:font-awesome:${property("webjarsFontawesomeVersion")}")
	runtimeOnly ("org.webjars.npm:htmx.org:${property("htmxOrgVersion")}")
	runtimeOnly ("com.github.ben-manes.caffeine:caffeine")
	runtimeOnly ("com.h2database:h2")
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		events("passed", "failed", "skipped")
	}
}
