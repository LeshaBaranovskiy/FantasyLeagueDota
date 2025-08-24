package org.fantasy.league.dota2.stats.presentation.all_stats

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        playerStats.value
    )
}

@Composable
fun AllStatsScreen(
    playerStats: List<Pair<Player, PlayerStats?>>
) {
    var roleSelected by remember {
        mutableStateOf(Role.CORE)
    }

    var playerStatsSorted by remember(playerStats) {
        mutableStateOf(playerStats)
    }

    val scrollState = rememberLazyListState()

    LaunchedEffect(roleSelected) {
        playerStatsSorted = when(roleSelected) {
            Role.CORE -> {
                playerStats.filter { it.first.role == Role.CORE }.sortedByDescending { it.second?.averageAverageCore() }
            }
            Role.MID -> {
                playerStats.filter { it.first.role == Role.MID }.sortedByDescending { it.second?.averageAverageAll() }
            }
            Role.SUPPORT -> {
                playerStats.filter { it.first.role == Role.SUPPORT }.sortedByDescending { it.second?.averageAverageSupp() }
            }
        }
    }

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    GlobalScope.launch(Dispatchers.Main) {
                        scrollState.scrollBy(delta)
                    }
                },
            ),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            roleSelected = Role.CORE
                        }
                        .background(
                            color = if (roleSelected == Role.CORE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "Core",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = if (roleSelected == Role.CORE) Color.White else Color.Black
                        ),
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            roleSelected = Role.MID
                        }
                        .background(
                            color = if (roleSelected == Role.MID) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "Mid",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = if (roleSelected == Role.MID) Color.White else Color.Black
                        ),
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            roleSelected = (Role.SUPPORT)
                        }
                        .background(
                            color = if (roleSelected == Role.SUPPORT) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "Support",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = if (roleSelected == Role.SUPPORT) Color.White else Color.Black
                        ),
                    )
                }
            }
        }

        items(playerStatsSorted) { stats ->
            PlayerCard(
                stats
            )
        }
    }
}