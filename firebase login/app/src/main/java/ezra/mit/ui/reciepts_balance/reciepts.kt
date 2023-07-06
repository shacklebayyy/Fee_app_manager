package ezra.mit.ui.reciepts_balance


import android.annotation.SuppressLint
import android.content.res.Configuration
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_ABOUT
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Reci
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.theme.md_theme_dark_background
import java.util.Date
import java.util.Locale
import kotlin.random.Random


@RequiresApi(Build.VERSION_CODES.N)
fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val currentDate = Date()
    return dateFormat.format(currentDate)
}

@RequiresApi(Build.VERSION_CODES.N)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptScreen(viewModel: AuthViewModel?, navController: NavHostController) {


    val Total: Int = 55000
    val Balance = Random.nextInt(1000, 55001)

    var payments =  Total - Balance

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("Reciepts") },


                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_INTRO) {
                            popUpTo(ROUTE_STU) { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },
        bottomBar = {

            BottomAppBar( containerColor = Color.LightGray
                ,

                ) {

                Spacer(modifier = Modifier.width(40.dp))

                IconButton(onClick = {  navController.navigate(ROUTE_Drawer) {
                    popUpTo(ROUTE_Reci) { inclusive = true }
                }
                }) {
                    Icon(Icons.Default.Home, "backIcon",modifier = Modifier.size(226.dp))

                }

                Spacer(modifier = Modifier.width(80.dp))

                IconButton(onClick = {

                    navController.navigate(
                        ROUTE_ABOUT
                    ) {
                        popUpTo(ROUTE_Reci) { inclusive = true }
                    }

                }) {
                    Icon(Icons.Default.Info, "accout", modifier = Modifier.size(226.dp))

                }
                Spacer(modifier = Modifier.width(80.dp))

                IconButton(onClick = {
                    navController.navigate(
                        ROUTE_LOGIN
                    ) {
                        popUpTo(ROUTE_Reci) { inclusive = true }
                    }
                }) {
                    Icon(Icons.Default.ExitToApp, "accout", modifier = Modifier.size(226.dp))

                }
                Spacer(modifier = Modifier.width(60.dp))



            }






        }


        ,

        content = {
            Card(
            modifier = Modifier
                .padding(top = 100.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .height(500.dp)
               ,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation =16.dp
            ),

            shape = RoundedCornerShape(5.dp),
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Receipt",
                        style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 16.dp), textDecoration = TextDecoration.Underline
                    )

                    Row {

                        Column() {


                            Text(
                                text = "Date: ${getCurrentDate()}",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Text(
                                text = "Total fees:",
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            // List of items
                            val items = listOf(
                                "First Payment - $10",
                                "Second Payment - $20",
                                "Third Payment- $15"
                            )

                            for (item in items) {
                                Text(
                                    text = item,
                                    style = TextStyle(fontSize = 14.sp),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(20.dp))

Divider(modifier = Modifier
    .height(340.dp)
    .width(2.dp))


Column(

) {
    Row() {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "Name: ",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(0.3f),
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = viewModel?.currentUser?.displayName ?: "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(0.7f),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Text(
                text = "Email: ",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(0.3f),
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = viewModel?.currentUser?.email ?: "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(0.7f),
                color = MaterialTheme.colorScheme.onSurface
            )



        }
    }
    Text(
        text = "Fee Balance :  ${Balance}",
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 16.dp)
    )}




                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Total :  ${Total}",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Box(modifier = Modifier
                            .fillMaxWidth()) {
                            Row {
                                Button(
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        md_theme_dark_background
                                )
, modifier = Modifier.padding(start =95.dp)
                                ) {
                                    Text(text = "Print")
                                }
                            }
                        }
                    }
                }



        }
        }

    )

}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun  ReceiptScreenPreviewLight() {
    ReceiptScreen(null, rememberNavController(),)
}

