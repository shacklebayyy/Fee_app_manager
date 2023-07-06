package ezra.mit.ui.drawer


import android.content.Intent
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_CLASS
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Pro
import ezra.mit.navigation.ROUTE_Rate
import ezra.mit.navigation.ROUTE_SIGNUP
import ezra.mit.navigation.ROUTE_STRUCT

import ezra.mit.ui.animations.cashAnimation
import ezra.mit.ui.animations.managerAnimation

import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.gradient
import ezra.mit.ui.gradients
import ezra.mit.ui.theme.spacing




@Composable
fun Drawerr(viewModel: AuthViewModel?, navController: NavHostController) {


    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        type = "Fee app"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
       ) {

Row(modifier = Modifier.fillMaxSize()) {


    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .width(100.dp)


    ) {

        item {
            Icon(Icons.Default.AccountCircle, "backIcon", Modifier.size(80.dp))


        }
        item {
            Spacer(modifier = Modifier.size(30.dp))
        }

        item {
            Row() {
                Column() {

                    Row(modifier = Modifier.clickable {
                        navController.navigate(ROUTE_INTRO) {
                            popUpTo(ROUTE_Drawer) { inclusive = true }
                        }
                    }) {

                        Icon(Icons.Default.Home, "backIcon")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "Home", fontSize = 19.sp)
                    }


                    Spacer(modifier = Modifier.size(30.dp))

                    Row (modifier = Modifier.clickable {   navController.navigate(ROUTE_Pro) {
                        popUpTo(ROUTE_Drawer) { inclusive = true }
                    } }){

                        Icon(Icons.Default.Person, "backIcon")
                        Spacer(modifier = Modifier.size(10.dp))

                        Text(text = "Profile", fontSize = 19.sp)

                    }

                }

            }
        }
        item {
            Spacer(modifier = Modifier.size(40.dp))
        }

        item {
            Divider(modifier = Modifier.width(20.dp))
        }
        item {
            Spacer(modifier = Modifier.size(20.dp))
        }



        item {

            Row() {
                Column() {
                    Row(modifier = Modifier.clickable {
                        navController.navigate(ROUTE_CLASS) {
                            popUpTo(ROUTE_Drawer) { inclusive = true }
                        }
                    }) {


                        Text(text = "Class", fontSize = 18.sp)


                    }

                    Spacer(modifier = Modifier.size(10.dp))
                    Row(modifier = Modifier.clickable {
                        navController.navigate(
                            ROUTE_STRUCT
                        ) {
                            popUpTo(ROUTE_Drawer) { inclusive = true }
                        }
                    }) {

                        Text(text = "Fee Structure", fontSize = 17.sp)
                    }


                }

            }
        }

        item {
            Spacer(modifier = Modifier.size(40.dp))
        }
        item {
            Divider(modifier = Modifier.fillMaxWidth())
        }

        item {
            Spacer(modifier = Modifier.size(20.dp))
            Row(modifier = Modifier.clickable {
                navController.navigate(
                    ROUTE_Rate
                ) {
                    popUpTo(ROUTE_Drawer) { inclusive = true }
                }
            }) {
                Icon(Icons.Default.Star, "backIcon")
                Spacer(modifier = Modifier.size(10.dp))

                Text(text = "Rate me", fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.size(20.dp))
            Row() {
                IconButton(
                    modifier = Modifier.width(90.dp),
                    onClick = { context.startActivity(shareIntent) }) {


                    Spacer(modifier = Modifier.size(20.dp))
                    Row {
                        Icon(Icons.Default.Share, "backIcon")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "Share", fontSize = 17.sp)
                    }
                }
            }


        }


        item {
            Divider(modifier = Modifier.fillMaxWidth())}
        item {
            Column(modifier = Modifier.clickable {
                navController.navigate(
                    ROUTE_LOGIN
                ) {
                    popUpTo(ROUTE_Drawer) { inclusive = true }
                }
            }) {


                Spacer(modifier = Modifier.size(30.dp))
                Row(modifier = Modifier.clickable {
                    navController.navigate(
                        ROUTE_SIGNUP
                    ) {
                        popUpTo(ROUTE_Drawer) { inclusive = true }
                    }
                }) {

                    Icon(Icons.Default.ExitToApp, "backIcon")
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "Log out", fontSize = 18.sp)
                }


            }
        }
        item {

        }

    }

    Divider(
        color = Color.Black,
        modifier = Modifier
            .fillMaxHeight()  //fill the max height
            .width(3.dp)
    )

    LazyColumn(
        modifier = Modifier
            .background(gradients)
            .fillMaxHeight()
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {  navController.navigate(
                ROUTE_INTRO
            ) {
                popUpTo(ROUTE_Drawer) { inclusive = true }
            }}
    ) {

        item {

                Row(
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Manage you fees alll in one app")
                }
            Column(modifier = Modifier.fillMaxSize()) {
                
            }
            cashAnimation(200)
              managerAnimation(height = 200)
             cashAnimation(200)
             managerAnimation(height = 200)}
            }
        }
    }
}





@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun DrawerScreenPreviewLight() {
    Drawerr(null, rememberNavController())
}

