package org.fantasy.league.dota2.core.common

data class CalculatorPlayerStats(
    val playerAverageScore: Float,
    val playerTopScore: Float,
    val playerStats: Pair<Player, PlayerStats?>
)