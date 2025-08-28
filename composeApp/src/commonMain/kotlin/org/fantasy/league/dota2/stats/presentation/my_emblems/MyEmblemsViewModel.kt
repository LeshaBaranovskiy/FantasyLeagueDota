package org.fantasy.league.dota2.stats.presentation.my_emblems

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.fantasy.league.dota2.core.common.CalculatorPlayerStats
import org.fantasy.league.dota2.core.common.Emblems
import org.fantasy.league.dota2.core.common.Filter
import org.fantasy.league.dota2.core.common.Player
import org.fantasy.league.dota2.core.common.PlayerStats
import org.fantasy.league.dota2.core.common.Role

class MyEmblemsViewModel: ViewModel() {
    private val _playerStats = mutableStateOf<MutableList<Pair<Player, PlayerStats?>>>(
        mutableListOf()
    )
    val playerStats: State<List<Pair<Player, PlayerStats?>>> = _playerStats

    private val _selectedRole = mutableStateOf<Role>(Role.CORE)
    val selectedRole: State<Role> = _selectedRole

    private val _selectedFilter = mutableStateOf<Filter>(Filter.BY_AVERAGE)
    val selectedFilter: State<Filter> = _selectedFilter

    //Core
    private val _firstCoreRedEmblem = mutableStateOf<Emblems>(Emblems.Creeps)
    val firstCoreRedEmblem: State<Emblems> = _firstCoreRedEmblem

    private val _firstCoreRedEmblemPercent = mutableStateOf<Float?>(null)
    val firstCoreRedEmblemPercent: State<Float?> = _firstCoreRedEmblemPercent

    private val _secondCoreRedEmblem = mutableStateOf<Emblems>(Emblems.Deaths)
    val secondCoreRedEmblem: State<Emblems> = _secondCoreRedEmblem

    private val _secondCoreRedEmblemPercent = mutableStateOf<Float?>(null)
    val secondCoreRedEmblemPercent: State<Float?> = _secondCoreRedEmblemPercent

    private val _firstCoreGreenEmblem = mutableStateOf<Emblems>(Emblems.Teamfight)
    val firstCoreGreenEmblem: State<Emblems> = _firstCoreGreenEmblem

    private val _firstCoreGreenEmblemPercent = mutableStateOf<Float?>(null)
    val firstCoreGreenEmblemPercent: State<Float?> = _firstCoreGreenEmblemPercent

    private val _corePlayersStats = mutableStateOf<MutableList<CalculatorPlayerStats>>(mutableListOf())
    val corePlayersStats: State<List<CalculatorPlayerStats>> = _corePlayersStats

    //Mid
    private val _midRedEmblem = mutableStateOf<Emblems>(Emblems.Creeps)
    val midRedEmblem: State<Emblems> = _midRedEmblem

    private val _midRedEmblemPercent = mutableStateOf<Float?>(null)
    val midRedEmblemPercent: State<Float?> = _midRedEmblemPercent

    private val _midBlueEmblem = mutableStateOf<Emblems>(Emblems.Runes)
    val midBlueEmblem: State<Emblems> = _midBlueEmblem

    private val _midBlueEmblemPercent = mutableStateOf<Float?>(null)
    val midBlueEmblemPercent: State<Float?> = _midBlueEmblemPercent

    private val _midGreenEmblem = mutableStateOf<Emblems>(Emblems.Teamfight)
    val midGreenEmblem: State<Emblems> = _midGreenEmblem

    private val _midGreenEmblemPercent = mutableStateOf<Float?>(null)
    val midGreenEmblemPercent: State<Float?> = _midGreenEmblemPercent

    private val _midPlayersStats = mutableStateOf<MutableList<CalculatorPlayerStats>>(mutableListOf())
    val midPlayersStats: State<List<CalculatorPlayerStats>> = _midPlayersStats

    //Support
    private val _support1BlueEmblem = mutableStateOf<Emblems>(Emblems.Runes)
    val support1BlueEmblem: State<Emblems> = _support1BlueEmblem

    private val _support1BlueEmblemPercent = mutableStateOf<Float?>(null)
    val support1BlueEmblemPercent: State<Float?> = _support1BlueEmblemPercent

    private val _supportGreenEmblem = mutableStateOf<Emblems>(Emblems.Teamfight)
    val supportGreenEmblem: State<Emblems> = _supportGreenEmblem

    private val _supportGreenEmblemPercent = mutableStateOf<Float?>(null)
    val supportGreenEmblemPercent: State<Float?> = _supportGreenEmblemPercent

    private val _support2BlueEmblem = mutableStateOf<Emblems>(Emblems.Wards)
    val support2BlueEmblem: State<Emblems> = _support2BlueEmblem

    private val _support2BlueEmblemPercent = mutableStateOf<Float?>(null)
    val support2BlueEmblemPercent: State<Float?> = _support2BlueEmblemPercent

    private val _supportPlayersStats = mutableStateOf<MutableList<CalculatorPlayerStats>>(mutableListOf())
    val supportPlayersStats: State<List<CalculatorPlayerStats>> = _supportPlayersStats

    fun setAllPlayersStats(newPlayerStats: MutableList<Pair<Player, PlayerStats?>>) {
        _playerStats.value = newPlayerStats
    }

    private fun calculateEmblemAverage(emblem: Emblems, playerStats: PlayerStats, percent: Float): Float {
        return when(emblem) {
            Emblems.Courier -> {
                playerStats.courierAverage.toFloat() * (percent / 100)
            }
            Emblems.Creeps -> {
                playerStats.creepsAverage.toFloat() * (percent / 100)
            }
            Emblems.Deaths -> {
                playerStats.deathsAverage.toFloat() * (percent / 100)
            }
            Emblems.FirstBlood -> {
                playerStats.fbAverage.toFloat() * (percent / 100)
            }
            Emblems.GPM -> {
                playerStats.gpmAverage.toFloat() * (percent / 100)
            }
            Emblems.Kills -> {
                playerStats.killsAverage.toFloat() * (percent / 100)
            }
            Emblems.Lotuses -> {
                playerStats.lotusesAverage.toFloat() * (percent / 100)
            }
            Emblems.Madstones -> {
                playerStats.madstoneAverage.toFloat() * (percent / 100)
            }
            Emblems.Roshan -> {
                playerStats.roshanAverage.toFloat() * (percent / 100)
            }
            Emblems.Runes -> {
                playerStats.runesAverage.toFloat() * (percent / 100)
            }
            Emblems.Smokes -> {
                playerStats.smokesAverage.toFloat() * (percent / 100)
            }
            Emblems.Stacks -> {
                playerStats.campsAverage.toFloat() * (percent / 100)
            }
            Emblems.Stuns -> {
                playerStats.stunsAverage.toFloat() * (percent / 100)
            }
            Emblems.Teamfight -> {
                playerStats.teamfightAverage.toFloat() * (percent / 100)
            }
            Emblems.Tormentor -> {
                playerStats.tormentorAverage.toFloat() * (percent / 100)
            }
            Emblems.Towers -> {
                playerStats.towersAverage.toFloat() * (percent / 100)
            }
            Emblems.Wards -> {
                playerStats.wardsAverage.toFloat() * (percent / 100)
            }
            Emblems.Watchers -> {
                playerStats.watchersAverage.toFloat() * (percent / 100)
            }
        }
    }

    private fun calculateEmblemTop(emblem: Emblems, playerStats: PlayerStats, percent: Float): Float {
        return when(emblem) {
            Emblems.Courier -> {
                playerStats.courierTop.toFloat() * (percent / 100)
            }
            Emblems.Creeps -> {
                playerStats.creepsTop.toFloat() * (percent / 100)
            }
            Emblems.Deaths -> {
                playerStats.deathsTop.toFloat() * (percent / 100)
            }
            Emblems.FirstBlood -> {
                playerStats.fbTop.toFloat() * (percent / 100)
            }
            Emblems.GPM -> {
                playerStats.gpmTop.toFloat() * (percent / 100)
            }
            Emblems.Kills -> {
                playerStats.killsTop.toFloat() * (percent / 100)
            }
            Emblems.Lotuses -> {
                playerStats.lotusesTop.toFloat() * (percent / 100)
            }
            Emblems.Madstones -> {
                playerStats.madstoneTop.toFloat() * (percent / 100)
            }
            Emblems.Roshan -> {
                playerStats.roshanTop.toFloat() * (percent / 100)
            }
            Emblems.Runes -> {
                playerStats.runesTop.toFloat() * (percent / 100)
            }
            Emblems.Smokes -> {
                playerStats.smokesTop.toFloat() * (percent / 100)
            }
            Emblems.Stacks -> {
                playerStats.campsTop.toFloat() * (percent / 100)
            }
            Emblems.Stuns -> {
                playerStats.stunsTop.toFloat() * (percent / 100)
            }
            Emblems.Teamfight -> {
                playerStats.teamfightTop.toFloat() * (percent / 100)
            }
            Emblems.Tormentor -> {
                playerStats.tormentorTop.toFloat() * (percent / 100)
            }
            Emblems.Towers -> {
                playerStats.towersTop.toFloat() * (percent / 100)
            }
            Emblems.Wards -> {
                playerStats.wardsTop.toFloat() * (percent / 100)
            }
            Emblems.Watchers -> {
                playerStats.watchersTop.toFloat() * (percent / 100)
            }
        }
    }

    fun calculateCorePlayerStats(allPlayerStats: List<Pair<Player, PlayerStats?>>) {
        var newList: MutableList<CalculatorPlayerStats> = mutableListOf()

        allPlayerStats.filter { it.first.role == Role.CORE }.forEach { player ->
            val firstRedEmblemAv = calculateEmblemAverage(
                _firstCoreRedEmblem.value,
                player.second!!,
                _firstCoreRedEmblemPercent.value ?: 0f
            )
            val firstGreenEmblemAv = calculateEmblemAverage(
                _firstCoreGreenEmblem.value,
                player.second!!,
                _firstCoreGreenEmblemPercent.value ?: 0f
            )
            val secondRedEmblemAv = calculateEmblemAverage(
                _secondCoreRedEmblem.value,
                player.second!!,
                _secondCoreRedEmblemPercent.value ?: 0f
            )

            val firstRedEmblemTop = calculateEmblemTop(
                _firstCoreRedEmblem.value,
                player.second!!,
                _firstCoreRedEmblemPercent.value ?: 0f
            )
            val firstGreenEmblemTop = calculateEmblemTop(
                _firstCoreGreenEmblem.value,
                player.second!!,
                _firstCoreGreenEmblemPercent.value ?: 0f
            )
            val secondRedEmblemTop = calculateEmblemTop(
                _secondCoreRedEmblem.value,
                player.second!!,
                _secondCoreRedEmblemPercent.value ?: 0f
            )

            newList.add(
                CalculatorPlayerStats(
                    playerAverageScore = firstRedEmblemAv + firstGreenEmblemAv + secondRedEmblemAv,
                    playerTopScore = firstRedEmblemTop + firstGreenEmblemTop + secondRedEmblemTop,
                    playerStats = player
                )
            )
        }

        newList = if (_selectedFilter.value == Filter.BY_AVERAGE) {
            newList.sortedByDescending { it.playerAverageScore }.toMutableList()
        } else {
            newList.sortedByDescending { it.playerTopScore }.toMutableList()
        }
        _corePlayersStats.value = newList
    }

    fun selectFilter(filter: Filter) {
        _selectedFilter.value = filter
        calculateCorePlayerStats(_playerStats.value)
        calculateMidPlayerStats(_playerStats.value)
        calculateSupportPlayerStats(_playerStats.value)
    }

    fun selectRole(newRole: Role) {
        _selectedRole.value = newRole
    }

    //Core
    fun setFirstCoreRedEmblem(newFirstRedEmblemCore: Emblems) {
        _firstCoreRedEmblem.value = newFirstRedEmblemCore
    }

    fun setSecondCoreRedEmblem(newSecondCoreRedEmblem: Emblems) {
        _secondCoreRedEmblem.value = newSecondCoreRedEmblem
    }

    fun setFirstCoreGreenEmblem(newFirstCoreGreenEmblem: Emblems) {
        _firstCoreGreenEmblem.value = newFirstCoreGreenEmblem
    }

    fun setFirstCoreRedEmblemPercent(newFirstRedEmblemCorePercent: Float?) {
        _firstCoreRedEmblemPercent.value = newFirstRedEmblemCorePercent
    }

    fun setSecondCoreRedEmblemPercent(newSecondCoreRedEmblemPercent: Float?) {
        _secondCoreRedEmblemPercent.value = newSecondCoreRedEmblemPercent
    }

    fun setFirstCoreGreenEmblemPercent(newFirstCoreGreenEmblemPercent: Float?) {
        _firstCoreGreenEmblemPercent.value = newFirstCoreGreenEmblemPercent
    }

    //Mid
    fun setMidRedEmblem(newRedEmblemMid: Emblems) {
        _midRedEmblem.value = newRedEmblemMid
    }

    fun setMidBlueEmblem(newMidBlueEmblem: Emblems) {
        _midBlueEmblem.value = newMidBlueEmblem
    }

    fun setMidGreenEmblem(newCoreGreenEmblem: Emblems) {
        _midGreenEmblem.value = newCoreGreenEmblem
    }

    fun setMidRedEmblemPercent(newRedEmblemMidPercent: Float?) {
        _midRedEmblemPercent.value = newRedEmblemMidPercent
    }

    fun setMidBlueEmblemPercent(newMidBlueEmblemPercent: Float?) {
        _midBlueEmblemPercent.value = newMidBlueEmblemPercent
    }

    fun setMidGreenEmblemPercent(newCoreGreenEmblemPercent: Float?) {
        _midGreenEmblemPercent.value = newCoreGreenEmblemPercent
    }

    fun calculateMidPlayerStats(allPlayerStats: List<Pair<Player, PlayerStats?>>) {
        var newList: MutableList<CalculatorPlayerStats> = mutableListOf()

        allPlayerStats.filter { it.first.role == Role.MID }.forEach { player ->
            val redEmblemAv = calculateEmblemAverage(
                _midRedEmblem.value,
                player.second!!,
                _midRedEmblemPercent.value ?: 0f
            )
            val greenEmblemAv = calculateEmblemAverage(
                _midGreenEmblem.value,
                player.second!!,
                _midGreenEmblemPercent.value ?: 0f
            )
            val blueEmblemAv = calculateEmblemAverage(
                _midBlueEmblem.value,
                player.second!!,
                _midBlueEmblemPercent.value ?: 0f
            )

            val redEmblemTop = calculateEmblemTop(
                _midRedEmblem.value,
                player.second!!,
                _midRedEmblemPercent.value ?: 0f
            )
            val greenEmblemTop = calculateEmblemTop(
                _midGreenEmblem.value,
                player.second!!,
                _midGreenEmblemPercent.value ?: 0f
            )
            val blueEmblemTop = calculateEmblemTop(
                _midBlueEmblem.value,
                player.second!!,
                _midBlueEmblemPercent.value ?: 0f
            )

            newList.add(
                CalculatorPlayerStats(
                    playerAverageScore = redEmblemAv + greenEmblemAv + blueEmblemAv,
                    playerTopScore = redEmblemTop + greenEmblemTop + blueEmblemTop,
                    playerStats = player
                )
            )
        }

        newList = if (_selectedFilter.value == Filter.BY_AVERAGE) {
            newList.sortedByDescending { it.playerAverageScore }.toMutableList()
        } else {
            newList.sortedByDescending { it.playerTopScore }.toMutableList()
        }
        _midPlayersStats.value = newList
    }

    //Support
    fun setSupport1BlueEmblem(newSupport1BlueEmblem: Emblems) {
        _support1BlueEmblem.value = newSupport1BlueEmblem
    }

    fun setSupportGreenEmblem(newSupportGreenEmblem: Emblems) {
        _supportGreenEmblem.value = newSupportGreenEmblem
    }

    fun setSupport2BlueEmblem(newSupport2BlueEmblem: Emblems) {
        _support2BlueEmblem.value = newSupport2BlueEmblem
    }

    fun setSupport1BlueEmblemPercent(newSupport1BlueEmblemPercent: Float?) {
        _support1BlueEmblemPercent.value = newSupport1BlueEmblemPercent
    }

    fun setSupportGreenEmblemPercent(newSupportGreenEmblemPercent: Float?) {
        _supportGreenEmblemPercent.value = newSupportGreenEmblemPercent
    }

    fun setSupport2BlueEmblemPercent(newSupport2BlueEmblemPercent: Float?) {
        _support2BlueEmblemPercent.value = newSupport2BlueEmblemPercent
    }

    fun clearSupportList() {
        _supportPlayersStats.value = mutableListOf()
    }

    fun calculateSupportPlayerStats(allPlayerStats: List<Pair<Player, PlayerStats?>>) {
        var newList: MutableList<CalculatorPlayerStats> = mutableListOf()

        allPlayerStats.filter { it.first.role == Role.SUPPORT }.forEach { player ->
            val blue1EmblemAv = calculateEmblemAverage(
                _support1BlueEmblem.value,
                player.second!!,
                _support1BlueEmblemPercent.value ?: 0f
            )
            val greenEmblemAv = calculateEmblemAverage(
                _supportGreenEmblem.value,
                player.second!!,
                _supportGreenEmblemPercent.value ?: 0f
            )
            val blue2EmblemAv = calculateEmblemAverage(
                _support2BlueEmblem.value,
                player.second!!,
                _support2BlueEmblemPercent.value ?: 0f
            )

            val blue1EmblemTop = calculateEmblemTop(
                _support1BlueEmblem.value,
                player.second!!,
                _support1BlueEmblemPercent.value ?: 0f
            )
            val greenEmblemTop = calculateEmblemTop(
                _supportGreenEmblem.value,
                player.second!!,
                _supportGreenEmblemPercent.value ?: 0f
            )
            val blue2EmblemTop = calculateEmblemTop(
                _support2BlueEmblem.value,
                player.second!!,
                _support2BlueEmblemPercent.value ?: 0f
            )

            newList.add(
                CalculatorPlayerStats(
                    playerAverageScore = blue1EmblemAv + greenEmblemAv + blue2EmblemAv,
                    playerTopScore = blue1EmblemTop + greenEmblemTop + blue2EmblemTop,
                    playerStats = player
                )
            )
        }

        newList = if (_selectedFilter.value == Filter.BY_AVERAGE) {
            newList.sortedByDescending { it.playerAverageScore }.toMutableList()
        } else {
            newList.sortedByDescending { it.playerTopScore }.toMutableList()
        }
        _supportPlayersStats.value = newList
    }
}