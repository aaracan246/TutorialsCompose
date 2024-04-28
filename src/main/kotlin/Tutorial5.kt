//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.window.singleWindowApplication
//
//fun main() = singleWindowApplication(title = "Context menu") {
//    val text = remember { mutableStateOf("Hello!") }
//    TextField(
//        value = text.value,
//        onValueChange = { text.value = it },
//        label = { Text(text = "Input") }
//    )
//}

//import androidx.compose.foundation.text.selection.SelectionContainer
//import androidx.compose.material.Text
//import androidx.compose.ui.window.singleWindowApplication
//
//fun main() = singleWindowApplication(title = "Context menu") {
//    SelectionContainer {
//        Text("Hello World!")
//    }
//}


//import androidx.compose.foundation.ContextMenuDataProvider
//import androidx.compose.foundation.ContextMenuItem
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.text.selection.SelectionContainer
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.singleWindowApplication
//
//fun main() = singleWindowApplication(title = "Context menu") {
//    val text = remember { mutableStateOf("Hello!") }
//    Column {
//        ContextMenuDataProvider(
//            items = {
//                listOf(
//                    ContextMenuItem("User-defined Action") {/*do something here*/ },
//                    ContextMenuItem("Another user-defined action") {/*do something else*/ }
//                )
//            }
//        ) {
//            TextField(
//                value = text.value,
//                onValueChange = { text.value = it },
//                label = { Text(text = "Input") }
//            )
//
//            Spacer(Modifier.height(16.dp))
//
//            SelectionContainer {
//                Text("Hello World!")
//            }
//        }
//    }
//}



//import androidx.compose.foundation.ContextMenuArea
//import androidx.compose.foundation.ContextMenuItem
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.width
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.singleWindowApplication
//
//fun main() = singleWindowApplication(title = "Context menu") {
//    ContextMenuArea(items = {
//        listOf(
//            ContextMenuItem("User-defined Action") {/*do something here*/},
//            ContextMenuItem("Another user-defined action") {/*do something else*/}
//        )
//    }) {
//        Box(modifier = Modifier.background(Color.Blue).height(100.dp).width(100.dp))
//    }
//}


import androidx.compose.foundation.DarkDefaultContextMenuRepresentation
import androidx.compose.foundation.LightDefaultContextMenuRepresentation
import androidx.compose.foundation.LocalContextMenuRepresentation
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication {
    isSystemInDarkTheme()
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
    ) {
        val contextMenuRepresentation = if (isSystemInDarkTheme()) {
            DarkDefaultContextMenuRepresentation
        } else {
            LightDefaultContextMenuRepresentation
        }
        CompositionLocalProvider(LocalContextMenuRepresentation provides contextMenuRepresentation) {
            Surface(Modifier.fillMaxSize()) {
                Box {
                    var value by remember { mutableStateOf("") }
                    TextField(value, { value = it })
                }
            }
        }
    }
}