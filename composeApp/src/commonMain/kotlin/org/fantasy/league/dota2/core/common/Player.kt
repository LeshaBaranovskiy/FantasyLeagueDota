package org.fantasy.league.dota2.core.common

import org.fantasy.league.dota2.core.common.Team.*

sealed class Player(
    val name: String,
    val steamId: Long,
    val team: Team,
    val role: Role
) {
    companion object {
        val all = listOf(
            // Liquid
            miCke, Nisha, SabeRLight, Boxi, Insania,

            // Parivision
            Satanic, Noone, DM, NineClass, Dukalis,

            // BetBoom
            Pure, gpk, MieRo, Save, Kataomi,

            // Team Tidebound
            shiro, NothingToSay, Faith_bian, planet, y,

            // Gaimin Glidiators
            watson, Quinn, Ace, tofu, Malady,

            // Team Spirit
            Yatoro, Larl, Collapse, rue, Miposhka,

            // Team Falcons
            skiter, Marl1ne, ATF, Cr1t, Sneyking,

            // Tundra
            Crystallis, bzm, tundra_33, Saksa, Whitemon,

            // Natus Vincere
            gotthejuice, Niku, pma, Zayac, Riddys,

            // Nigma Galaxy
            Ghost, SumaiL, Noob, OmaR, GH,

            // Aurora Gaming
            Nightfall, kiyotaka, TORONTOTOKYO, Mira, panto,

            // Boom Esports
            JaCkky, Armel, Jabz, Tims, Jaunuel,

            // Team Nemesis
            Akashi, Mac, Raven, Jing, Erice,

            // Heroic
            Yuma, _4nalog, Wisper, Scofield, KJ,

            // Xtreme Gaming
            Ame, Xm, Xxs, XinQ, xNova,

            // Wildcard
            Yamsun, RCY, Fayde, Bignum, Speeed
        )
    }

    //Liquid
    object miCke: Player(name = "miCKe", 76561198113227791, Liquid, Role.CORE)
    object Nisha: Player(name = "Nisha", 76561198161624340, Liquid, Role.MID)
    object SabeRLight: Player(name = "SabeRLight-", 76561198086478594, Liquid, Role.CORE)
    object Boxi: Player(name = "Boxi", 76561198037756242, Liquid, Role.SUPPORT)
    object Insania: Player(name = "Insania", 76561198014846690, Liquid, Role.SUPPORT)

    //Parivision
    object Satanic: Player(name = "Satanic \uD83D\uDC3D", 76561199004267995, Parivision, Role.CORE)
    object Noone: Player(name = "No[o]ne \uD83D\uDC18", 76561198066839629, Parivision, Role.MID)
    object DM: Player(name = "DM \uD83D\uDC3D", 76561198016617237, Parivision, Role.CORE)
    object NineClass: Player(name = "9Class \uD83D\uDC3D", 76561198124464930, Parivision, Role.SUPPORT)
    object Dukalis: Player(name = "Dukalis \uD83D\uDC3D", 76561198033666810, Parivision, Role.SUPPORT)

    //BB
    object Pure: Player(name = "Pure \uD83E\uDD21", 76561198292121258, BetBoom, Role.CORE)
    object gpk: Player(name = "gpk \uD83D\uDC3D", 76561198440678391, BetBoom, Role.MID)
    object MieRo: Player(name = "MieRo \uD83D\uDC3D", 76561198125830326, BetBoom, Role.CORE)
    object Save: Player(name = "Save- \uD83D\uDC3D", 76561198278146366, BetBoom, Role.SUPPORT)
    object Kataomi: Player(name = "Kataomi \uD83D\uDC3D", 76561198157143864, BetBoom, Role.SUPPORT)

    //Team Tidebound
    object shiro: Player(name = "shiro", 76561198280517752, TeamTidebound, Role.CORE)
    object NothingToSay: Player(name = "NothingToSay", 76561198134243802, TeamTidebound, Role.MID)
    object Faith_bian: Player(name = "Faith_bian", 76561198078399948, TeamTidebound, Role.CORE)
    object planet: Player(name = "planet", 76561198111227295, TeamTidebound, Role.SUPPORT)
    object y: Player(name = "y`", 76561198071380415, TeamTidebound, Role.SUPPORT)

    //Gaimin Glidiators
    object watson: Player(name = "watson", 76561198131528630, GaiminGladiators, Role.CORE)
    object Quinn: Player(name = "Quinn", 76561198181931958, GaiminGladiators, Role.MID)
    object Ace: Player(name = "Ace", 76561198057856286, GaiminGladiators, Role.CORE)
    object tofu: Player(name = "tofu", 76561197976763535, GaiminGladiators, Role.SUPPORT)
    object Malady: Player(name = "Malady", 76561198054083399, GaiminGladiators, Role.SUPPORT)

    //Team Spirit
    object Yatoro: Player(name = "Yatoro \uD83D\uDC18", 76561198281846390, TeamSpirit, Role.CORE)
    object Larl: Player(name = "Larl \uD83D\uDC3D", 76561198066570770, TeamSpirit, Role.MID)
    object Collapse: Player(name = "Collapse \uD83D\uDC3D", 76561198262479756, TeamSpirit, Role.CORE)
    object rue: Player(name = "rue \uD83D\uDC3D", 76561198807831324, TeamSpirit, Role.SUPPORT)
    object Miposhka: Player(name = "Miposhka \uD83D\uDC3D", 76561198073597242, TeamSpirit, Role.SUPPORT)

    //Team Falcons
    object skiter: Player(name = "skiter", 76561198060324070, TeamFalcons, Role.CORE)
    object Marl1ne: Player(name = "Marl1ne \uD83D\uDC3D", 76561198858721548, TeamFalcons, Role.MID)
    object ATF: Player(name = "ATF", 76561198143985114, TeamFalcons, Role.CORE)
    object Cr1t: Player(name = "Cr1t-", 76561197986172872, TeamFalcons, Role.SUPPORT)
    object Sneyking: Player(name = "Sneyking", 76561197970632344, TeamFalcons, Role.SUPPORT)

    //Tundra
    object Crystallis: Player(name = "Crystallis", 76561198087883707, TundraEsports, Role.CORE)
    object bzm: Player(name = "bzm", 76561198053884305, TundraEsports, Role.MID)
    object tundra_33: Player(name = "33", 76561198046964005, TundraEsports, Role.CORE)
    object Saksa: Player(name = "Saksa", 76561198064001473, TundraEsports, Role.SUPPORT)
    object Whitemon: Player(name = "Whitemon", 76561198097094819, TundraEsports, Role.SUPPORT)

    //Natus Vincere
    object gotthejuice: Player(name = "gotthejuice \uD83D\uDC51", 76561198917469777, NatusVincere, Role.CORE)
    object Niku: Player(name = "Niku \uD83D\uDC51", 76561198145856102, NatusVincere, Role.MID)
    object pma: Player(name = "pma \uD83D\uDC51", 76561198796129863, NatusVincere, Role.CORE)
    object Zayac: Player(name = "Zayac \uD83D\uDC51", 76561198071296043, NatusVincere, Role.SUPPORT)
    object Riddys: Player(name = "Riddys \uD83D\uDC51", 76561198091257032, NatusVincere, Role.SUPPORT)

    //Nigma Galaxy
    object Ghost: Player(name = "Ghost", 76561198166908095, NigmaGalaxy, Role.CORE)
    object SumaiL: Player(name = "SumaiL", 76561198071885769, NigmaGalaxy, Role.MID)
    object Noob: Player(name = "No!ob", 76561198100563280, NigmaGalaxy, Role.CORE)
    object OmaR: Player(name = "OmaR", 76561198112433885, NigmaGalaxy, Role.SUPPORT)
    object GH: Player(name = "GH", 76561198061622614, NigmaGalaxy, Role.SUPPORT)

    //Aurora Gaming
    object Nightfall: Player(name = "Nightfall \uD83D\uDC3D", 76561198085066985, Aurora, Role.CORE)
    object kiyotaka: Player(name = "kiyotaka \uD83D\uDC3D", 76561198818372174, Aurora, Role.MID)
    object TORONTOTOKYO: Player(name = "TORONTOTOKYO \uD83D\uDC3D", 76561198392036633, Aurora, Role.CORE)
    object Mira: Player(name = "Mira \uD83D\uDC18", 76561198216422051, Aurora, Role.SUPPORT)
    object panto: Player(name = "panto \uD83D\uDC3D", 76561198069224497, Aurora, Role.SUPPORT)

    // Boom Esports
    object JaCkky: Player(name = "JaCkky", steamId = 76561198352830965, BoomEsports, Role.CORE)
    object Armel: Player(name = "Armel", steamId = 76561198124797733, BoomEsports, Role.MID)
    object Jabz: Player(name = "Jabz", steamId = 76561198060737259, BoomEsports, Role.CORE)
    object Tims: Player(name = "Tims", steamId = 76561198115760109, BoomEsports, Role.SUPPORT)
    object Jaunuel: Player(name = "Jaunuel", steamId = 76561198108792701, BoomEsports, Role.SUPPORT)

    // Team Nemesis
    object Akashi: Player(name = "Akashi", steamId = 76561198290800054, Nemesis, Role.CORE)
    object Mac: Player(name = "Mac", steamId = 76561198064777854, Nemesis, Role.MID)
    object Raven: Player(name = "Raven", steamId = 76561198092575221, Nemesis, Role.CORE)
    object Jing: Player(name = "Jing", steamId = 76561198180021126, Nemesis, Role.SUPPORT)
    object Erice: Player(name = "Erice", steamId = 76561198060864687, Nemesis, Role.SUPPORT)

    // Heroic
    object Yuma: Player(name = "Yuma", steamId = 76561198137469680, Heroic, Role.CORE)
    object _4nalog: Player(name = "4nalog", steamId = 76561198091569360, Heroic, Role.MID)
    object Wisper: Player(name = "Wisper", steamId = 76561198253187000, Heroic, Role.CORE)
    object Scofield: Player(name = "Scofield", steamId = 76561198118255226, Heroic, Role.SUPPORT)
    object KJ: Player(name = "KJ", steamId = 76561198041572126, Heroic, Role.SUPPORT)

    // Xtreme Gaming
    object Ame: Player(name = "Ame", steamId = 76561198859019881, XtremeGaming, Role.CORE)
    object Xm: Player(name = "Xm", steamId = 76561198097395311, XtremeGaming, Role.MID)
    object Xxs: Player(name = "Xxs", steamId = 76561198090224486, XtremeGaming, Role.CORE)
    object XinQ: Player(name = "XinQ", steamId = 76561198117741251, XtremeGaming, Role.SUPPORT)
    object xNova: Player(name = "xNova", steamId = 76561198054561825, XtremeGaming, Role.SUPPORT)

    // Wildcard
    object Yamsun: Player(name = "Yamsun", steamId = 76561198041741031, Wildcart, Role.CORE)
    object RCY: Player(name = "RCY", steamId = 76561198115239974, Wildcart, Role.MID)
    object Fayde: Player(name = "Fayde", steamId = 76561198120384745, Wildcart, Role.CORE)
    object Bignum: Player(name = "Bignum", steamId = 76561198050689479, Wildcart, Role.SUPPORT)
    object Speeed: Player(name = "Speeed", steamId = 76561198151628603, Wildcart, Role.SUPPORT)

}