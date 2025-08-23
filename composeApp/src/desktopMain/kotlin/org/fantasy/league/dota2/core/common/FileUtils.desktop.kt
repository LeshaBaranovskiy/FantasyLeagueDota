package org.fantasy.league.dota2.core.common

import kotlinx.serialization.json.Json

actual fun loadGameStats(fileName: String): GameStats? {
    val json = object {}.javaClass.getResource("/$fileName.json")?.readText()
        ?: error("File not found: $fileName.json")
    return Json.decodeFromString(json)
}

actual fun jsonFileExists(filename: String): Boolean {
    return object {}.javaClass.getResource("/$filename.json") != null
}