package ezra.mit.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ezra.mit.ui.about.AboutScreen
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.auth.LoginScreen
import ezra.mit.ui.auth.SignupScreen
import ezra.mit.ui.classses.ClassScreen
import ezra.mit.ui.classses.Label
import ezra.mit.ui.drawer.Drawerr
import ezra.mit.ui.home.HomeScreen
import ezra.mit.ui.intro.Greeting
import ezra.mit.ui.intro.Profilecreen
import ezra.mit.ui.payements.CodeScreen
import ezra.mit.ui.payements.EnterScreen
import ezra.mit.ui.payements.FEESScreen
import ezra.mit.ui.reciepts_balance.ReceiptScreen
import ezra.mit.ui.share_Rate.RateScreen
import ezra.mit.ui.students.StuScreen

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(viewModel, navController)
        }
        composable(ROUTE_INTRO) {
            Greeting(viewModel, navController)
        }

        composable(ROUTE_CLASS) {
            ClassScreen(viewModel, navController)
        }
        composable(ROUTE_Label) {
            Label(viewModel, navController)
        }

        composable(ROUTE_Drawer) {
            Drawerr(viewModel, navController)
        }



        composable(ROUTE_STRUCT) {
            FEESScreen(viewModel, navController,)
        }

        composable(ROUTE_Rate) {

           RateScreen(viewModel, navController)
        }

        composable(ROUTE_STU) {

            StuScreen(viewModel, navController)
        }

        composable(ROUTE_Pay) {

           EnterScreen(viewModel, navController)
        }
        composable(ROUTE_Reci) {

            ReceiptScreen(viewModel, navController)
        }
        composable(ROUTE_Code) {

         CodeScreen(viewModel, navController)
        }
        composable(ROUTE_Pro) {

       Profilecreen(viewModel, navController)
        }

        }
}