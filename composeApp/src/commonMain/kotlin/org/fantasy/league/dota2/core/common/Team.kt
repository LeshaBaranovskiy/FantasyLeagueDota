package org.fantasy.league.dota2.core.common

import fantasyleaguedota.composeapp.generated.resources.Res
import fantasyleaguedota.composeapp.generated.resources.logo_aurora
import fantasyleaguedota.composeapp.generated.resources.logo_bb
import fantasyleaguedota.composeapp.generated.resources.logo_boom
import fantasyleaguedota.composeapp.generated.resources.logo_gaimin_gladiators
import fantasyleaguedota.composeapp.generated.resources.logo_heroic
import fantasyleaguedota.composeapp.generated.resources.logo_navi
import fantasyleaguedota.composeapp.generated.resources.logo_nemesis
import fantasyleaguedota.composeapp.generated.resources.logo_nigma
import fantasyleaguedota.composeapp.generated.resources.logo_parivision
import fantasyleaguedota.composeapp.generated.resources.logo_team_falcons
import fantasyleaguedota.composeapp.generated.resources.logo_team_liquid
import fantasyleaguedota.composeapp.generated.resources.logo_team_spirit
import fantasyleaguedota.composeapp.generated.resources.logo_tidebound
import fantasyleaguedota.composeapp.generated.resources.logo_tundra
import fantasyleaguedota.composeapp.generated.resources.logo_wildcart
import fantasyleaguedota.composeapp.generated.resources.logo_xtreme
import fantasyleaguedota.composeapp.generated.resources.logo_yakutou
import org.jetbrains.compose.resources.DrawableResource

sealed class Team(
    val logoId: DrawableResource,
) {
    object Liquid: Team(Res.drawable.logo_team_liquid)
    object Parivision: Team(Res.drawable.logo_parivision)
    object BetBoom: Team(Res.drawable.logo_bb)
    object TeamTidebound: Team(Res.drawable.logo_tidebound)
    object GaiminGladiators: Team(Res.drawable.logo_gaimin_gladiators)
    object TeamSpirit: Team(Res.drawable.logo_team_spirit)
    object TeamFalcons: Team(Res.drawable.logo_team_falcons)
    object TundraEsports: Team(Res.drawable.logo_tundra)
    object BoomEsports: Team(Res.drawable.logo_boom)
    object Nemesis: Team(Res.drawable.logo_nemesis)
    object NatusVincereJunior: Team(Res.drawable.logo_navi)
    object NigmaGalaxy: Team(Res.drawable.logo_nigma)
    object Aurora: Team(Res.drawable.logo_aurora)
    object NatusVincere: Team(Res.drawable.logo_navi)
    object Heroic: Team(Res.drawable.logo_heroic)
    object XtremeGaming: Team(Res.drawable.logo_xtreme)
    object Wildcart: Team(Res.drawable.logo_wildcart)
    object YakultBrother: Team(Res.drawable.logo_yakutou)
}