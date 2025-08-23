package org.fantasy.league.dota2.core.common

data class PlayerStats(
    val killsAverage: Int,
    val killsTop: Int,
    val deathsAverage: Int,
    val deathsTop: Int,
    val creepsAverage: Int,
    val creepsTop: Int,
    val gpmAverage: Int,
    val gpmTop: Int,
    val towersAverage: Int,
    val towersTop: Int,
    val wardsAverage: Int,
    val wardsTop: Int,
    val campsAverage: Int,
    val campsTop: Int,
    val runesAverage: Int,
    val runesTop: Int,
    val watchersAverage: Int,
    val watchersTop: Int,
    val lotusesAverage: Int,
    val lotusesTop: Int,
    val roshanAverage: Int,
    val roshanTop: Int,
    val teamfightAverage: Int,
    val teamfightTop: Int,
    val stunsAverage: Int,
    val stunsTop: Int,
    val madstoneAverage: Int,
    val madstoneTop: Int,
    val tormentorAverage: Int,
    val tormentorTop: Int,
    val courierAverage: Int,
    val courierTop: Int,
    val fbAverage: Int,
    val fbTop: Int,
    val smokesAverage: Int,
    val smokesTop: Int,
    val dashingPrefix: Pair<Prefix, Double>,
    val covetedPrefix: Pair<Prefix, Double>,
    val elementalPrefix: Pair<Prefix, Double>,
    val ceruleanPrefix: Pair<Prefix, Double>,
    val virtuosoPrefix: Pair<Prefix, Double>,
    val emeraldPrefix: Pair<Prefix, Double>,
    val brawnyPrefix: Pair<Prefix, Double>,
    val sacrificialPrefix: Pair<Prefix, Double>,
    val otherworldlyPrefix: Pair<Prefix, Double>,
    val hirsutePrefix: Pair<Prefix, Double>,
    val balancedPrefix: Pair<Prefix, Double>,
    val crimsonPrefix: Pair<Prefix, Double>,
    val cannyPrefix: Pair<Prefix, Double>,
    val bestialPrefix: Pair<Prefix, Double>,
    //Suffix
    val decisiveSuffix: Pair<Suffix, Double>,
    val northPiligrimSuffix: Pair<Suffix, Double>,
    val bullSuffix: Pair<Suffix, Double>,
    val pacifistSuffix: Pair<Suffix, Double>,
    val accomplianceSuffix: Pair<Suffix, Double>,
    val flayedTwinsSuffix: Pair<Suffix, Double>,
    val ravenSuffix: Pair<Suffix, Double>,
    val antSuffix: Pair<Suffix, Double>,
    val patientSuffix: Pair<Suffix, Double>,
)

fun PlayerStats.averageAverageAll(): Double {
    val values = listOf(
        killsAverage,
        deathsAverage,
        creepsAverage,
        gpmAverage,
        towersAverage,
        wardsAverage,
        campsAverage,
        runesAverage,
        watchersAverage,
        lotusesAverage,
        roshanAverage,
        teamfightAverage,
        stunsAverage,
        madstoneAverage,
        tormentorAverage,
        courierAverage,
        fbAverage,
        smokesAverage
    )
    return values.average()
}

fun PlayerStats.averageAverageCore(): Double {
    val values = listOf(
        killsAverage,
        deathsAverage,
        creepsAverage,
        gpmAverage,
        towersAverage,
        roshanAverage,
        teamfightAverage,
        stunsAverage,
        madstoneAverage,
        tormentorAverage,
        courierAverage,
        fbAverage,
    )
    return values.average()
}

fun PlayerStats.averageAverageSupp(): Double {
    val values = listOf(
        wardsAverage,
        campsAverage,
        runesAverage,
        watchersAverage,
        lotusesAverage,
        roshanAverage,
        teamfightAverage,
        stunsAverage,
        tormentorAverage,
        courierAverage,
        fbAverage,
        smokesAverage
    )
    return values.average()
}

fun PlayerStats.averageTopCore(): Double {
    val values = listOf(
        killsTop,
        deathsTop,
        creepsTop,
        gpmTop,
        towersTop,
        roshanTop,
        teamfightTop,
        stunsTop,
        madstoneTop,
        tormentorTop,
        courierTop,
        fbTop,
    )
    return values.average()
}

fun PlayerStats.averageTopAll(): Double {
    val values = listOf(
        killsTop,
        deathsTop,
        creepsTop,
        gpmTop,
        towersTop,
        wardsTop,
        campsTop,
        runesTop,
        watchersTop,
        lotusesTop,
        roshanTop,
        teamfightTop,
        stunsTop,
        madstoneTop,
        tormentorTop,
        courierTop,
        fbTop,
        smokesTop
    )
    return values.average()
}

fun PlayerStats.averageTopSupp(): Double {
    val values = listOf(
        wardsTop,
        campsTop,
        runesTop,
        watchersTop,
        lotusesTop,
        roshanTop,
        teamfightTop,
        stunsTop,
        tormentorTop,
        courierTop,
        fbTop,
        smokesTop
    )
    return values.average()
}

fun PlayerStats.prefixes(): List<Pair<Prefix, Double>> {
    val values = listOf(
        dashingPrefix, covetedPrefix, elementalPrefix, ceruleanPrefix, virtuosoPrefix, emeraldPrefix, brawnyPrefix, sacrificialPrefix, otherworldlyPrefix, hirsutePrefix, balancedPrefix, crimsonPrefix, cannyPrefix, bestialPrefix
    )
    return values
}

fun PlayerStats.suffixes(): List<Pair<Suffix, Double>> {
    val values = listOf(
        decisiveSuffix, northPiligrimSuffix, bullSuffix, pacifistSuffix, accomplianceSuffix, flayedTwinsSuffix, ravenSuffix, antSuffix, patientSuffix
    )
    return values
}