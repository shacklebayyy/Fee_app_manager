package ezra.mit.ui.about

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
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ezra.mit.navigation.ROUTE_ABOUT
import ezra.mit.navigation.ROUTE_Drawer
import ezra.mit.navigation.ROUTE_INTRO
import ezra.mit.navigation.ROUTE_LOGIN
import ezra.mit.navigation.ROUTE_STU
import ezra.mit.ui.auth.AuthViewModel
import ezra.mit.ui.students.OutlinedTextFieldWithIcon
import ezra.mit.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("ABOUT", fontWeight = FontWeight.Bold,modifier = Modifier.padding(start =  50.dp)) },


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

                Spacer(modifier = Modifier.width(40.dp))

                IconButton(onClick = {  navController.navigate(ROUTE_Drawer) {
                    popUpTo(ROUTE_INTRO) { inclusive = true }
                }
                }) {
                    Icon(Icons.Default.Home, "backIcon",modifier = Modifier.size(226.dp))

                }

                Spacer(modifier = Modifier.width(80.dp))

                IconButton(onClick = {

                    navController.navigate(
                        ROUTE_ABOUT
                    ) {
                        popUpTo(ROUTE_ABOUT) { inclusive = true }
                    }

                }) {
                    Icon(Icons.Default.Info, "accout", modifier = Modifier.size(226.dp))

                }
                Spacer(modifier = Modifier.width(80.dp))

                IconButton(onClick = {
                    navController.navigate(
                        ROUTE_LOGIN
                    ) {
                        popUpTo(ROUTE_ABOUT) { inclusive = true }
                    }
                }) {
                    Icon(Icons.Default.ExitToApp, "accout", modifier = Modifier.size(226.dp))

                }
                Spacer(modifier = Modifier.width(60.dp))



            }






        }


        ,

        content = {



            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
                    .padding(spacing.medium)
                    .padding(top = spacing.extraLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "Fee App",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " Sure! Here's an explanation of a fee app that contains a database of students and manages fee payments:\n" +
                                "\n" +
                                "Introduction:\n" +
                                "The Fee Management App is a powerful and efficient tool designed to streamline the process of managing fees for educational institutions, such as schools, colleges, and universities. This app serves as a comprehensive database system that stores student information and facilitates the management of fee payments. With its user-friendly interface and robust features, the app simplifies the administrative tasks involved in fee collection, tracking, and reporting.\n" +
                                "\n" +
                                "Database of Students:\n" +
                                "At the core of the Fee Management App lies a sophisticated database that securely stores student information. This database maintains essential details such as student names, contact information, enrollment numbers, classes or courses enrolled, and other relevant personal data. The app ensures data integrity and provides efficient search and retrieval functionalities to quickly access student information when needed.\n" +
                                "\n" +
                                "Fee Payment Tracking:\n" +
                                "The app offers comprehensive fee payment tracking capabilities. It allows administrators to record and manage fee payments for individual students. Payment details such as the amount paid, payment date, mode of payment, and receipt numbers are stored within the app's database. This information enables easy monitoring of fee payment statuses and ensures accurate financial records.\n" +
                                "\n" +
                                "Flexible Payment Options:\n" +
                                "To cater to various payment preferences, the app supports multiple payment methods. Students and parents can make fee payments through traditional methods such as cash, check, or bank transfers. Additionally, the app can integrate with popular online payment gateways, enabling secure and convenient online transactions. By providing diverse payment options, the app ensures flexibility and convenience for fee payment processes.\n" +
                                "\n" +
                                "Automated Fee Reminders:\n" +
                                "The Fee Management App automates fee reminders, eliminating the need for manual follow-ups. Administrators can set up reminders to notify students or parents about upcoming due dates or overdue payments. These reminders can be sent via SMS, email, or in-app notifications, ensuring that stakeholders stay informed and prompt with their fee submissions. By automating reminders, the app reduces administrative burden and improves fee collection efficiency.\n" +
                                "\n" +
                                "Financial Reporting and Analytics:\n" +
                                "One of the app's key features is its ability to generate comprehensive financial reports and analytics. Administrators can easily generate reports detailing fee collection summaries, outstanding balances, payment trends, and other financial insights. These reports aid in decision-making processes, budget planning, and auditing purposes. By providing a clear overview of the institution's financial health, the app empowers administrators to make informed financial decisions.\n" +
                                "\n" +
                                "Security and Privacy:\n" +
                                "The Fee Management App prioritizes the security and privacy of student data. It employs robust security measures, such as encryption and access controls, to safeguard sensitive information. Access to student data is restricted to authorized personnel only, ensuring confidentiality and compliance with data protection regulations.\n" +
                                "\n" +
                                "Integration with Other Systems:\n" +
                                "To enhance its functionality and utility, the app can integrate with other educational systems. For instance, it can seamlessly integrate with the institution's existing student information system (SIS) to synchronize student data. This integration eliminates redundancy and ensures consistent and up-to-date information across various platforms.\n" +
                                "\n" +
                                "Conclusion:\n" +
                                "The Fee Management App provides educational institutions with a reliable and efficient solution for managing student fees. By maintaining a comprehensive database of students and facilitating fee payments, the app simplifies administrative tasks, improves fee collection efficiency, and enhances financial transparency. With its user-friendly interface and advanced features, the app streamlines fee management processes, empowering educational institutions to focus on delivering quality education while ensuring smooth financial operations.\n",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                }
            }







        }
    )
}











@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreviewLight() {
    AboutScreen(null, rememberNavController())
}

