package com.example.challengesophos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.challengesophos.login.ScreenLogin
import com.example.challengesophos.navigation.Routes
import com.example.challengesophos.ui.theme.ChallengeSophosTheme
import com.example.challengesophos.view_model.LoginViewModel
import com.example.challengesophos.views.ScreenMain
import com.example.challengesophos.views.ScreenConsultDocuments
import com.example.challengesophos.views.ScreenSendDocuments
import com.example.challengesophos.views.ScreenOfficeMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeSophosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //NAVIGATION
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.ScreenLogin.route
                    ) {

                        composable(Routes.ScreenLogin.route) {
                            ScreenLogin(
                                loginViewModel = LoginViewModel(),
                                navigationController
                            )
                        }

                        composable(
                            Routes.ScreenMain.route,
                            arguments = listOf(navArgument("name") {
                                type = NavType.StringType

                            })
                        ) { backStackEntry ->
                            ScreenMain(
                                navigationController,
                                backStackEntry.arguments?.getString("name")!!
                            )
                        }

                        composable(Routes.ScreenOfficeMap.route) {
                            ScreenOfficeMap(

                            )
                        }
                        composable(Routes.ScreenSendDocument.route){
                            ScreenSendDocuments(
                                navigationController
                            )
                        }

                        composable(Routes.ScreenConsultDocuments.route){
                            ScreenConsultDocuments(
                                navigationController
                            )
                        }
                    }
                }
            }
        }
    }
}



