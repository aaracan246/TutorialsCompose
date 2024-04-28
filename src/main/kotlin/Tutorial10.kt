//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.awt.ComposePanel
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import java.awt.BorderLayout
//import java.awt.Dimension
//import javax.swing.JButton
//import javax.swing.JFrame
//import javax.swing.SwingUtilities
//import javax.swing.WindowConstants
//
//val northClicks = mutableStateOf(0)
//val westClicks = mutableStateOf(0)
//val eastClicks = mutableStateOf(0)
//
//fun main() = SwingUtilities.invokeLater {
//    val window = JFrame()
//
//    // creating ComposePanel
//    val composePanel = ComposePanel()
//    window.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
//    window.title = "SwingComposeWindow"
//
//    window.contentPane.add(actionButton("NORTH", action = { northClicks.value++ }), BorderLayout.NORTH)
//    window.contentPane.add(actionButton("WEST", action = { westClicks.value++ }), BorderLayout.WEST)
//    window.contentPane.add(actionButton("EAST", action = { eastClicks.value++ }), BorderLayout.EAST)
//    window.contentPane.add(
//        actionButton(
//            text = "SOUTH/REMOVE COMPOSE",
//            action = {
//                window.contentPane.remove(composePanel)
//            }
//        ),
//        BorderLayout.SOUTH
//    )
//
//    // addind ComposePanel on JFrame
//    window.contentPane.add(composePanel, BorderLayout.CENTER)
//
//    // setting the content
//    composePanel.setContent {
//        ComposeContent()
//    }
//
//    window.setSize(800, 600)
//    window.isVisible = true
//}
//
//fun actionButton(text: String, action: () -> Unit): JButton {
//    val button = JButton(text)
//    button.toolTipText = "Tooltip for $text button."
//    button.preferredSize = Dimension(100, 100)
//    button.addActionListener { action() }
//    return button
//}
//
//@Composable
//fun ComposeContent() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Row {
//            Counter("West", westClicks)
//            Spacer(modifier = Modifier.width(25.dp))
//            Counter("North", northClicks)
//            Spacer(modifier = Modifier.width(25.dp))
//            Counter("East", eastClicks)
//        }
//    }
//}
//
//@Composable
//fun Counter(text: String, counter: MutableState<Int>) {
//    Surface(
//        modifier = Modifier.size(130.dp, 130.dp),
//        color = Color(180, 180, 180),
//        shape = RoundedCornerShape(4.dp)
//    ) {
//        Column {
//            Box(
//                modifier = Modifier.height(30.dp).fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "${text}Clicks: ${counter.value}")
//            }
//            Spacer(modifier = Modifier.height(25.dp))
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Button(onClick = { counter.value++ }) {
//                    Text(text = text, color = Color.White)
//                }
//            }
//        }
//    }
//}


//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.awt.SwingPanel
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.singleWindowApplication
//import java.awt.Component
//import javax.swing.BoxLayout
//import javax.swing.JButton
//import javax.swing.JPanel
//
//fun main() = singleWindowApplication {
//    val counter = remember { mutableStateOf(0) }
//
//    val inc: () -> Unit = { counter.value++ }
//    val dec: () -> Unit = { counter.value-- }
//
//    Box(
//        modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 20.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Text("Counter: ${counter.value}")
//    }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier.padding(top = 80.dp, bottom = 20.dp)
//        ) {
//            Button("1. Compose Button: increment", inc)
//            Spacer(modifier = Modifier.height(20.dp))
//
//            SwingPanel(
//                background = Color.White,
//                modifier = Modifier.size(270.dp, 90.dp),
//                factory = {
//                    JPanel().apply {
//                        layout = BoxLayout(this, BoxLayout.Y_AXIS)
//                        add(actionButton("1. Swing Button: decrement", dec))
//                        add(actionButton("2. Swing Button: decrement", dec))
//                        add(actionButton("3. Swing Button: decrement", dec))
//                    }
//                }
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Button("2. Compose Button: increment", inc)
//        }
//    }
//}
//
//@Composable
//fun Button(text: String = "", action: (() -> Unit)? = null) {
//    Button(
//        modifier = Modifier.size(270.dp, 30.dp),
//        onClick = { action?.invoke() }
//    ) {
//        Text(text)
//    }
//}
//
//fun actionButton(
//    text: String,
//    action: () -> Unit
//): JButton {
//    val button = JButton(text)
//    button.alignmentX = Component.CENTER_ALIGNMENT
//    button.addActionListener { action() }
//
//    return button
//}


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import java.awt.BorderLayout
import javax.swing.JPanel
import javax.swing.JLabel

val swingLabel = JLabel()

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = 400.dp, height = 200.dp),
    ) {
        val clicks = remember { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SwingPanel(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                factory = {
                    JPanel().apply {
                        add(swingLabel, BorderLayout.CENTER)
                    }
                },
                update = {
                    swingLabel.setText("SwingLabel Clicks: ${clicks.value}")
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier.height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { clicks.value++ }) {
                    Text(text = "Increment")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = { clicks.value-- }) {
                    Text(text = "Decrement")
                }
            }
        }
    }
}