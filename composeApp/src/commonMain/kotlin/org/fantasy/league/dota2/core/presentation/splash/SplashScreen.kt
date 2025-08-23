package org.fantasy.league.dota2.core.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import fantasyleaguedota.composeapp.generated.resources.Res
import fantasyleaguedota.composeapp.generated.resources.ic_international
import kotlinx.coroutines.delay
import org.fantasy.league.dota2.core.common.loadGameStats
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreenRoot(
    splashScreenViewModel: SplashScreenViewModel = koinViewModel(),
    redirect: () -> Unit,
) {
    LaunchedEffect(true) {
        for (i in 1..473) {
            val stats = loadGameStats(
                "${i}"
            )
            if (stats != null) {
                splashScreenViewModel.addGameStats(stats)
            }
        }
        delay(1000L)
        splashScreenViewModel.calculateStatsForPlayers()
        delay(1000L)
        redirect.invoke()
    }

    SplashScreen()
}

@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 36.dp)
    ) {
        Image(
            painter = painterResource(
                resource = Res.drawable.ic_international
            ),
            contentScale = ContentScale.FillWidth,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}