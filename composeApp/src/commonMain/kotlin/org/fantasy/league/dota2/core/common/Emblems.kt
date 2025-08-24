package org.fantasy.league.dota2.core.common

import org.fantasy.league.dota2.core.common.Emblems.Courier
import org.fantasy.league.dota2.core.common.Emblems.Creeps
import org.fantasy.league.dota2.core.common.Emblems.Deaths
import org.fantasy.league.dota2.core.common.Emblems.FirstBlood
import org.fantasy.league.dota2.core.common.Emblems.GPM
import org.fantasy.league.dota2.core.common.Emblems.Kills
import org.fantasy.league.dota2.core.common.Emblems.Lotuses
import org.fantasy.league.dota2.core.common.Emblems.Madstones
import org.fantasy.league.dota2.core.common.Emblems.Roshan
import org.fantasy.league.dota2.core.common.Emblems.Runes
import org.fantasy.league.dota2.core.common.Emblems.Smokes
import org.fantasy.league.dota2.core.common.Emblems.Stacks
import org.fantasy.league.dota2.core.common.Emblems.Stuns
import org.fantasy.league.dota2.core.common.Emblems.Teamfight
import org.fantasy.league.dota2.core.common.Emblems.Tormentor
import org.fantasy.league.dota2.core.common.Emblems.Towers
import org.fantasy.league.dota2.core.common.Emblems.Wards
import org.fantasy.league.dota2.core.common.Emblems.Watchers

sealed class Emblems(val title: String, val emblemColor: EmblemColor) {
    //Red
    object Creeps: Emblems("Creeps", EmblemColor.RED)
    object GPM: Emblems("GPM", EmblemColor.RED)
    object Deaths: Emblems("Deaths", EmblemColor.RED)
    object Madstones: Emblems("Madstones collected", EmblemColor.RED)
    object Kills: Emblems("Kills", EmblemColor.RED)
    object Towers: Emblems("Tower kills", EmblemColor.RED)

    //Blue
    object Lotuses: Emblems("Lotuses grabbed", EmblemColor.BLUE)
    object Wards: Emblems("Wards placed", EmblemColor.BLUE)
    object Smokes: Emblems("Smokes placed", EmblemColor.BLUE)
    object Watchers: Emblems("Watchers taken", EmblemColor.BLUE)
    object Runes: Emblems("Runes grabbed", EmblemColor.BLUE)
    object Stacks: Emblems("Creep stacks", EmblemColor.BLUE)

    //Green
    object Teamfight: Emblems("Teamfight Participation", EmblemColor.GREEN)
    object Stuns: Emblems("Stuns", EmblemColor.GREEN)
    object Tormentor: Emblems("Tormentor kills", EmblemColor.GREEN)
    object Courier: Emblems("Courier kills", EmblemColor.GREEN)
    object Roshan: Emblems("Roshan kills", EmblemColor.GREEN)
    object FirstBlood: Emblems("First blood", EmblemColor.GREEN)
}

enum class EmblemColor {
    RED, GREEN, BLUE
}

val redEmblems = listOf(
    Creeps, GPM, Deaths, Madstones, Kills, Towers,
)

val greenEmblems = listOf(
    Teamfight, Stuns, Tormentor, Courier, Roshan, FirstBlood,
)

val blueEmblems = listOf(
    Lotuses, Wards, Smokes, Watchers, Runes, Stacks,
)