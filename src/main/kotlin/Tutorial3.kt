import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


//@Composable
//fun Tuto3(){
//    var count by remember { mutableStateOf(0) }
//    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
//        var text by remember { mutableStateOf("Click magenta box!") }
//        Column {
//            @OptIn(ExperimentalFoundationApi::class)
//            Box(
//                modifier = Modifier
//                    .background(Color.Magenta)
//                    .fillMaxWidth(0.7f)
//                    .fillMaxHeight(0.2f)
//                    .combinedClickable(
//                        onClick = {
//                            text = "Click! ${count++}"
//                        },
//                        onDoubleClick = {
//                            text = "Double click! ${count++}"
//                        },
//                        onLongClick = {
//                            text = "Long click! ${count++}"
//                        }
//                    )
//            )
//            Text(text = text, fontSize = 40.sp)
//        }
//    }
//}



import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent


@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun Tuto3_2() {
    var color by remember { mutableStateOf(Color(0, 0, 0)) }
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()
            .background(color = color)
            .onPointerEvent(PointerEventType.Move) {
                val position = it.changes.first().position
                color = Color(position.x.toInt() % 256, position.y.toInt() % 256, 0)
            }
    )
}