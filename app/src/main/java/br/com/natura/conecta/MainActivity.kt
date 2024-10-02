package br.com.natura.conecta

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.datastore.preferences.core.edit
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.natura.conecta.extensions.loginDataStore
import br.com.natura.conecta.extensions.onBoardingDataStore
import br.com.natura.conecta.extensions.onBoardingPreferences
import br.com.natura.conecta.extensions.userPreferences
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.sampledata.isCommunityLoaded
import br.com.natura.conecta.sampledata.isHomeLoaded
import br.com.natura.conecta.sampledata.isShopLoaded
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.sampledata.sampleProducts
import br.com.natura.conecta.ui.navigation.AppDestination
import br.com.natura.conecta.ui.navigation.bottomNavBarItems
import br.com.natura.conecta.ui.screens.CartScreen
import br.com.natura.conecta.ui.screens.CheckoutScreen
import br.com.natura.conecta.ui.screens.ClosedCartScreen
import br.com.natura.conecta.ui.screens.CommunityScreen
import br.com.natura.conecta.ui.screens.HomeScreen
import br.com.natura.conecta.ui.screens.LevelsScreen
import br.com.natura.conecta.ui.screens.LoginScreen
import br.com.natura.conecta.ui.screens.MapScreen
import br.com.natura.conecta.ui.screens.OrderDetailsScreen
import br.com.natura.conecta.ui.screens.OrderFinishedScreen
import br.com.natura.conecta.ui.screens.OrderListScreen
import br.com.natura.conecta.ui.screens.ProductDetailsScreen
import br.com.natura.conecta.ui.screens.RankScreen
import br.com.natura.conecta.ui.screens.ShopScreen
import br.com.natura.conecta.ui.screens.SplashScreen
import br.com.natura.conecta.ui.screens.WelcomeScreen
import br.com.natura.conecta.ui.screens.shimmers.CommunityScreenShimmer
import br.com.natura.conecta.ui.screens.shimmers.HomeScreenShimmer
import br.com.natura.conecta.ui.screens.shimmers.ShopScreenShimmer
import br.com.natura.conecta.ui.screens.sidebar.AboutScreen
import br.com.natura.conecta.ui.screens.sidebar.HelpScreen
import br.com.natura.conecta.ui.screens.sidebar.NotificationsScreen
import br.com.natura.conecta.ui.screens.sidebar.OrdersScreen
import br.com.natura.conecta.ui.screens.sidebar.ProfileScreen
import br.com.natura.conecta.ui.screens.sidebar.SettingsScreen
import br.com.natura.conecta.ui.theme.ConectaTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var locationPermissionGranted by mutableStateOf(false)

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            locationPermissionGranted = it
        }

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val navController = rememberNavController()
            val context = LocalContext.current
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            var userLogged by remember { mutableStateOf(false) }
            val sheetState = rememberStandardBottomSheetState(
                initialValue = SheetValue.Hidden,
                skipHiddenState = false
            )

            DisposableEffect(systemUiController, currentDestination) {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = currentDestination?.route != AppDestination.Login.route &&
                            currentDestination?.route != AppDestination.Profile.route
                )

                onDispose {}
            }

            ConectaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val itemSelected by remember(currentDestination) {
                        val item = currentDestination?.let { destination ->
                            bottomNavBarItems.find {
                                it.destination.route == destination.route
                            }
                        } ?: bottomNavBarItems.first()
                        mutableStateOf(item)
                    }
                    val showBottomBar = currentDestination?.let {
                        bottomNavBarItems.find {
                            it.destination.route == currentDestination.route && userLogged
                                    && sheetState.targetValue != SheetValue.Expanded
                                    && sheetState.currentValue != SheetValue.Expanded
                        }
                    } != null
                    val enableDrawer = currentDestination?.route == AppDestination.Home.route
                    ConectaApp(
                        bottomAppBarItemSelected = itemSelected,
                        showBottomBar = showBottomBar,
                        drawerState = drawerState,
                        enableDrawer = enableDrawer,
                        sheetState = sheetState,
                        onLogout = {
                            userLogged = false
                            isHomeLoaded = false
                            isShopLoaded = false
                            isCommunityLoaded = false
                            scope.launch {
                                context.loginDataStore.edit {
                                    it.remove(userPreferences)
                                }
                            }
                            navController.navigate(AppDestination.Login.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                            }
                        },
                        onDrawerItemClick = {
                            navController.navigate(it.route)
                        },
                        onNavigateToProfile = {
                            navController.navigate(AppDestination.Profile.route)
                        },
                        onBottomAppBarItemSelectedChange = {
                            val route = it.destination.route
                            if (route != (currentDestination?.route ?: false)) {
                                navController.navigate(route) {
                                    launchSingleTop = true
                                    popUpTo(route)
                                }
                            }
                        }   
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = AppDestination.Splash.route
                        ) {
                            composable(AppDestination.Welcome.route) {
                                WelcomeScreen(
                                    onNavigateToLogin = {
                                        scope.launch {
                                            context.onBoardingDataStore.edit {
                                                it[onBoardingPreferences] = true
                                            }
                                        }
                                        navController.popBackStack()
                                        navController.navigate(AppDestination.Home.route)
                                    }
                                )
                            }
                            composable(AppDestination.Splash.route) {
                                var isOnBoardingFinished: Boolean by remember { mutableStateOf(false) }

                                LaunchedEffect(Unit) {
                                    val dataStore = context.onBoardingDataStore.data.first()
                                    isOnBoardingFinished = dataStore[onBoardingPreferences] ?: false

                                    delay(4000)
                                    navController.popBackStack()
                                    val destination = if (isOnBoardingFinished) AppDestination.Home.route else AppDestination.Welcome.route
                                    navController.navigate(destination)
                                }
                                SplashScreen()
                            }
                            composable(AppDestination.Login.route) {
                                LoginScreen(
                                    onEnterClick = { user ->
                                        scope.launch {
                                            context.loginDataStore.edit {
                                                it[userPreferences] = user
                                            }
                                        }
                                        navController.navigate(AppDestination.Home.route) {
                                            popUpTo(navController.graph.id)
                                        }
                                    }
                                )
                            }
                            composable(AppDestination.Home.route) {
                                var user: String? by remember { mutableStateOf(null) }
                                var dataState by remember { mutableStateOf(false) }
                                LaunchedEffect(Unit) {
                                    user = context.loginDataStore.data.first()[userPreferences]
                                    dataState = true
                                }
                                if (isHomeLoaded) {
                                    HomeScreen(
                                        onOpenDrawerBar = {
                                            scope.launch {
                                                drawerState.open()
                                            }
                                        },
                                        onNavigateToLevels = {
                                            navController.navigate(AppDestination.Levels.route)
                                        }
                                    )
                                } else if (dataState) {
                                    user?.let {
                                        var isLoaded by remember { mutableStateOf(isHomeLoaded) }

                                        if (isLoaded) {
                                            HomeScreen(
                                                onOpenDrawerBar = {
                                                    scope.launch {
                                                        drawerState.open()
                                                    }
                                                },
                                                onNavigateToLevels = {
                                                    navController.navigate(AppDestination.Levels.route)
                                                }
                                            )
                                        } else {
                                            HomeScreenShimmer()
                                            LaunchedEffect(Unit) {
                                                delay(3000)
                                                isHomeLoaded = true
                                                isLoaded = true
                                            }
                                        }
                                        LaunchedEffect(Unit) {
                                            userLogged = true
                                        }
                                    } ?: LaunchedEffect(null) {
                                        navController.navigate(AppDestination.Login.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                }
                            }
                            composable(AppDestination.Map.route) {
                                LaunchedEffect(Unit) {
                                    sheetState.hide()
                                }
                                if (locationPermissionGranted) {
                                    MapScreen(
                                        sheetState = sheetState,
                                        onMarkerClick = {
                                            scope.launch {
                                                sheetState.expand()
                                            }
                                        },
                                        onNavigateToOrderList = {
                                            navController.navigate("${AppDestination.OrderList.route}/${it.name}")
                                        }
                                    )
                                } else {
                                    Box(
                                        Modifier
                                            .fillMaxSize()
                                            .background(Color.White)) {}
                                    requestPermissionsLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                                }
                            }
                            composable(AppDestination.Shop.route) {
                                var isLoaded by remember { mutableStateOf(isShopLoaded) }

                                if (isLoaded) {
                                    ShopScreen(
                                        onNavigateToCart = {
                                            navController.navigate(AppDestination.Cart.route)
                                        },
                                        onNavigateToProductDetails = { product ->
                                            navController.navigate("${AppDestination.ProductDetails.route}/${product.id}")
                                        }
                                    )
                                } else {
                                    ShopScreenShimmer()
                                    LaunchedEffect(Unit) {
                                        delay(1750)
                                        isShopLoaded = true
                                        isLoaded = true
                                    }
                                }
                            }
                            composable(AppDestination.Community.route) {
                                var isLoaded by remember { mutableStateOf(isCommunityLoaded) }

                                if (isLoaded) {
                                    CommunityScreen(
                                        onNavigateToRank = {
                                            navController.navigate(AppDestination.Rank.route)
                                        }
                                    )
                                } else {
                                    CommunityScreenShimmer()
                                    LaunchedEffect(Unit) {
                                        delay(1750)
                                        isCommunityLoaded = true
                                        isLoaded = true
                                    }
                                }
                            }
                            composable(AppDestination.Rank.route) {
                                RankScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    },
                                    onNavigateToLevels = {
                                        navController.navigate(AppDestination.Levels.route)
                                    }
                                )
                            }
                            composable(AppDestination.Cart.route) {
                                CartScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    },
                                    onNavigateToClosedCart = {
                                        navController.navigate(AppDestination.ClosedCart.route)
                                    },
                                    onNavigateToProductDetails = { product ->
                                        navController.navigate("${AppDestination.ProductDetails.route}/${product.id}")
                                    }
                                )
                            }
                            composable("${AppDestination.OrderList.route}/{orderType}") { backStackEntry ->

                                val orderTypeString = backStackEntry.arguments?.getString("orderType")
                                val orderType = orderTypeString?.let { OrderType.valueOf(it) }

                                OrderListScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    },
                                    onNavigateToOrderDetails = {
                                        navController.navigate("${AppDestination.OrderDetails.route}/${it.id}")
                                    },
                                    orderType = orderType!!
                                )
                            }
                            composable(AppDestination.ClosedCart.route) {
                                ClosedCartScreen(
                                    onNavigateToMap = {
                                        navController.navigate(AppDestination.Map.route)
                                    }
                                )
                            }
                            composable("${AppDestination.OrderDetails.route}/{orderId}") { backStackEntry ->
                                val orderId = backStackEntry.arguments?.getString("orderId")
                                sampleOrders.find { order ->
                                    order.id == orderId
                                }?.let {
                                    OrderDetailsScreen(
                                        order = it,
                                        onNavigateToCheckout = {
                                            navController.navigate(AppDestination.Checkout.route)
                                        },
                                        onNavigateBack = {
                                            navController.navigateUp()
                                        }
                                    )
                                } ?: LaunchedEffect(Unit) {
                                    navController.navigateUp()
                                }
                            }
                            composable(AppDestination.Checkout.route) {
                                CheckoutScreen(
                                    onNavigateBack = {
                                        navController.popBackStack()
                                    },
                                    onOrderFinished = {
                                        navController.navigate(AppDestination.OrderFinished.route)
                                    }
                                )
                            }
                            composable(AppDestination.OrderFinished.route) {
                                LaunchedEffect(Unit) {
                                    sheetState.hide()
                                }
                                OrderFinishedScreen(
                                    onNavigateToHome = {
                                        navController.navigate(AppDestination.Home.route)
                                    },
                                    onNavigateToShop = {
                                        navController.navigate(AppDestination.Shop.route)
                                    }
                                )
                            }
                            composable("${AppDestination.ProductDetails.route}/{productId}") { backStackEntry ->
                                val id = backStackEntry.arguments?.getString("productId")

                                sampleProducts.find { it.id == id }?.let { product ->
                                    ProductDetailsScreen(
                                        product = product
                                    )
                                } ?: LaunchedEffect(Unit) {
                                    navController.navigateUp()
                                }
                            }
                            composable(AppDestination.About.route) {
                                AboutScreen()
                            }
                            composable(AppDestination.Profile.route) {
                                ProfileScreen(
                                    onNavigateToLevels = {
                                        navController.navigate(AppDestination.Levels.route)
                                    }
                                )
                            }
                            composable(AppDestination.Orders.route) {
                                OrdersScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(AppDestination.Settings.route) {
                                SettingsScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(AppDestination.Help.route) {
                                HelpScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(AppDestination.Notifications.route) {
                                NotificationsScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(AppDestination.Levels.route) {
                                LevelsScreen(
                                    onNavigateBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}