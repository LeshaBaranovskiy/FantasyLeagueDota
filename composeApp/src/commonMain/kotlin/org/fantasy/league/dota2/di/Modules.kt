package org.fantasy.league.dota2.di

import org.fantasy.league.dota2.core.presentation.splash.SplashScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModules = module {

    viewModelOf(::SplashScreenViewModel)
}