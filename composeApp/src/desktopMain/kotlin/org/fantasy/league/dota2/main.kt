package org.fantasy.league.dota2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.fantasy.league.dota2.di.initKoin
import org.fantasy.league.dota2.navigation.App

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "FantasyLeagueDota",
    ) {
        App()
    }
}