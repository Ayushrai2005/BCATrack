package ggv.ayush.bcatrack

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ggv.ayush.bcatrack.screen.WelcomeScreen
import ggv.ayush.bcatrack.ui.theme.BCATrackTheme
import ggv.ayush.narutoog.presentation.screens.splash.SplashScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BCATrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()

                    NavHost(navController = navController as NavHostController, startDestination = "splash") {


                        // Add the composable screens here
                        composable(route = "splash") {
                            SplashScreen(navController = navController)
                        }
                        composable(route = "welcome") {
                            WelcomeScreen(navController = navController)
                        }
                        composable(route = "main") {
                            MainPage()
                        }
                    }
                }
            }
        }
    }
}
