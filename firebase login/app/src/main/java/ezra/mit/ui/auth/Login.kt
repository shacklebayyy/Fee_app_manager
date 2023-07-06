package ezra.mit.ui.auth

import android.content.ClipData
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ezra.mit.R
import ezra.mit.data.Resource
import ezra.mit.navigation.ROUTE_ABOUT
import ezra.mit.navigation.ROUTE_HOME
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_SIGNUP
import ezra.mit.ui.animations.LogAnimation
import ezra.mit.ui.gradient
import ezra.mit.ui.theme.AppTheme
import ezra.mit.ui.theme.spacing
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent

@OptIn(ExperimentalMaterial3Api::class, InternalCoroutinesApi::class)
@Composable
fun LoginScreen(viewModel: AuthViewModel?, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginFlow = viewModel?.loginFlow?.collectAsState()




Row{
    Column(modifier = Modifier.fillMaxSize().background(gradient), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {




    LogAnimation(size = 250)

        Text(
            text = "Login ", color = MaterialTheme.colorScheme.onSurface,
            fontSize = 37.sp, fontWeight = FontWeight.Bold

        )
LazyColumn(modifier = Modifier.fillMaxSize()){
item {

        Column(


            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {





            Text(
                modifier = Modifier
                    .background(Color.White)
                    .clickable {
                        navController.navigate(ROUTE_ABOUT) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                        }
                    },
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )


            Spacer(modifier = Modifier.height(20.dp))

            ConstraintLayout(

            ) {

                val (refHeader, refEmail, refPassword, refButtonLogin, refTextSignup, refLoader) = createRefs()
                val spacing = MaterialTheme.spacing


                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = "Email", fontWeight = FontWeight.Bold)
                    },
                    modifier = Modifier
                        .constrainAs(refEmail) {
                            top.linkTo(refHeader.bottom, spacing.extraLarge)
                            start.linkTo(parent.start, spacing.large)
                            end.linkTo(parent.end, spacing.large)
                            width = Dimension.fillToConstraints
                        },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = "Password", fontWeight = FontWeight.Bold)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier

                        .constrainAs(refPassword) {
                            top.linkTo(refEmail.bottom, spacing.medium)
                            start.linkTo(parent.start, spacing.large)
                            end.linkTo(parent.end, spacing.large)
                            width = Dimension.fillToConstraints
                        },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )

                Button(
                    onClick = {
                        viewModel?.login(email, password)
                    },
                    modifier = Modifier.constrainAs(refButtonLogin) {
                        top.linkTo(refPassword.bottom, spacing.large)
                        start.linkTo(parent.start, spacing.extraLarge)
                        end.linkTo(parent.end, spacing.extraLarge)
                        width = Dimension.fillToConstraints
                    }
                ) {
                    Text(text = "Login")
                }


                Text(
                    modifier = Modifier
                        .constrainAs(refTextSignup) {
                            top.linkTo(refButtonLogin.bottom, spacing.medium)
                            start.linkTo(parent.start, spacing.extraLarge)
                            end.linkTo(parent.end, spacing.extraLarge)
                        }
                        .clickable {
                            navController.navigate(ROUTE_SIGNUP) {
                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                            }
                        },
                    text = "No account yet? Register Here",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )

                loginFlow?.value?.let {
                    when (it) {
                        is Resource.Failure -> {
                            val context = LocalContext.current
                            Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                        }

                        Resource.Loading -> {
                            CircularProgressIndicator(modifier = Modifier.constrainAs(refLoader) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            })
                        }

                        is Resource.Success -> {
                            LaunchedEffect(Unit) {
                                navController.navigate(ROUTE_INTRO) {
                                    popUpTo(ROUTE_LOGIN) { inclusive = true }
                                }
                            }
                        }
                    }
                }

            }}
            }
        }


    }


    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LoginScreenPreviewLight() {
    AppTheme {
        LoginScreen(null, rememberNavController())
    }
}

