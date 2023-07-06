package ezra.mit.ui.classses



import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.navigation.ROUTE_CLASS
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_HOME
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Label
import ezra.mit.navigation.ROUTE_SIGNUP

import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.gradient
import ezra.mit.ui.gradients
import androidx.compose.material3.Text as Text1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassScreen(viewModel: AuthViewModel?, navController: NavHostController) {

    var text by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text1("NEW CLASS") },


                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_INTRO) {
                            popUpTo(ROUTE_Drawer) { inclusive = true }
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

                IconButton(onClick = {  navController.navigate(ROUTE_Drawer) {
                    popUpTo(ROUTE_CLASS) { inclusive = true }
                }
                }) {
                    Icon(Icons.Default.Home, "backIcon",modifier = Modifier.size(226.dp))

                }

                Spacer(modifier = Modifier.width(60.dp))

                IconButton(onClick = {



                }) {
                    Icon(Icons.Default.Person, "accout", modifier = Modifier.size(226.dp))

                }
                Spacer(modifier = Modifier.width(60.dp))

                IconButton(onClick = {
                    navController.navigate(
                        ROUTE_LOGIN
                    ) {
                        popUpTo(ROUTE_CLASS) { inclusive = true }
                    }
                }) {
                    Icon(Icons.Default.ExitToApp, "accout", modifier = Modifier.size(226.dp))

                }




            }






        }
        ,

        content = {



            LazyColumn(
                modifier = Modifier
                    .padding(top = 116.dp, start = 54.dp)
                    .fillMaxWidth(),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {


                item{


                    IconButton(onClick = {

                        viewModel?.logout()
                        navController.navigate(ROUTE_Label) {
                            popUpTo(ROUTE_CLASS) { inclusive = true }
                        }
                    },modifier = Modifier
                        .size(250.dp).padding(start = 68.dp, end = 68.dp)
                      ) {
                Icon(Icons.Default.AddCircle, "backIcon",

                        modifier = Modifier
                        .fillMaxSize()

                )}

                }





            }

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Label(
    viewModel: AuthViewModel?,
    navController: NavHostController,


) {
    var text by remember { mutableStateOf(TextFieldValue("")) }


    Column(

modifier = Modifier

    .background(gradient),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

            Text(text = "Add class",
            fontSize = 30.sp,

                )
Spacer(modifier = Modifier.size(15.dp))
        TextField(
            value = text,
            onValueChange = {

                text = it
            },
            label = { Text1(text = "New Class") },
            placeholder = { Text1(text = "Class Name") },
        )

        Spacer(modifier = Modifier.size(20.dp))


        Row(modifier =Modifier.fillMaxWidth()) {


    Text(
        modifier = Modifier

            .clickable {
                navController.navigate(ROUTE_CLASS) {
                    popUpTo(ROUTE_Label) { inclusive = true }
                }
            },
        text = stringResource(id = R.string.Cancel),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurface
    )
            Spacer(modifier = Modifier.size(20.dp))

            Text(
                modifier = Modifier

                    .clickable {
                        navController.navigate(ROUTE_CLASS) {
                            popUpTo(ROUTE_Label) { inclusive = true }
                        }
                    },
                text = stringResource(id = R.string.Ok),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ClassScreenPreviewLight() {
    ClassScreen(null, rememberNavController())
}

@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ClasScreenPreviewLight() {
    Label(null, rememberNavController(),)
}
