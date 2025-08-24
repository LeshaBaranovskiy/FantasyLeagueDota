package org.fantasy.league.dota2.di

import org.fantasy.league.dota2.core.presentation.splash.SplashScreenViewModel
import org.fantasy.league.dota2.stats.presentation.my_emblems.MyEmblemsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModules = module {

    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::MyEmblemsViewModel)
}