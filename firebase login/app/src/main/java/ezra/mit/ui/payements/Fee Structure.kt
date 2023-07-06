package ezra.mit.ui.payements



import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_STRUCT
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import kotlin.random.Random


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FEESScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
) {


    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("All students") },


                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUTE_INTRO) {
                        popUpTo(ROUTE_Drawer) { inclusive = true }
                    }}) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },
        bottomBar = {

            BottomAppBar( modifier = Modifier.background(Color.Magenta)) {

                Text(text = " Click here to add",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.size(40.dp))


                IconButton(onClick = {
                    navController.navigate(ROUTE_STU) {
                        popUpTo(ROUTE_STRUCT) { inclusive = true }
                    }}) {
                    Icon(Icons.Default.Add, "backIcon",modifier = Modifier
                        .size(226.dp)

                        .border(
                            border = BorderStroke(2.dp, Color.Blue),
                            shape = MaterialTheme.shapes.medium,


                            )

                    )


                }








            }}
        ,

        content = {



            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {

                item {
                    Spacer(modifier = Modifier.size(20.dp))
                }
                item {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                    ) {

                        Column {
                            Text(
                                text = " ID ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "1.", fontSize = 30.sp)
                            Text(text = "2.", fontSize = 30.sp)
                            Text(text = "3.", fontSize = 30.sp)
                            Text(text = "4.", fontSize = 30.sp)
                            Text(text = "5.", fontSize = 30.sp)
                            Text(text = "6.", fontSize = 30.sp)
                            Text(text = "7.", fontSize = 30.sp)
                            Text(text = "8.", fontSize = 30.sp)
                            Text(text = "9.", fontSize = 30.sp)

                        }

                        Spacer(modifier = Modifier.size(10.dp))
                        Column {

                            Text(
                                text = " Name ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "Hamon ", fontSize = 30.sp)
                            Text(text = "Elvis", fontSize = 30.sp)
                            Text(text = "Sharon", fontSize = 30.sp)
                            Text(text = "Ressy", fontSize = 30.sp)
                            Text(text = "Brian", fontSize = 30.sp)
                            Text(text = "Linda", fontSize = 30.sp)
                            Text(text = "Ezra", fontSize = 30.sp)
                            Text(text = "Beast", fontSize = 30.sp)
                            Text(text = "Opera", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {
                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9


                            Text(
                                text = " Fee Paid ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${random1}", fontSize = 30.sp)
                            Text(text = "${random2}", fontSize = 30.sp)
                            Text(text = "${random3}", fontSize = 30.sp)
                            Text(text = "${random4}", fontSize = 30.sp)
                            Text(text = "${random5}", fontSize = 30.sp)
                            Text(text = "${random6}", fontSize = 30.sp)
                            Text(text = "${random7}", fontSize = 30.sp)
                            Text(text = "${random8}", fontSize = 30.sp)
                            Text(text = "${random9}", fontSize = 30.sp)


                        }
                        Spacer(modifier = Modifier.size(14.dp))

                        Column {

                            var random2: Int
                            var random3: Int
                            var random1: Int
                            var random4: Int
                            var random5: Int
                            var random6: Int
                            var random7: Int
                            var random8: Int
                            var random9: Int

                            random1 = Random.nextInt(1000, 55001)
                            random2 = Random.nextInt(1000, 55001)
                            random3 = Random.nextInt(1000, 55001)
                            random4 = Random.nextInt(1000, 55001)
                            random5 = Random.nextInt(1000, 55001)
                            random6 = Random.nextInt(1000, 55001)
                            random7 = Random.nextInt(1000, 55001)
                            random8 = Random.nextInt(1000, 55001)
                            random9 = Random.nextInt(1000, 55001)

                            var total1: Int
                            var total2: Int
                            var total3: Int
                            var total4: Int
                            var total5: Int
                            var total6: Int
                            var total7: Int
                            var total8: Int
                            var total9: Int

                            total1 = 55000 - random1
                            total2 = 55000 - random2
                            total3 = 55000 - random3
                            total4 = 55000 - random4
                            total5 = 55000 - random5
                            total6 = 55000 - random6
                            total7 = 55000 - random7
                            total8 = 55000 - random8
                            total9 = 55000 - random9

                            Text(
                                text = " Balance ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline
                            )


                            Text(text = "${total1}", fontSize = 30.sp)
                            Text(text = "${total2}", fontSize = 30.sp)
                            Text(text = "${total3}", fontSize = 30.sp)
                            Text(text = "${total4}", fontSize = 30.sp)
                            Text(text = "${total5}", fontSize = 30.sp)
                            Text(text = "${total6}", fontSize = 30.sp)
                            Text(text = "${total7}", fontSize = 30.sp)
                            Text(text = "${total8}", fontSize = 30.sp)
                            Text(text = "${total9}", fontSize = 30.sp)

Spacer(modifier = Modifier.size(10.dp))
                            Text(text = "Total", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                            Text(text = "${total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9}", fontSize = 20.sp)
                        }
                    }

                }




                }

        }
    )
}




@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun FEEScreenPreviewLight() {
    FEESScreen(null, rememberNavController(),)
}

