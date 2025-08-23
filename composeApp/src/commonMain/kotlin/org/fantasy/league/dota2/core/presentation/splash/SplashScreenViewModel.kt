package org.fantasy.league.dota2.core.presentation.splash

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.fantasy.league.dota2.core.common.GameStats
import org.fantasy.league.dota2.core.common.Heroes
import org.fantasy.league.dota2.core.common.Player
import org.fantasy.league.dota2.core.common.PlayerInfo
import org.fantasy.league.dota2.core.common.PlayerStats
import org.fantasy.league.dota2.core.common.Prefix
import org.fantasy.league.dota2.core.common.Role
import org.fantasy.league.dota2.core.common.Suffix
import org.fantasy.league.dota2.core.common.balancedHeroes
import org.fantasy.league.dota2.core.common.bestialHeroes
import org.fantasy.league.dota2.core.common.brawnyHeroes
import org.fantasy.league.dota2.core.common.cannyHeroes
import org.fantasy.league.dota2.core.common.celureanHeroes
import org.fantasy.league.dota2.core.common.crimsonHeroes
import org.fantasy.league.dota2.core.common.dashingHeroes
import org.fantasy.league.dota2.core.common.elementalHeroes
import org.fantasy.league.dota2.core.common.emeraldHeroes
import org.fantasy.league.dota2.core.common.hirsuteHeroes
import org.fantasy.league.dota2.core.common.otherwordlyHeroes
import kotlin.math.roundToInt

class SplashScreenViewModel: ViewModel() {
    private val _stats = MutableStateFlow<List<GameStats>>(emptyList())
    val stats: StateFlow<List<GameStats>> = _stats

    private val _playerStats = MutableStateFlow<MutableList<Pair<Player, PlayerStats?>>>(
        mutableListOf()
    )
    val playerStats: StateFlow<List<Pair<Player, PlayerStats?>>> = _playerStats

    fun addGameStats(gameStat: GameStats) {
        val newList = _stats.value.toMutableList().apply {
            add(gameStat)
        }
        _stats.value = newList
    }

    fun calculateStatsForPlayers() {
        Player.all.forEachIndexed { index, player ->
            val gameStatsWithPlayer = _stats.value.filter { statToFilter ->
                statToFilter.playerInfo.map { it.steamId }.contains(player.steamId)
            }

            val playerStatsDestinct = gameStatsWithPlayer.distinct()

            val deathsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.deaths ?: 0
                }

                val average = (1800 - (list.average() * 180))

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val deathsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.deaths ?: 0
                }

                val average = (1800 - (list.sorted().take(3).average() * 180))

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val killsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.kills ?: 0
                }

                val average = (list.average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val killsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.kills ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val creepsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.lastHits ?: 0
                }

                val average = (list.average() * 3)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val creepsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.lastHits ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 3)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val gpmAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.gpm ?: 0f
                }

                val average = (list.average() * 2)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val gpmTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.gpm ?: 0f
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 2)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val towersAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.towerKills ?: 0
                }

                val average = (list.average() * 340)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val towersTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.towerKills ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 340)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val madstonesAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.madstonesCollected ?: 0
                }

                val average = (list.average() * 19)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val madstonesTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.madstonesCollected ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 19)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val wardsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.wardsPlaced ?: 0
                }

                val average = (list.average() * 113)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val wardsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.wardsPlaced ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 113)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val campsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.campsStacked ?: 0
                }

                val average = (list.average() * 170)


                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val campsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.campsStacked ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 170)


                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val runesAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.runes ?: 0
                }

                val average = (list.average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val runesTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.runes ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val watchersAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.watchersTaken ?: 0
                }

                val average = (list.average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val watchersTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.watchersTaken ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 121)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val lotusesAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.lotusesGrabbed ?: 0
                }

                val average = (list.average() * 213)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val lotusesTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.lotusesGrabbed ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 213)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val roshanAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.roshanKills ?: 0
                }

                val average = (list.average() * 850)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val roshanTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.roshanKills ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 850)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val teamfightAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.teamfightParticipation ?: 0f
                }

                val average = (list.average() * 1895)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val teamfightTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.teamfightParticipation ?: 0f
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 1895)

                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val stunsAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.stuns ?: 0f
                }

                val average = (list.average() * 28)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val stunsTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.stuns ?: 0f
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 28)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val tormentorAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.tormentorKills ?: 0
                }

                val average = (list.average() * 850)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val tormentorTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.tormentorKills ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 850)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val courierAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.courierKills ?: 0
                }

                val average = (list.average() * 850)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val courierTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.courierKills ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 850)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val fbAverage = {
                val list = playerStatsDestinct.map {
                    if (it.playerInfo.find { it.steamId == player.steamId }?.firstBloodClaimed == true) 1 else 0
                }

                val average = (list.average() * 1700)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val fbTop = {
                val list = playerStatsDestinct.map {
                    if (it.playerInfo.find { it.steamId == player.steamId }?.firstBloodClaimed == true) 1 else 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 1700)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val smokesAverage = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.smokesUsed ?: 0
                }

                val average = (list.average() * 283)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val smokesTop = {
                val list = playerStatsDestinct.map {
                    it.playerInfo.find { it.steamId == player.steamId }?.smokesUsed ?: 0
                }

                val average = (list.sortedByDescending { it }.take(3).average() * 283)
                if (average.isNaN().not()) average.roundToInt() else -1
            }

            val heroIds = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.selectedHeroId
            }

            val isLastPick = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.isLastPick
            }

            val isFirstPick = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.isFirstPick
            }

            val heroLevelDP = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.heroTierDotaPlus
            }

            val dashingPrefix = {
                val dashingIds = dashingHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val covetedPrefix = {
                val hits = isLastPick.count { it ?: false }
                hits * 100.0 / isLastPick.size
            }

            val celureanPrefix = {
                val dashingIds = celureanHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val elementalPrefix = {
                val dashingIds = elementalHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val virtuosoPrefix = {
                val hits = heroLevelDP.count { (it ?: 0) >= 46850 }
                hits * 100.0 / heroLevelDP.size
            }

            val emeraldPrefix = {
                val dashingIds = emeraldHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val brawnyPrefix = {
                val dashingIds = brawnyHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val sacrificialPrefix = {
                val hits = isFirstPick.count { it ?: false }
                hits * 100.0 / isFirstPick.size
            }

            val otherwordlyPrefix = {
                val dashingIds = otherwordlyHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val hirsutePrefix = {
                val dashingIds = hirsuteHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val balancedPrefix = {
                val dashingIds = balancedHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val crimsonPrefix = {
                val dashingIds = crimsonHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val cannyPrefix = {
                val dashingIds = cannyHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val bestialPrefix = {
                val dashingIds = bestialHeroes.map { it.id }.toSet()
                val hits = heroIds.count { it in dashingIds }
                hits * 100.0 / heroIds.size
            }

            val isFbBeforeHorn = playerStatsDestinct.map {
                it.fbBeforeHorn
            }

            val isDecisive = playerStatsDestinct.map {
                it.lessThan25min
            }

            val isNorthPiligrim = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.theMostDeaths
            }

            val isTheBull = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.isBoughtBackBefore30
            }

            val isPacifist = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.kills == 0
            }

            val isAccomplice = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.theMostAssists
            }

            val isRaven = playerStatsDestinct.map {
                it.isRampageInGame
            }

            val isAnt = playerStatsDestinct.map {
                it.playerInfo.find { it.steamId == player.steamId }?.theLowestNetworth
            }

            val isPatient = playerStatsDestinct.map {
                it.fbAfter10min
            }

            val flayedAcolyteSuffix = {
                val hits = isFbBeforeHorn.count { it }
                hits * 100.0 / isFbBeforeHorn.size
            }

            val decisiveSuffix = {
                val hits = isDecisive.count { it }
                hits * 100.0 / isDecisive.size
            }

            val northPiligrimSuffix = {
                val hits = isNorthPiligrim.count { it ?: false }
                hits * 100.0 / isNorthPiligrim.size
            }

            val theBullSuffix = {
                val hits = isTheBull.count { it ?: false }
                hits * 100.0 / isTheBull.size
            }

            val pacifistSuffix = {
                val hits = isPacifist.count { it }
                hits * 100.0 / isPacifist.size
            }

            val accompliceSuffix = {
                val hits = isAccomplice.count { it ?: false }
                hits * 100.0 / isAccomplice.size
            }

            val ravenSuffix = {
                val hits = isRaven.count { it }
                hits * 100.0 / isRaven.size
            }

            val antSuffix = {
                val hits = isAnt.count { it ?: false }
                hits * 100.0 / isAnt.size
            }

            val patientSuffix = {
                val hits = isPatient.count { it }
                hits * 100.0 / isPatient.size
            }

            _playerStats.value.add(
                player to PlayerStats(
                    killsAverage = killsAverage.invoke(),
                    killsTop = killsTop.invoke(),
                    deathsAverage = deathsAverage.invoke(),
                    deathsTop = deathsTop.invoke(),
                    creepsAverage = creepsAverage.invoke(),
                    creepsTop = creepsTop.invoke(),
                    gpmAverage = gpmAverage.invoke(),
                    gpmTop = gpmTop.invoke(),
                    towersAverage = towersAverage.invoke(),
                    towersTop = towersTop.invoke(),
                    wardsAverage = wardsAverage.invoke(),
                    wardsTop = wardsTop.invoke(),
                    campsAverage = campsAverage.invoke(),
                    campsTop = campsTop.invoke(),
                    runesAverage = runesAverage.invoke(),
                    runesTop = runesTop.invoke(),
                    watchersAverage = watchersAverage.invoke(),
                    watchersTop = watchersTop.invoke(),
                    lotusesAverage = lotusesAverage.invoke(),
                    lotusesTop = lotusesTop.invoke(),
                    roshanAverage = roshanAverage.invoke(),
                    roshanTop = roshanTop.invoke(),
                    teamfightAverage = teamfightAverage.invoke(),
                    teamfightTop = teamfightTop.invoke(),
                    stunsAverage = stunsAverage.invoke(),
                    stunsTop = stunsTop.invoke(),
                    tormentorAverage = tormentorAverage.invoke(),
                    tormentorTop = tormentorTop.invoke(),
                    courierAverage = courierAverage.invoke(),
                    courierTop = courierTop.invoke(),
                    madstoneAverage = madstonesAverage.invoke(),
                    madstoneTop = madstonesTop.invoke(),
                    fbAverage = fbAverage.invoke(),
                    fbTop = fbTop.invoke(),
                    smokesAverage = smokesAverage.invoke(),
                    smokesTop = smokesTop.invoke(),
                    dashingPrefix = Prefix.Dashing to dashingPrefix.invoke(),
                    covetedPrefix = Prefix.Coveted to covetedPrefix.invoke(),
                    elementalPrefix = Prefix.Elemental to elementalPrefix.invoke(),
                    ceruleanPrefix = Prefix.Cerulean to celureanPrefix.invoke(),
                    virtuosoPrefix = Prefix.Virtuoso to virtuosoPrefix.invoke(),
                    emeraldPrefix = Prefix.Emerald to emeraldPrefix.invoke(),
                    brawnyPrefix = Prefix.Brawny to brawnyPrefix.invoke(),
                    sacrificialPrefix = Prefix.Sacrificial to sacrificialPrefix.invoke(),
                    otherworldlyPrefix = Prefix.Otherworldly to otherwordlyPrefix.invoke(),
                    hirsutePrefix = Prefix.Hirsute to hirsutePrefix.invoke(),
                    balancedPrefix = Prefix.Balanced to balancedPrefix.invoke(),
                    crimsonPrefix = Prefix.Crimson to crimsonPrefix.invoke(),
                    cannyPrefix = Prefix.Canny to cannyPrefix.invoke(),
                    bestialPrefix = Prefix.Bestial to bestialPrefix.invoke(),
                    decisiveSuffix = Suffix.TheDecisive to decisiveSuffix.invoke(),
                    northPiligrimSuffix = Suffix.TheNorthPilgrim to northPiligrimSuffix.invoke(),
                    bullSuffix = Suffix.OfTheBull to theBullSuffix.invoke(),
                    pacifistSuffix = Suffix.ThePacifist to pacifistSuffix.invoke(),
                    accomplianceSuffix = Suffix.TheAccomplice to accompliceSuffix.invoke(),
                    flayedTwinsSuffix = Suffix.TheFlayedTwinsAcolyte to flayedAcolyteSuffix.invoke(),
                    ravenSuffix = Suffix.OfTheRaven to ravenSuffix.invoke(),
                    antSuffix = Suffix.OfTheAnt to antSuffix.invoke(),
                    patientSuffix = Suffix.ThePatient to patientSuffix.invoke(),
                )
            )
        }
    }
}