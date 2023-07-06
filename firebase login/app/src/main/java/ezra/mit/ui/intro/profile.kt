package ezra.mit.ui.intro

import android.accounts.Account
import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_HOME
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_Pro
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.Balance
import ezra.mit.ui.animations.AccountAnimation
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.gradient
import ezra.mit.ui.reciepts_balance.ReceiptScreen
import ezra.mit.ui.students.OutlinedTextFieldWithIcon
import ezra.mit.ui.theme.AppTheme
import ezra.mit.ui.theme.md_theme_light_background
import ezra.mit.ui.theme.spacing

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profilecreen(viewModel: AuthViewModel?, navController: NavHostController) {

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("                Profile") },


                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_INTRO) {
                            popUpTo(ROUTE_Pro) { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.KeyboardArrowLeft, "backIcon")

                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray)


            )
        },


        content = {


            Column(
                modifier = Modifier
                    .background(gradient)
                    .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
            ) {

                AccountAnimation(size = 200)
                Text(
                    text = "Account Details",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Account icon",
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = viewModel?.currentUser?.displayName ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(0.7f),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = "Email icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = viewModel?.currentUser?.email ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(0.7f),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.size(30.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Balance icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Balance: ${Balance}",
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                    )
                }

                // Add more details as needed


            }






}
    )
}





@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun   ProfilecreenPreviewLight() {
    Profilecreen(null, rememberNavController(),)
}







