package phucvvph34858.fpt.edu.vn.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             GetlayoutNavigation()
        }
    }
}

enum class Router {
    WelComee,
    Homee,
    Addd,
    Updatee
}

@Composable
fun GetlayoutNavigation() {
    val navController = rememberNavController()
    NavHost(navController =navController,  startDestination = Router.WelComee.name){
        composable(Router.WelComee.name){
            LayoutWelcome(navController=navController)
        }
        composable(Router.Homee.name){
            LayoutHome(navController = navController)
        }
        composable(Router.Addd.name){
            LayoutAdd(navController = navController)
        }
        composable(
            "${Router.Updatee.name}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            LayoutUpdate(navController, id)
        }
    }
}