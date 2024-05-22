package ph34858.laptrinhkotlin.asmPh34858

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object home : BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object cart : BottomBarScreen(
        route = "Cart",
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )
    object bell : BottomBarScreen(
        route = "Bell",
        title = "Bell",
        icon = Icons.Default.Notifications
    )
    object profile : BottomBarScreen(
        route = "Profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}