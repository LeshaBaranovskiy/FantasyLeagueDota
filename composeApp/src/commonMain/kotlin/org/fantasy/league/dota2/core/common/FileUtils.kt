package org.fantasy.league.dota2.core.common


expect fun loadGameStats(fileName: String): GameStats?

expect fun jsonFileExists(filename: String): Boolean