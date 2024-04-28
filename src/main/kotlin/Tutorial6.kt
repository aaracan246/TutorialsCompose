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


//import androidx.compose.material.Text
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.window.Tray
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import kotlinx.coroutines.delay
//
//fun main() = application {
//    var isVisible by remember { mutableStateOf(true) }
//
//    Window(
//        onCloseRequest = { isVisible = false },
//        visible = isVisible,
//        title = "Counter",
//    ) {
//        var counter by remember { mutableStateOf(0) }
//        LaunchedEffect(Unit) {
//            while (true) {
//                counter++
//                delay(1000)
//            }
//        }
//        Text(counter.toString())
//    }
//
//    if (!isVisible) {
//        Tray(
//            TrayIcon,
//            tooltip = "Counter",
//            onAction = { isVisible = true },
//            menu = {
//                Item("Exit", onClick = ::exitApplication)
//            },
//        )
//    }
//}
//
//object TrayIcon : Painter() {
//    override val intrinsicSize = Size(256f, 256f)
//
//    override fun DrawScope.onDraw() {
//        drawOval(Color(0xFFFFA500))
//    }
//}


//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.key
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.window.ApplicationScope
//import androidx.compose.ui.window.MenuBar
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//
//fun main() = application {
//    val applicationState = remember { MyApplicationState() }
//
//    for (window in applicationState.windows) {
//        key(window) {
//            MyWindow(window)
//        }
//    }
//}
//
//@Composable
//private fun ApplicationScope.MyWindow(
//    state: MyWindowState
//) = Window(onCloseRequest = state::close, title = state.title) {
//    MenuBar {
//        Menu("File") {
//            Item("New window", onClick = state.openNewWindow)
//            Item("Exit", onClick = state.exit)
//        }
//    }
//}
//
//private class MyApplicationState {
//    val windows = mutableStateListOf<MyWindowState>()
//
//    init {
//        windows += MyWindowState("Initial window")
//    }
//
//    fun openNewWindow() {
//        windows += MyWindowState("Window ${windows.size}")
//    }
//
//    fun exit() {
//        windows.clear()
//    }
//
//    private fun MyWindowState(
//        title: String
//    ) = MyWindowState(
//        title,
//        openNewWindow = ::openNewWindow,
//        exit = ::exit,
//        windows::remove
//    )
//}
//
//private class MyWindowState(
//    val title: String,
//    val openNewWindow: () -> Unit,
//    val exit: () -> Unit,
//    private val close: (MyWindowState) -> Unit
//) {
//    fun close() = close(this)
//}


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = Dp.Unspecified, height = Dp.Unspecified),
        title = "Adaptive",
        resizable = false
    ) {
        Column(Modifier.background(Color(0xFFEEEEEE))) {
            Row {
                Text("label 1", Modifier.size(100.dp, 100.dp).padding(10.dp).background(Color.White))
                Text("label 2", Modifier.size(150.dp, 200.dp).padding(5.dp).background(Color.White))
                Text("label 3", Modifier.size(200.dp, 300.dp).padding(25.dp).background(Color.White))
            }
        }
    }
}