package org.fantasy.league.dota2

import android.app.Application
import org.fantasy.league.dota2.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@Application)
        }
    }
}