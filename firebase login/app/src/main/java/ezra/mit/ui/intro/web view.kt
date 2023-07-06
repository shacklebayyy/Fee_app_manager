package ezra.mit.ui.intro

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ezra.mit.R

@Composable
fun WebsiteButton(url: String) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable(onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent) })
            .height(100.dp)
            .width(150.dp)

        ,
        elevation = CardDefaults.cardElevation(
            defaultElevation =16.dp
        ),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),

        ) {

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Go Web View",
            color = MaterialTheme.colorScheme.inversePrimary,
            fontSize = 19.sp
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_web_24),
            contentDescription = stringResource(id = R.string.empty),
            modifier = Modifier.size(128.dp)
        )

    }

}



@Composable
fun MyScreen() {
    Column {
        // Other composables...

        WebsiteButton(url = "http://www.onlinefeemanager.com/")
    }
}
