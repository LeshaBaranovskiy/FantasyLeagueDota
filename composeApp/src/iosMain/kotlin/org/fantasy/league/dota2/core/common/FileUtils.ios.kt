package org.fantasy.league.dota2.core.common

import kotlinx.serialization.json.Json
import platform.Foundation.NSBundle
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataWithContentsOfFile

actual fun loadGameStats(fileName: String): GameStats? {
    val path = NSBundle.mainBundle.pathForResource(name = fileName, ofType = "json")
        ?: error("File not found in bundle: $fileName.json")
    val data = NSData.dataWithContentsOfFile(path)
        ?: error("Can't read file $fileName.json")
    val json = NSString.create(data, NSUTF8StringEncoding) as String
    return Json.decodeFromString(json)
}

actual fun jsonFileExists(filename: String): Boolean {
    return NSBundle.mainBundle.pathForResource(name = filename, ofType = "json") != null
}