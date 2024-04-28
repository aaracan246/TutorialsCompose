//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//
//fun main() = application {
//    var fileName by remember { mutableStateOf("Untitled") }
//
//    Window(onCloseRequest = ::exitApplication, title = "$fileName - Editor") {
//        Button(onClick = { fileName = "note.txt" }) {
//            Text("Save")
//        }
//    }
//}

//
//import androidx.compose.material.Text
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import kotlinx.coroutines.delay
//
//fun main() = application {
//    var isPerformingTask by remember { mutableStateOf(true) }
//
//    LaunchedEffect(Unit) {
//        delay(2000) // Do some heavy lifting
//        isPerformingTask = false
//    }
//
//    if (isPerformingTask) {
//        Window(onCloseRequest = ::exitApplication) {
//            Text("Performing some tasks. Please wait!")
//        }
//    } else {
//        Window(onCloseRequest = ::exitApplication) {
//            Text("Hello, World!")
//        }
//    }
//}


//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.window.DialogWindow
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//
//fun main() = application {
//    var isOpen by remember { mutableStateOf(true) }
//    var isAskingToClose by remember { mutableStateOf(false) }
//
//    if (isOpen) {
//        Window(
//            onCloseRequest = { isAskingToClose = true }
//        ) {
//            if (isAskingToClose) {
//                DialogWindow(
//                    onCloseRequest = { isAskingToClose = false },
//                    title = "Close the document without saving?",
//                ) {
//                    Button(
//                        onClick = { isOpen = false }
//                    ) {
//                        Text("Yes")
//                    }
//                }
//            }
//        }
//    }
//}


import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay

fun main() = application {
    var isVisible by remember { mutableStateOf(true) }

    Window(
        onCloseRequest = { isVisible = false },
        visible = isVisible,
        title = "Counter",
    ) {
        var counter by remember { mutableStateOf(0) }
        LaunchedEffect(Unit) {
            while (true) {
                counter++
                delay(1000)
            }
        }
        Text(counter.toString())
    }

    if (!isVisible) {
        Tray(
            TrayIcon,
            tooltip = "Counter",
            onAction = { isVisible = true },
            menu = {
                Item("Exit", onClick = ::exitApplication)
            },
        )
    }
}

object TrayIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color(0xFFFFA500))
    }
}