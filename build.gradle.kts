plugins {
    kotlin("jvm") version "2.1.20"
    `maven-publish`
}

group = "funny.catlean"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Gofra")
                description.set("Extremely fast, asynchronous event bus for kotlin")
                url.set("https://github.com/06ED/Gofra")
                licenses {
                    license {
                        name.set("GPLv3")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.html#license-text")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/yourusername/my-kotlin-lib")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USER")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
