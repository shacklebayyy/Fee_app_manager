package ezra.mit.ui.students


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChipDefaults.IconSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_STU

import ezra.mit.ui.auth.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StuScreen(viewModel: AuthViewModel?, navController: NavHostController) {


    val fname by remember{  mutableStateOf("") }
    val sname by remember{  mutableStateOf("") }
    val lname by remember{  mutableStateOf("") }
    val email by remember{  mutableStateOf("") }
    val age by remember{  mutableStateOf("") }

        Scaffold(
            topBar = {
                SmallTopAppBar(title = { Text("ADD STUDENT") },


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

                    IconButton(onClick = {  navController.navigate(ROUTE_Drawer) {
                        popUpTo(ROUTE_STU) { inclusive = true }
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
                            popUpTo(ROUTE_STU) { inclusive = true }
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
                        .padding(top = 16.dp)
                        .fillMaxWidth(),


                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start


                ) {

item{
    Spacer(modifier = Modifier.size(20.dp))}
item {


    Box(modifier = Modifier.fillMaxWidth().padding(start = 70.dp).padding(top = 16.dp),



    ){
        Icon(Icons.Default.AccountCircle, "backIcon",modifier = Modifier.size(226.dp))


    }


}

item {  Spacer(modifier = Modifier.height(20.dp)) }





                    item {
                      OutlinedTextFieldWithIcon(
                          value = fname,
                          label = "First Name",
                          icon = Icons.Default.Person,
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(16.dp)
                      )
                  }




                    item {

                        OutlinedTextFieldWithIcon(
                            label = "Second Name",
                            icon = Icons.Default.Person,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            value = sname
                        ) }







                        item {

                        OutlinedTextFieldWithIcon(

                            label = "Last Name",
                            icon = Icons.Default.Person,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            value = lname
                        )
                    }









                        item {

                            OutlinedTextFieldWithIcon(
                                label = "Email",
                                icon = Icons.Default.Email,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                value = email
                            )
                        }




                          item {      OutlinedTextFieldWithIcon(
                              label = "Age",
                              icon = Icons.Default.Edit,
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(16.dp),
                              value =age
                          )
                          }

                    // Add more text fields for the remaining inputs



                }

            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OutlinedTextFieldWithIcon(
        label: String,
        icon: ImageVector,
        modifier: Modifier = Modifier,
        value: String
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(label) },
            modifier = modifier,
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(IconSize)
                )
            }
        )
    }







@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun StuScreenPreviewLight() {
    StuScreen(null, rememberNavController())
}

