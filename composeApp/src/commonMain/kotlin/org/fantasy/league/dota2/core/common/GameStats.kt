package org.fantasy.league.dota2.core.common

import kotlinx.serialization.Serializable

@Serializable
data class GameStats(
    val gameTimeSeconds: Float,
    val gameWinner: Int,
    val fbBeforeHorn: Boolean,
    val fbAfter10min: Boolean,
    val isRampageInGame: Boolean,
    val lessThan25min: Boolean,
    val leagueId: Int,
    val playerInfo: List<PlayerInfo>
)

@Serializable
data class PlayerInfo(
    val name: String,
    val steamId: Long,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val selectedHeroId: Int,
    val pickOrder: Int,
    val teamfightParticipation: Float,
    val heroTierDotaPlus: Int,
    val firstBloodClaimed: Boolean,
    val runes: Int,
    val gpm: Float,
    val teamNum: Int,
    val isWon: Boolean,
    val lastHits: Int,
    val towerKills: Int,
    val madstonesCollected: Int,
    val wardsPlaced: Int,
    val campsStacked: Int,
    val watchersTaken: Int,
    val smokesUsed: Int,
    val lotusesGrabbed: Int,
    val roshanKills: Int,
    val stuns: Float,
    val tormentorKills: Int,
    val courierKills: Int,
    val networth: Int,
    val isFirstPick: Boolean,
    val isLastPick: Boolean,
    val isMasterGrandMaster: Boolean,
    val lastGameOfTheSeries: Boolean,
    val theMostDeaths: Boolean,
    val theMostAssists: Boolean,
    val theLowestNetworth: Boolean,
    val noKills: Boolean,
    val isBoughtBackBefore30: Boolean
)