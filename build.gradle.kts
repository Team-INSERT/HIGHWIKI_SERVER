@file:Suppress("DEPRECATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	jacoco
}

group = "wiki.hi"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	finalizedBy("jacocoTestReport")
}

jacoco {
	// JaCoCo 버전
	toolVersion = "0.8.10"
}

tasks.jacocoTestReport {
	reports {
		// 원하는 리포트를 켜고 끌 수 있다.
		html.isEnabled = true
		xml.isEnabled = false
		csv.isEnabled = false
	}

	finalizedBy("jacocoTestCoverageVerification")
}

tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				// INSTRUCTION은 최소 100%를 만족해야 한다.
				minimum = "1.00".toBigDecimal()
			}
		}

		rule {
			// 룰을 간단히 켜고 끌 수 있다.
			enabled = true

			// 룰을 체크할 단위는 클래스 단위
			element = "CLASS"

			// 브랜치 커버리지를 최소한 100% 만족시켜야 한다.
			limit {
				counter = "BRANCH"
				value = "COVEREDRATIO"
				minimum = "1.00".toBigDecimal()
			}

			// 라인 커버리지를 최소한 100% 만족시켜야 한다.
			limit {
				counter = "LINE"
				value = "COVEREDRATIO"
				minimum = "1.00".toBigDecimal()
			}

			// 빈 줄을 제외한 코드의 라인수를 최대 200라인으로 제한한다.
			limit {
				counter = "LINE"
				value = "TOTALCOUNT"
				maximum = "200".toBigDecimal()
			}

			// 커버리지 체크를 제외할 클래스들
			excludes = listOf(
//                    "*.test.*",
//                    "*.Kotlin*"
			)
		}
	}
}

val testCoverage by tasks.registering {
	group = "verification"
	description = "Runs the unit tests with coverage"

	dependsOn(":test",
		":jacocoTestReport",
		":jacocoTestCoverageVerification")

	tasks["jacocoTestReport"].mustRunAfter(tasks["test"])
	tasks["jacocoTestCoverageVerification"].mustRunAfter(tasks["jacocoTestReport"])
}
