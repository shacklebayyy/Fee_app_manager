package ezra.mit.ui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


var gradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF84FFFF),
        Color.White,
        Color.White,

        )
)

var gradients = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color.White,
        Color.White,

        )
)


val Total: Int = 55000
val Balance = Random.nextInt(1000, 55001)
