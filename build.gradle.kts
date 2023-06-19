import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	`maven-publish`
	signing
}

group = "io.bityagi.blockchain.utils"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.web3j:core:4.8.7")// for Ethereum
	implementation("org.bitcoinj:bitcoinj-core:0.15.10") // for Bitcoin

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


publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])

			artifactId = "blockchain-swissknife" // replace with your artifact ID

			pom {
				name.set("Blockchain Swissknife")
				description.set("A blockchain library")
				url.set("https://github.com/username/blockchain-swissknife") // replace with your project's URL
				licenses {
					license {
						name.set("The Apache License, Version 2.0")
						url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
					}
				}
				developers {
					developer {
						id.set("maintainer")
						name.set("Project Maintainer")
						email.set("maintainer@blockchain-swissknife.org") // replace with a project-specific email if available
					}
				}
				scm {
					connection.set("scm:git:git://github.com/bityagi/blockchain-swissknife.git")
					developerConnection.set("scm:git:ssh://github.com:bityagi/blockchain-swissknife.git")
					url.set("https://github.com/bityagi/blockchain-swissknife/tree/master")
				}
			}
		}
	}

	repositories {
		maven {
			name = "sonatype"
			url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
			credentials {
				username = findProperty("ossrhUsername") as String? ?: System.getenv("OSSRH_USERNAME")
				password = findProperty("ossrhPassword") as String? ?: System.getenv("OSSRH_PASSWORD")
			}
		}
	}
}

signing {
	sign(publishing.publications)
}