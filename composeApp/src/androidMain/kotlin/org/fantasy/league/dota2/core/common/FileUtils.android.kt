package org.fantasy.league.dota2.core.common

import android.content.Context
import kotlinx.serialization.json.Json

lateinit var appContext: Context

actual fun loadGameStats(fileName: String): GameStats? {
    if (jsonFileExists(fileName)) {
        val json = appContext.assets.open("$fileName.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(json)
    } else {
        return null
    }
}

actual fun jsonFileExists(filename: String): Boolean {
    return try {
        appContext.assets.open("$filename.json").close()
        true
    } catch (e: Exception) {
        false
    }
}