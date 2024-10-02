package br.com.natura.conecta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.BottomAppBarItem
import br.com.natura.conecta.ui.navigation.AppDestination
import br.com.natura.conecta.ui.navigation.ConectaBottomNavBar
import br.com.natura.conecta.ui.navigation.bottomNavBarItems
import br.com.natura.conecta.ui.navigation.drawerBarItems
import br.com.natura.conecta.ui.theme.ConectaTheme
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.PinkOrange
import br.com.natura.conecta.ui.theme.SoftGray
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConectaApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomNavBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    showBottomBar: Boolean = true,
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    onLogout: () -> Unit = {},
    onDrawerItemClick: (AppDestination) -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    enableDrawer: Boolean = false,
    sheetState: SheetState = rememberStandardBottomSheetState(),
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            ModalNavigationDrawer(
                drawerState = drawerState,
                gesturesEnabled = enableDrawer,
                drawerContent = {
                    Column(
                        Modifier
                            .background(
                                color = SoftGray,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .systemBarsPadding(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ModalDrawerSheet(
                            drawerShape = RoundedCornerShape(15.dp),
                            drawerContainerColor = SoftGray,
                            drawerTonalElevation = 5.dp,
                            modifier = Modifier.fillMaxWidth(0.60f)
                        ) {
                            Spacer(modifier = Modifier.height(30.dp))
                            Row(
                                modifier = Modifier
                                    .padding(NavigationDrawerItemDefaults.ItemPadding)
                                    .fillMaxWidth()
                                    .clickable {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        onNavigateToProfile()
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Image(painter = painterResource(id = R.drawable.consultant_user_photo),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                                Column(
                                    horizontalAlignment = Alignment.End
                                ) {
                                    Text(
                                        text = "Helena Dias",
                                        color = Color.Black,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Consultora Semente",
                                        color = DarkGray,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                            Spacer(modifier = Modifier
                                .padding(vertical = 20.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Color(0xFFDCDCDC))
                                .fillMaxWidth(0.80f)
                                .height(2.dp)
                                .align(Alignment.CenterHorizontally)
                            )
                            drawerBarItems.forEachIndexed { index, item ->
                                NavigationDrawerItem(
                                    label = {
                                        Text(
                                            text = item.name,
                                            color = Color.Black,
                                            fontSize = 18.sp
                                        )
                                    },
                                    selected = index == selectedItemIndex,
                                    onClick = {
                                        selectedItemIndex = index
                                        onDrawerItemClick(item.route)
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = item.icon),
                                            contentDescription = null,
                                            tint = PinkOrange,
                                            modifier = Modifier.size(40.dp)
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(NavigationDrawerItemDefaults.ItemPadding)
                                        .padding(bottom = 15.dp),
                                    colors = NavigationDrawerItemDefaults.colors(
                                        selectedContainerColor = SoftGray,
                                        unselectedContainerColor = SoftGray
                                    )
                                )
                            }
                            Spacer(modifier = Modifier
                                .padding(top = 5.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Color(0xFFDCDCDC))
                                .fillMaxWidth(0.80f)
                                .height(2.dp)
                                .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            NavigationDrawerItem(
                                label = {
                                    Text(
                                        text = "Sair",
                                        color = Color.Black,
                                        fontSize = 18.sp
                                    )
                                },
                                selected = false,
                                onClick = {
                                    scope.launch {
                                        onLogout()
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_logout),
                                        contentDescription = null,
                                        tint = PinkOrange,
                                        modifier = Modifier.size(40.dp)
                                    )
                                },
                                modifier = Modifier
                                    .padding(NavigationDrawerItemDefaults.ItemPadding)
                                    .padding(bottom = 22.dp),
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = SoftGray,
                                    unselectedContainerColor = SoftGray
                                )
                            )
                        }
                    }
                }
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Scaffold(contentWindowInsets = WindowInsets(0.dp)) {
                        Box(modifier = Modifier.padding(it)) {
                            content()

                            if (showBottomBar) {
                                ConectaBottomNavBar(
                                    item = bottomAppBarItemSelected,
                                    items = bottomNavBarItems,
                                    onItemChange = onBottomAppBarItemSelectedChange,
                                    sheetState = sheetState,
                                    modifier = Modifier
                                        .padding(bottom = 22.dp)
                                        .align(Alignment.BottomCenter)
                                        .navigationBarsPadding()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ConectaAppPreview() {
    ConectaTheme {
        Surface {
            ConectaApp {}
        }
    }
}