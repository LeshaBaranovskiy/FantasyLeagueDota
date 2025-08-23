package org.fantasy.league.dota2.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.compose.FantasyLeagueTheme
import fantasyleaguedota.composeapp.generated.resources.Res
import fantasyleaguedota.composeapp.generated.resources.ic_emblem
import fantasyleaguedota.composeapp.generated.resources.ic_roshan
import fantasyleaguedota.composeapp.generated.resources.ic_stats
import kotlinx.coroutines.launch
import org.fantasy.league.dota2.core.presentation.splash.SplashScreen
import org.fantasy.league.dota2.core.presentation.splash.SplashScreenRoot
import org.fantasy.league.dota2.core.presentation.splash.SplashScreenViewModel
import org.fantasy.league.dota2.stats.presentation.all_stats.AllStatsScreen
import org.fantasy.league.dota2.stats.presentation.all_stats.AllStatsScreenRoot
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    FantasyLeagueTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        val showBottomBar = when(navController.currentBackStackEntryAsState().value?.destination?.route) {
            Routes.SplashScreen::class.qualifiedName -> false
            else -> true
        }

        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState) {
                    Snackbar(snackbarData = it)
                }
            },
            bottomBar = {
                if (showBottomBar) {
                    Column {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Color(0xFFEEEEEE)
                        )

                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface
                        ) {

                            NavigationBarItem(
                                icon = {
                                    Image(
                                        painter = painterResource(Res.drawable.ic_emblem),
                                        contentDescription = "My emblems",
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = "My emblems",
                                        fontSize = 12.sp,
                                        lineHeight = 14.sp,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                },
                                selected = false,
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {

                                }
                            )

                            NavigationBarItem(
                                icon = {
                                    Image(
                                        painter = painterResource(Res.drawable.ic_stats),
                                        contentDescription = "All stats",
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = "All stats",
                                        fontSize = 12.sp,
                                        lineHeight = 14.sp,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                },
                                selected = true,
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {

                                }
                            )
                        }
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Routes.FantasyLeagueGraph,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(
                            500
                        )
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(
                            500
                        )
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(
                            500
                        )
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(
                            500
                        )
                    )
                },
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
            ) {
                navigation<Routes.FantasyLeagueGraph>(
                    startDestination = Routes.SplashScreen,
                ) {
                    composable<Routes.SplashScreen> {
                        val viewModel = it.sharedKoinViewModel<SplashScreenViewModel>(navController)

                        SplashScreenRoot(
                            splashScreenViewModel = viewModel
                        ) {
                            navController.navigate(
                                Routes.StatsScreen
                            )
                        }
                    }
                    composable<Routes.MyEmblemsScreen> {
//                    val viewModel = koinViewModel<LoginViewModel>()
//
//                    LoginScreenRoot(
//                        viewModel = viewModel,
//                        onLoginResultRedirect = {
//
//                        },
//                        onSignUpClick = {
//                            navController.navigate(Routes.SignUpScreen)
//                        },
//                        onForgotPasswordClick = {},
//                        modifier = Modifier
//                    )
                    }

                    composable<Routes.StatsScreen> {
                        val viewModel = it.sharedKoinViewModel<SplashScreenViewModel>(navController)

                        AllStatsScreenRoot(
                            viewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}