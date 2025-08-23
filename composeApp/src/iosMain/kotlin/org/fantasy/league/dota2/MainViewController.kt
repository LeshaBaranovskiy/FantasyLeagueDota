package org.fantasy.league.dota2

import androidx.compose.ui.window.ComposeUIViewController
import org.fantasy.league.dota2.di.initKoin
import org.fantasy.league.dota2.navigation.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}