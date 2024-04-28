/*Este depende de customizar build.gradle.kts y demás apartados secundarios*/

/*import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(compose.desktop.currentOS)
}

compose.desktop {
    application {
        mainClass = "example.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
        }
    }
}*/


/*compose.desktop {
    application {
        nativeDistributions {
            modules("java.sql")
            // alternatively: includeAllModules = true
        }
    }
}*/


/*compose.desktop {
    application {
        nativeDistributions {
            // a version for all distributables
            packageVersion = "..."

            linux {
              // a version for all Linux distributables
              packageVersion = "..."
              // a version only for the deb package
              debPackageVersion = "..."
              // a version only for the rpm package
              rpmPackageVersion = "..."
            }
            macOS {
              // a version for all macOS distributables
              packageVersion = "..."
              // a version only for the dmg package
              dmgPackageVersion = "..."
              // a version only for the pkg package
              pkgPackageVersion = "..."

              // a build version for all macOS distributables
              packageBuildVersion = "..."
              // a build version only for the dmg package
              dmgPackageBuildVersion = "..."
              // a build version only for the pkg package
              pkgPackageBuildVersion = "..."
            }
            windows {
              // a version for all Windows distributables
              packageVersion = "..."
              // a version only for the msi package
              msiPackageVersion = "..."
              // a version only for the exe package
              exePackageVersion = "..."
            }
        }
    }
}*/


/*compose.desktop {
    application {
        javaHome = System.getenv("JDK_17")
    }
}*/

/*compose.desktop {
    application {
        nativeDistributions {
            outputBaseDir.set(project.buildDir.resolve("customOutputDir"))
        }
    }
}*/

/*compose.desktop {
    application {
        mainClass = "MainKt"
        jvmArgs += listOf("-Xmx2G")
        args += listOf("-customArgument")
    }
}*/

/*compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageVersion = "1.0.0"

            appResourcesRootDir.set(project.layout.projectDirectory.dir("resources"))
        }
    }
}*/


/*import java.io.File

val resourcesDir = File(System.getProperty("compose.application.resources.dir"))

fun main() {
    println(resourcesDir.resolve("resource.txt").readText())
}*/

/*plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

val customSourceSet = sourceSets.create("customSourceSet")
compose.desktop {
    application {
        from(customSourceSet)
    }
}*/

/*
* plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm("customJvmTarget") {}
}

compose.desktop {
    application {
        from(kotlin.targets["customJvmTarget"])
    }
}*/


//compose.desktop {
//    application {
//        disableDefaultConfiguration()
//        fromFiles(project.fileTree("libs/") { include("**/*.jar") })
//        mainJar.set(project.file("main.jar"))
//        dependsOn("mainJarTask")
//    }
//}



//compose.desktop {
//    application {
//        nativeDistributions {
//            macOS {
//                iconFile.set(project.file("icon.icns"))
//            }
//            windows {
//                iconFile.set(project.file("icon.ico"))
//            }
//            linux {
//                iconFile.set(project.file("icon.png"))
//            }
//        }
//    }
//}




//// build.gradle.kts
//compose.desktop {
//    application {
//        mainClass = "MainKt"
//        nativeDistributions {
//            targetFormats(TargetFormat.Dmg)
//            packageName = "Deep Linking Example App"
//            macOS {
//                bundleID = "org.jetbrains.compose.examples.deeplinking"
//                infoPlist {
//                    extraKeysRawXml = macExtraPlistKeys
//                }
//            }
//        }
//    }
//}
//
//val macExtraPlistKeys: String
//    get() = """
//      <key>CFBundleURLTypes</key>
//      <array>
//        <dict>
//          <key>CFBundleURLName</key>
//          <string>Example deep link</string>
//          <key>CFBundleURLSchemes</key>
//          <array>
//            <string>compose</string>
//          </array>
//        </dict>
//      </array>
//    """



// src/main/main.kt

//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.window.singleWindowApplication
//import java.awt.Desktop
//
//fun main() {
//    var text by mutableStateOf("Hello, World!")
//
//    try {
//        Desktop.getDesktop().setOpenURIHandler { event ->
//            text = "Open URI: " + event.uri
//        }
//    } catch (e: UnsupportedOperationException) {
//        println("setOpenURIHandler is unsupported")
//    }
//
//    singleWindowApplication {
//        MaterialTheme {
//            Text(text)
//        }
//    }
//}


//compose.desktop {
//    application {
//        buildTypes.release.proguard {
//            configurationFiles.from(project.file("compose-desktop.pro"))
//        }
//    }
//}
//See the Guardsquare's comprehensive manual on ProGuard's rules & configuration options.
//
//Obfuscation is disabled by default. To enable it, set the following property via Gradle DSL:
//
//compose.desktop {
//    application {
//        buildTypes.release.proguard {
//            obfuscate.set(true)
//        }
//    }
//}
//ProGuard's optimizations are enabled by default. To disable them, set the following property via Gradle DSL:
//
//compose.desktop {
//    application {
//        buildTypes.release.proguard {
//            optimize.set(false)
//        }
//    }
//}