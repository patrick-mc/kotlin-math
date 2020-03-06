plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.70"
    id("org.jetbrains.dokka") version "0.10.0"
    `maven-publish`
    signing
}

group = "com.github.patrick-mc"
version = "1.0"

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://dl.bintray.com/kotlin/dokka")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    val dokka by getting(org.jetbrains.dokka.gradle.DokkaTask::class) {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/dokka"

        configuration {
            includeNonPublic = true
            jdkVersion = 8
        }
    }

    create<Jar>("dokkaJar") {
        archiveClassifier.set("javadoc")
        from(dokka)
        dependsOn(dokka)
    }

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("math") {
            from(components["java"])

            artifact(tasks["sourcesJar"])
            artifact(tasks["dokkaJar"])

            repositories {
                maven {
                    credentials {
                        username = project.property("mavenUsername").toString()
                        password = project.property("mavenPassword").toString()
                    }
                    val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                    val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
                    url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                }
            }

            pom {
                name.set("kotlin-math")
                description.set("Math Library with Vector Support for Kotlin")
                url.set("https://github.com/patrick-mc/kotlin-math")

                licenses {
                    license {
                        name.set("GNU General Public License v2.0")
                        url.set("https://opensource.org/licenses/gpl-2.0.php")
                    }
                }

                developers {
                    developer {
                        id.set("patrick-mc")
                        name.set("PatrickKR")
                        email.set("mailpatrickkorea@gmail.com")
                        url.set("https://github.com/patrick-mc")
                        roles.addAll("developer")
                        timezone.set("Asia/Seoul")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/patrick-mc/kotlin-math.git")
                    developerConnection.set("scm:git:ssh://github.com:patrick-mc/kotlin-math.git")
                    url.set("https://github.com/patrick-mc/kotlin-math")
                }
            }
        }
    }
}

signing {
    isRequired = true
    sign(tasks["sourcesJar"], tasks["dokkaJar"])
    sign(publishing.publications["math"])
}