package ph34858.laptrinhkotlin.asmPh34858

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ph34858.laptrinhkotlin.asmPh34858.screens.bell
import ph34858.laptrinhkotlin.asmPh34858.screens.cart
import ph34858.laptrinhkotlin.asmPh34858.screens.home
import ph34858.laptrinhkotlin.asmPh34858.screens.profile

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.home.route) {
        composable(route = BottomBarScreen.home.route) {
            home()
        }
        composable(route = BottomBarScreen.cart.route) {
            cart()
        }
        composable(route = BottomBarScreen.bell.route) {
            bell()
        }
        composable(route = BottomBarScreen.profile.route) {
            profile()
        }
    }
}