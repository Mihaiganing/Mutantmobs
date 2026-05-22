plugins {
    id 'java'
    id 'net.minecraftforge.gradle' version '[6.0,6.2)'
    id 'org.parchmentmc.librarian.forgegradle' version '1.+'
}

version = '1.0.0'
group = 'com.mutantcraft'
archivesBaseName = 'mutantcraft'

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

minecraft {
    mappings channel: 'parchment', version: '2024.11.17-1.21.1'

    runs {
        client {
            workingDirectory project.file('run')
            property 'forge.logging.markers', 'REGISTRIES'
            property 'forge.logging.console.level', 'debug'
            mods {
                mutantcraft { source sourceSets.main }
            }
        }
        server {
            workingDirectory project.file('run')
            property 'forge.logging.markers', 'REGISTRIES'
            property 'forge.logging.console.level', 'debug'
            mods {
                mutantcraft { source sourceSets.main }
            }
        }
    }
}

repositories {
    maven { url 'https://maven.parchmentmc.org' }
}

dependencies {
    minecraft 'net.minecraftforge:forge:1.21.1-47.3.0'
}

jar {
    manifest {
        attributes([
            'Specification-Title'     : 'mutantcraft',
            'Specification-Vendor'    : 'mutantcraft',
            'Specification-Version'   : '1',
            'Implementation-Title'    : project.name,
            'Implementation-Version'  : project.jar.archiveVersion,
            'Implementation-Vendor'   : 'mutantcraft',
            'Implementation-Timestamp': new Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
        ])
    }
}
