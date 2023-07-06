package ezra.mit.ui.payements

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Window
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.Placeholder
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_Code
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_Pay
import ezra.mit.ui.auth.AuthViewModel



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun EnterScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val buttonText = remember { mutableStateOf("Click Me") }
    val context = LocalContext.current


    val payment = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
                , verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
                    value = payment.value,
                    onValueChange = { newValue ->
                        if (newValue.text.all { it.isDigit() }) {
                            payment.value = newValue
                        }
                    },
                    label ={Text(text = "Enter Amount")} ,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
        Row {
            Button(onClick = { buttonText.value = "Successfully Paid" }) {
                Text("Pay")
            }

                   Row(modifier = Modifier.clickable { navController.navigate(ROUTE_INTRO) {                                                                     
                       popUpTo(ROUTE_Pay) { inclusive = true }
                   } }) {                                                                                                                                        
                                                                                                                                                                
                                                                                                                                                                
            Spacer(modifier = Modifier.size(20.dp))
            CircularBox(size = 40.dp) {
                Icon(Icons.Default.Clear, "backIcon", modifier = Modifier.fillMaxSize())

            }   }
        }   }
        }




@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun CodeScreen(viewModel: AuthViewModel?, navController: NavHostController) {

    val code = remember { mutableStateOf(TextFieldValue()) }




    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
, verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {



    TextField(
        value = code.value,
        onValueChange = { newValue ->
            if (newValue.text.all { it.isDigit() }) {
                code.value = newValue
            }
        },
        label ={Text(text = "Enter Mpesa Code")} ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.padding(bottom = 16.dp)
    )
        Row{
    Button(onClick = { navController.navigate(ROUTE_Pay) {
        popUpTo(ROUTE_Code) { inclusive = true }
    }}) {
        Text("Enter Code")
    }
            Row(modifier = Modifier.clickable { navController.navigate(ROUTE_INTRO) {
                popUpTo(ROUTE_Code) { inclusive = true }
            } }) {
                

            Spacer(modifier = Modifier.size(20.dp))
            CircularBox(size = 40.dp) {
                Icon(Icons.Default.Clear, "backIcon", modifier = Modifier.fillMaxSize())

            }}
        }
}
}









@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PaScreenPreviewLight() {
    EnterScreen(null, rememberNavController())
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PacreenPreviewLight() {
    CodeScreen(null, rememberNavController())
}



