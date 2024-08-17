package br.com.natura.conecta.ui.navigation

import br.com.natura.conecta.R
import br.com.natura.conecta.model.BottomAppBarItem
import br.com.natura.conecta.model.DrawerBarItem
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.Orange
import br.com.natura.conecta.ui.theme.Pink
import br.com.natura.conecta.ui.theme.PinkOrange

sealed class AppDestination(val route: String) {
    data object Splash : AppDestination("splash")
    data object Welcome : AppDestination("welcome")
    data object Login : AppDestination("login")
    data object Home : AppDestination("home")
    data object Map : AppDestination("map")
    data object Shop : AppDestination("shop")
    data object ProductDetails : AppDestination("productDetails")
    data object Community : AppDestination("community")
    data object Rank : AppDestination("rank")
    data object Cart : AppDestination("cart")
    data object ClosedCart : AppDestination("closedCart")
    data object OrderList : AppDestination("orderList")
    data object OrderDetails : AppDestination("orderDetails")
    data object Checkout : AppDestination("checkout")
    data object OrderFinished : AppDestination("orderFinished")
    data object Profile : AppDestination("profile")
    data object Orders : AppDestination("orders")
    data object Notifications : AppDestination("notifications")
    data object Settings : AppDestination("settings")
    data object Help : AppDestination("help")
    data object About : AppDestination("about")
    data object Levels : AppDestination("levels")
}

val bottomNavBarItems = listOf(
    BottomAppBarItem(
        icon = R.drawable.ic_home,
        color = Pink,
        destination = AppDestination.Home
    ),
    BottomAppBarItem(
        icon = R.drawable.ic_map,
        color = PinkOrange,
        destination = AppDestination.Map
    ),
    BottomAppBarItem(
        icon = R.drawable.ic_shop,
        color = DarkOrange,
        destination = AppDestination.Shop
    ),
    BottomAppBarItem(
        icon = R.drawable.ic_community,
        color = Orange,
        destination = AppDestination.Community
    )
)

val drawerBarItems = listOf(
    DrawerBarItem(
        icon = R.drawable.ic_cart,
        name = "Pedidos",
        route = AppDestination.Orders
    ),
    DrawerBarItem(
        icon = R.drawable.ic_notification,
        name = "Notificações",
        route = AppDestination.Notifications
    ),
    DrawerBarItem(
        icon = R.drawable.ic_settings,
        name = "Ajustes",
        route = AppDestination.Settings
    ),
    DrawerBarItem(
        icon = R.drawable.ic_help,
        name = "Ajuda",
        route = AppDestination.Help
    ),
    DrawerBarItem(
        icon = R.drawable.ic_info,
        name = "Sobre",
        route = AppDestination.About
    )
)