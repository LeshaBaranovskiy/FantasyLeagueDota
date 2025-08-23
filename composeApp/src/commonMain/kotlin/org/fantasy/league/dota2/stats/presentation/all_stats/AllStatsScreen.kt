package org.fantasy.league.dota2.stats.presentation.all_stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.fantasy.league.dota2.core.common.GameStats
import org.fantasy.league.dota2.core.common.Player
import org.fantasy.league.dota2.core.common.PlayerStats
import org.fantasy.league.dota2.core.common.Role
import org.fantasy.league.dota2.core.common.averageAverageAll
import org.fantasy.league.dota2.core.common.averageAverageCore
import org.fantasy.league.dota2.core.common.averageAverageSupp
import org.fantasy.league.dota2.core.presentation.splash.SplashScreenViewModel
import org.fantasy.league.dota2.stats.presentation.components.PlayerCard
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AllStatsScreenRoot(
    splashScreenViewModel: SplashScreenViewModel = koinViewModel(),
) {
    val playerStats = splashScreenViewModel.playerStats

    AllStatsScreen(
        playerStats.value.filter { it.first.role == Role.CORE }.sortedByDescending { it.second?.averageAverageCore() }
    )
}

@Composable
fun AllStatsScreen(
    playerStats: List<Pair<Player, PlayerStats?>>
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(playerStats) { stats ->
            PlayerCard(
                stats
            )
        }
    }
}