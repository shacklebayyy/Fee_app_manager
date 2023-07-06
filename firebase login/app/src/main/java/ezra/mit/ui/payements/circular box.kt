package ezra.mit.ui.payements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularBox(
    modifier: Modifier = Modifier,
    size: Dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .width(100.dp)
            .size(size)
            .background(Color.Red)
            .clip(MaterialTheme.shapes.large),
        content = content
    )
}
