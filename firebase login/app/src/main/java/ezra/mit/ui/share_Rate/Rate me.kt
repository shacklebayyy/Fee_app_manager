package ezra.mit.ui.share_Rate


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.students.OutlinedTextFieldWithIcon


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RateScreen(viewModel: AuthViewModel?, navController: NavHostController) {



    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("RATE APP") },


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
        }
        ,

        content = {

            val buttonText = remember { mutableStateOf("Click Me") }
            val context = LocalContext.current

            Column(modifier = Modifier.size(350.dp), ){

                Text(text = "Rate me  !   !", fontWeight = FontWeight.Bold,fontSize = 40.sp, modifier = Modifier.padding(start = 80.dp))
                Spacer(modifier = Modifier.size(10.dp))
                Divider(modifier = Modifier.fillMaxWidth().size(20.dp))
                Spacer(modifier = Modifier.size(70.dp))

                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 10.dp)) {

                    IconButton(modifier = Modifier.size(65.dp),onClick = {
                        buttonText.value = "Thanks for the First Star"

                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier.fillMaxSize()
                        )


                    }


                    IconButton(modifier = Modifier.size(65.dp),onClick = {
                        buttonText.value = "Thanks for the Two Star"

                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier.fillMaxSize()
                        )


                    }

                    IconButton(modifier = Modifier.size(65.dp),onClick = {
                        buttonText.value = "Thanks for the Three Star"
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier.fillMaxSize()
                        )


                    }
                    IconButton(modifier = Modifier.size(65.dp),onClick = {
                        buttonText.value = "Thanks for the Four Stars"
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier.fillMaxSize()
                        )


                    }

                    IconButton(modifier = Modifier.size(65.dp),onClick = {
                        buttonText.value = "Thanks for All the  Star"
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            contentDescription = stringResource(id = R.string.empty),
                            modifier = Modifier.fillMaxSize()
                        )


                    }


                }




            }




        })







}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun RatecreenPreviewLight() {
  RateScreen(null, rememberNavController())
}


























