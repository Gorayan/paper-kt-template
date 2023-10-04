rootProject.name = "template-plugin"

plugins {

    // Javaツールチェーン自動設定
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.5.0")

}

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        mavenCentral()

        // Paper
        maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
        maven { url = uri("https://oss.sonatype.org/content/groups/public/") }

    }

}