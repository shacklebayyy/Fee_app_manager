package ezra.mit.ui.intro



import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.media.Image
import android.os.Bundle
import android.util.Size
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import ezra.mit.R
import ezra.mit.navigation.ROUTE_ABOUT
import ezra.mit.navigation.ROUTE_CLASS
import ezra.mit.navigation.ROUTE_Code
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Label
import ezra.mit.navigation.ROUTE_Pay
import ezra.mit.navigation.ROUTE_Reci
import ezra.mit.navigation.ROUTE_SIGNUP
import ezra.mit.navigation.ROUTE_STU

import ezra.mit.ui.about.AboutScreen
import ezra.mit.ui.animations.paymentAnimation
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.drawer.Drawerr
import ezra.mit.ui.gradient
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class)

@Composable
fun Greeting(viewModel: AuthViewModel?, navController: NavHostController) {



    var currentTime by remember { mutableStateOf(Date()) }

    LaunchedEffect(Unit) {
        val format = SimpleDateFormat("hh:mm:ss a", java.util.Locale.getDefault())
        val animationSpec: AnimationSpec<Float> = tween(1000) // Update every second

        while (isActive) {
            currentTime = Date()
            delay(1000) // Delay for 1 second
        }
    }







val scaffoldState =







         Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
                 ){

        Scaffold(


            topBar = {
               SmallTopAppBar(



                    title = {
                        Text(text = "FEE MANAGER", fontWeight = FontWeight.Bold)
                    },
                   navigationIcon = {
                       IconButton(onClick = {

                           navController.navigate(ROUTE_Drawer) {
                               popUpTo(ROUTE_INTRO) { inclusive = true }
                           }

                       }) {
                           Icon(Icons.Filled.List, "backIcon")

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

                     IconButton(onClick = {  navController.navigate(ROUTE_INTRO) {
                         popUpTo(ROUTE_INTRO) { inclusive = true }
                     }
                     }) {
                         Icon(Icons.Default.Refresh, "backIcon",modifier = Modifier.size(226.dp))

                     }

                     Spacer(modifier = Modifier.width(80.dp))

                     IconButton(onClick = {

                         navController.navigate(
                             ROUTE_ABOUT
                         ) {
                             popUpTo(ROUTE_INTRO) { inclusive = true }
                         }

                     }) {
                         Icon(Icons.Default.Info, "accout", modifier = Modifier.size(226.dp))

                     }
                     Spacer(modifier = Modifier.width(80.dp))

                     IconButton(onClick = {
                         navController.navigate(
                             ROUTE_SIGNUP
                         ) {
                             popUpTo(ROUTE_INTRO) { inclusive = true }
                         }
                     }) {
                         Icon(Icons.Default.ExitToApp, "accout", modifier = Modifier.size(226.dp))

                     }
                     Spacer(modifier = Modifier.width(60.dp))



                 }






            }



            ,
//            the page contents are placed here



            content = {













                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(gradient)

                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {


                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        )
                        {
                       paymentAnimation(height = 500)
                        }

                    }
//              lazyy row
                    item {
                        LazyRow(
                            verticalAlignment = Alignment.CenterVertically,

                            modifier = Modifier
                                .padding(top = 16.dp)
                                .wrapContentHeight()
                                .fillMaxWidth()



                        ) {
//content  of the row
                            item {
                                Spacer(modifier = Modifier.size(20.dp))

                            }



//                            add students card



                            item {
                                Card(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .clickable(onClick = {
                                            navController.navigate(ROUTE_STU) {
                                                popUpTo(ROUTE_INTRO) { inclusive = true }
                                            }
                                        })
                                        .height(100.dp)
                                        .width(150.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primary,
                                    ),

                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation =16.dp
                                    ),

                                        shape = RoundedCornerShape(5.dp),
                                ) {
                                    Text(
                                        modifier = Modifier.padding(8.dp),
                                        text = "Add students",
                                        color = Color.White,
                                        fontSize = 19.sp
                                    )
                                    Icon(Icons.Default.Add, "backIcon",modifier = Modifier.size(226.dp))


                                }


                            }



//                                        payments card


                            item {
                                Spacer(modifier = Modifier.size(50.dp))

                            }
                            item {
                                Card(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .clickable(onClick = {
                                            navController.navigate(
                                                ROUTE_Code
                                            ) {
                                                popUpTo(ROUTE_INTRO) { inclusive = true }
                                            }
                                        })
                                        .height(100.dp)
                                        .width(150.dp)

                                    ,
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation =16.dp
                                    ),
                                    shape = RoundedCornerShape(5.dp),


                                ) {
                                    Text(
                                        modifier = Modifier.padding(16.dp),
                                        text = "Payments",
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = 19.sp
                                    )
                                    Icon(Icons.Default.CheckCircle, "backIcon",modifier = Modifier.size(226.dp))


                                }


                            }















                        }


                    }



                    item {
                        Spacer(modifier = Modifier.size(30.dp))
                    }
//




//                    lazyy row
                            item {
                                LazyRow(
                                    verticalAlignment = Alignment.CenterVertically,

                                    modifier = Modifier
                                        .padding(top = 16.dp)
                                        .wrapContentHeight()
                                        .fillMaxWidth()

                                ) {
//content  of the row
                                    item {
                                        Spacer(modifier = Modifier.size(20.dp))

                                    }




//                                    Reciept
                                    item {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp)
                                                .clickable {
                                                    navController.navigate(ROUTE_Reci) {
                                                        popUpTo(ROUTE_INTRO) { inclusive = true }
                                                    }
                                                }
                                                .height(100.dp)
                                                .width(150.dp)

                                            ,
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation =16.dp
                                            ),
                                            shape = RoundedCornerShape(5.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = Color.Magenta,
                                            ),


                                        ) {
                                            Text(
                                                modifier = Modifier.padding(16.dp),
                                                text = "Reciepts",
                                                color = MaterialTheme.colorScheme.primary,
                                                fontSize = 19.sp

                                            )

                                            Icon(Icons.Default.Menu, "backIcon",modifier = Modifier.size(226.dp))


                                        }


                                    }



                                    item {
                                        Spacer(modifier = Modifier.size(50.dp))

                                    }



//                          balance card





                                    item {
                                        WebsiteButton(url = "http://www.onlinefeemanager.com/")


                                    }


                                }





                            }



                    item {
                        Spacer(modifier = Modifier.size(50.dp))

                    }



item {
LazyRow(
    verticalAlignment = Alignment.CenterVertically,

    modifier = Modifier
        .padding(top = 16.dp)
        .wrapContentHeight()
        .fillMaxWidth()


){


    item {
        Text(
            text = SimpleDateFormat("hh:mm:ss a", java.util.Locale.ENGLISH).format(currentTime),
            fontSize = 24.sp
        )
    }




}



}





                }




                    










            }



        )}}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun DrawrrrScreenPreviewLight() {
    Greeting(null, rememberNavController())
}



