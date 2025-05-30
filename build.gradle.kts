plugins {
    kotlin("jvm") version "2.1.20"
    `maven-publish`
}

group = "funny.catlean"
version = "1.0"

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
        create<MavenPublication>("gpr") {
            from(components["java"])
            artifactId = "gofra"

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
        maven("https://maven.pkg.github.com/06ED/Gofra") {
            name = "GitHubPackages"
            credentials {
                username = project.findProperty("systemProp.gpr.user") as String?
                password = project.findProperty("systemProp.gpr.token") as String?
            }
        }
    }
}
