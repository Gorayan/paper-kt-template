plugins {

    alias(libs.plugins.kotlin.jvm)

}

group = findProperty("plugin.group")?: "your.group"
version = findProperty("plugin.version")?: "undefined"

val pluginName = (findProperty("plugin.name")?: project.name) as String
val pluginVersion = version as String

dependencies {

    implementation(libs.paper.api)

}

tasks {

    withType<Jar> {

        archiveBaseName.set(pluginName)
        archiveVersion.set(pluginVersion)

    }

    @Suppress("UnstableApiUsage")
    withType<ProcessResources> {

        val props = mapOf(
            "name" to pluginName,
            "version" to pluginVersion,
            "main" to "your.group.templateplugin.TemplatePlugin",
            "apiVersion" to "1.20",
            "kotlinVersion" to libs.versions.kotlin.get(),
        )

        inputs.properties(props)
        filteringCharset = Charsets.UTF_8.toString()
        filesMatching("plugin.yml") { expand(props) }

    }

}
