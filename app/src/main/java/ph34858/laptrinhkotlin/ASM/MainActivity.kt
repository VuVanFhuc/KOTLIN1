package ph34858.laptrinhkotlin.ASM

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ph34858.laptrinhkotlin.ASM.screens.Home
import ph34858.laptrinhkotlin.ASM.screens.Login
import ph34858.laptrinhkotlin.ASM.screens.Register
import ph34858.laptrinhkotlin.ASM.screens.Welcom
import ph34858.laptrinhkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                AppNavigation()
            }

        }
    }

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "boarding") {
        composable("boarding") { Welcom() }
        composable("login") { Login() }
        composable("register") { Register() }
        composable("home") { Home() }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppNavigation()
}
