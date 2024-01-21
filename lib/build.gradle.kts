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
	// apache pdfbox for low level pdf rendering
	implementation(libs.apache.pdfbox)

	// Use Kotlin's JUnit 5 integration
	testImplementation(libs.kotlin.test.junit5)

	// Mockk dependency (not defined in libs.versions.toml, so using direct coordinates)
	testImplementation(libs.mockk)

	// JUnit Jupiter API and Engine
	testImplementation(libs.junit.jupiter.api)
	testRuntimeOnly(libs.junit.jupiter.engine)

	// AssertJ
	testImplementation(libs.assertj.core)

	// JUnit Platform Launcher (not defined in libs.versions.toml)
	testRuntimeOnly(libs.junit.platform.launcher)

}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}