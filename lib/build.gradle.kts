plugins {
	// Apply the Kotlin JVM plugin
	alias(libs.plugins.jvm)
	// Apply the java-library plugin
	`java-library`
}

repositories {
	mavenCentral()
}

dependencies {
	// Use Kotlin's JUnit 5 integration
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

	// Mockk dependency (not defined in libs.versions.toml, so using direct coordinates)
	testImplementation("io.mockk:mockk:1.9.3")

	// JUnit Jupiter API and Engine
	testImplementation(libs.junit.jupiter.api)
	testRuntimeOnly(libs.junit.jupiter.engine)

	// AssertJ
	testImplementation(libs.assertj.core)

	// JUnit Platform Launcher (not defined in libs.versions.toml)
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}