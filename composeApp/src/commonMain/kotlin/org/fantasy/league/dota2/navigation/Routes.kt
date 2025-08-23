package org.fantasy.league.dota2.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object FantasyLeagueGraph: Routes

    @Serializable
    data object StatsScreen: Routes

    @Serializable
    data object MyEmblemsScreen: Routes

    @Serializable
    data object SplashScreen: Routes
}