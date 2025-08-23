package org.fantasy.league.dota2.core.common

sealed class Prefix(
    val bonus: Float,
    val name: String,
) {
    object Hirsute: Prefix(1.10f, "Hirsute") //Conf
    object Cerulean: Prefix(1.19f, "Cerulean")
    object Crimson: Prefix(1.13f, "Crimson") //Conf
    object Otherworldly: Prefix(1.13f, "Otherworldly") //Conf
    object Brawny: Prefix(1.13f, "Brawny") //Conf
    object Canny: Prefix(1.11f, "Canny") //Conf
    object Sacrificial: Prefix(1.15f, "Sacrificial") //Conf
    object Bestial: Prefix(1.15f, "Bestial") //Conf
    object Balanced: Prefix(1.15f, "Balanced") //Conf
    object Elemental: Prefix(1.15f, "Elemental") //Conf
    object Coveted: Prefix(1.15f, "Coveted") //Conf
    object Virtuoso: Prefix(1.13f, "Virtuoso") //Conf
    object Emerald: Prefix(1.18f, "Emerald") //Conf
    object Clutch: Prefix(1.11f, "Clutch") //Conf
    object Dashing: Prefix(1.15f, "Dashing") //Conf
    object Glamorous: Prefix(1.25f, "Glamorous") //Conf
}

//Confirmed
val hirsuteHeroes = listOf(
    Heroes.Axe,
    Heroes.Juggernaut,
    Heroes.PhantomLancer,
    Heroes.StormSpirit,
    Heroes.Zeus,
    Heroes.Kunkka,
    Heroes.Riki,
    Heroes.Tinker,
    Heroes.Sniper,
    Heroes.Necrophos,
    Heroes.Warlock,
    Heroes.Beastmaster,
    Heroes.WraithKing,
    Heroes.NatureSProphet,
    Heroes.DarkSeer,
    Heroes.Omniknight,
    Heroes.SpiritBreaker,
    Heroes.Alchemist,
    Heroes.Lycan,
    Heroes.LoneDruid,
    Heroes.Disruptor,
    Heroes.KeeperOfTheLight,
    Heroes.CentaurWarrunner,
    Heroes.Grimstroke,
    Heroes.Mars,
    Heroes.VoidSpirit,
    Heroes.Earthshaker,
    Heroes.Enchantress,
    Heroes.Ursa,
    Heroes.Brewmaster,
    Heroes.Meepo,
    Heroes.Magnus,
    Heroes.Tusk,
    Heroes.MonkeyKing,
    Heroes.Pangolier,
    Heroes.Hoodwink
)

//Confirmed
val celureanHeroes = listOf(
    Heroes.CrystalMaiden,
    Heroes.Morphling,
    Heroes.PhantomLancer,
    Heroes.Puck,
    Heroes.Razor,
    Heroes.StormSpirit,
    Heroes.Zeus,
    Heroes.Lich,
    Heroes.Riki,
    Heroes.Enigma,
    Heroes.Luna,
    Heroes.Leshrac,
    Heroes.NightStalker,
    Heroes.Jakiro,
    Heroes.AncientApparition,
    Heroes.SpiritBreaker,
    Heroes.OgreMagi,
    Heroes.Io,
    Heroes.Visage,
    Heroes.Abaddon,
    Heroes.Oracle,
    Heroes.WinterWyvern,
    Heroes.ArcWarden,
    Heroes.Muerta
)

//Confirmed
val crimsonHeroes = listOf(
    Heroes.Axe,
    Heroes.Bloodseeker,
    Heroes.ShadowFiend,
    Heroes.Pudge,
    Heroes.Lina,
    Heroes.Sniper,
    Heroes.Warlock,
    Heroes.Beastmaster,
    Heroes.DragonKnight,
    Heroes.Clockwerk,
    Heroes.Broodmother,
    Heroes.Jakiro,
    Heroes.Batrider,
    Heroes.Doom,
    Heroes.Brewmaster,
    Heroes.ShadowDemon,
    Heroes.ChaosKnight,
    Heroes.Disruptor,
    Heroes.TrollWarlord,
    Heroes.LegionCommander,
    Heroes.EmberSpirit,
    Heroes.Phoenix,
    Heroes.Pangolier,
    Heroes.Mars,
    Heroes.Snapfire,
    Heroes.PrimalBeast
)

//Confirmed
val otherwordlyHeroes = listOf(
    Heroes.Pudge,
    Heroes.Kunkka,
    Heroes.Lich,
    Heroes.Necrophos,
    Heroes.WraithKing,
    Heroes.DeathProphet,
    Heroes.Pugna,
    Heroes.Lifestealer,
    Heroes.Clinkz,
    Heroes.Huskar,
    Heroes.Spectre,
    Heroes.Undying,
    Heroes.Grimstroke,
    Heroes.Muerta,
    Heroes.Lion,
    Heroes.QueenOfPain,
    Heroes.Doom,
    Heroes.ShadowDemon,
    Heroes.Terrorblade,
    Heroes.Underlord,
    Heroes.ShadowFiend,
    Heroes.EmberSpirit,
    Heroes.EarthSpirit,
    Heroes.StormSpirit,
    Heroes.VoidSpirit,
    Heroes.VengefulSpirit
)

//Confirmed
val brawnyHeroes = listOf(
    Heroes.Alchemist,
    Heroes.Axe,
    Heroes.Bristleback,
    Heroes.CentaurWarrunner,
    Heroes.ChaosKnight,
    Heroes.Clockwerk,
    Heroes.Dawnbreaker,
    Heroes.Doom,
    Heroes.DragonKnight,
    Heroes.EarthSpirit,
    Heroes.Earthshaker,
    Heroes.ElderTitan,
    Heroes.Huskar,
    Heroes.Kunkka,
    Heroes.LegionCommander,
    Heroes.Lifestealer,
    Heroes.Lycan,
    Heroes.Mars,
    Heroes.NightStalker,
    Heroes.OgreMagi,
    Heroes.Omniknight,
    Heroes.Phoenix,
    Heroes.PrimalBeast,
    Heroes.Pudge,
    Heroes.Slardar,
    Heroes.SpiritBreaker,
    Heroes.Sven,
    Heroes.Tidehunter,
    Heroes.Timbersaw,
    Heroes.Tiny,
    Heroes.TreantProtector,
    Heroes.Tusk,
    Heroes.Underlord,
    Heroes.Undying,
    Heroes.WraithKing
)

//Confirmed
val cannyHeroes = listOf(
    Heroes.AncientApparition,
    Heroes.Chen,
    Heroes.CrystalMaiden,
    Heroes.DarkSeer,
    Heroes.DarkWillow,
    Heroes.Disruptor,
    Heroes.Enchantress,
    Heroes.Grimstroke,
    Heroes.Invoker,
    Heroes.Jakiro,
    Heroes.KeeperOfTheLight,
    Heroes.Leshrac,
    Heroes.Lich,
    Heroes.Lina,
    Heroes.Lion,
    Heroes.Muerta,
    Heroes.Necrophos,
    Heroes.Oracle,
    Heroes.OutworldDestroyer,
    Heroes.Puck,
    Heroes.Pugna,
    Heroes.QueenOfPain,
    Heroes.Ringmaster,
    Heroes.Rubick,
    Heroes.ShadowDemon,
    Heroes.ShadowShaman,
    Heroes.Silencer,
    Heroes.SkywrathMage,
    Heroes.StormSpirit,
    Heroes.Tinker,
    Heroes.Warlock,
    Heroes.WinterWyvern,
    Heroes.WitchDoctor,
    Heroes.Zeus
)

//Confirmed
val bestialHeroes = listOf(
    Heroes.Riki,
    Heroes.Beastmaster,
    Heroes.QueenOfPain,
    Heroes.Pugna,
    Heroes.Leshrac,
    Heroes.Clinkz,
    Heroes.Enchantress,
    Heroes.Doom,
    Heroes.SpiritBreaker,
    Heroes.CentaurWarrunner,
    Heroes.Magnus,
    Heroes.ElderTitan,
    Heroes.Terrorblade,
    Heroes.Underlord,
    Heroes.Puck,
    Heroes.Viper,
    Heroes.NightStalker,
    Heroes.Jakiro,
    Heroes.OutworldDestroyer,
    Heroes.Visage,
    Heroes.SkywrathMage,
    Heroes.Phoenix,
    Heroes.WinterWyvern,
    Heroes.DarkWillow
)

//Confirmed
val balancedHeroes = listOf(
    Heroes.Abaddon,
    Heroes.ArcWarden,
    Heroes.Bane,
    Heroes.Batrider,
    Heroes.Beastmaster,
    Heroes.Brewmaster,
    Heroes.Dazzle,
    Heroes.DeathProphet,
    Heroes.Enigma,
    Heroes.Io,
    Heroes.Magnus,
    Heroes.Marci,
    Heroes.NatureSProphet,
    Heroes.NyxAssassin,
    Heroes.Pangolier,
    Heroes.SandKing,
    Heroes.Snapfire,
    Heroes.Spectre,
    Heroes.Techies,
    Heroes.Venomancer,
    Heroes.Visage,
    Heroes.VoidSpirit,
    Heroes.Windranger
)

//Confirmed
val elementalHeroes = listOf(
    Heroes.Morphling,
    Heroes.Kunkka,
    Heroes.Slardar,
    Heroes.Tidehunter,
    Heroes.NagaSiren,
    Heroes.Slark,
    Heroes.Lina,
    Heroes.DragonKnight,
    Heroes.Clinkz,
    Heroes.Huskar,
    Heroes.Jakiro,
    Heroes.Batrider,
    Heroes.Doom,
    Heroes.Invoker,
    Heroes.Brewmaster,
    Heroes.OgreMagi,
    Heroes.EmberSpirit,
    Heroes.Phoenix,
    Heroes.Techies,
    Heroes.Dawnbreaker,
    Heroes.CrystalMaiden,
    Heroes.DrowRanger,
    Heroes.Lich,
    Heroes.AncientApparition,
    Heroes.Tusk,
    Heroes.WinterWyvern
)

//Confirmed
val emeraldHeroes = listOf(
    Heroes.VengefulSpirit,
    Heroes.Windranger,
    Heroes.Tidehunter,
    Heroes.Necrophos,
    Heroes.Venomancer,
    Heroes.WraithKing,
    Heroes.Pugna,
    Heroes.Viper,
    Heroes.NatureSProphet,
    Heroes.Enchantress,
    Heroes.OutworldDestroyer,
    Heroes.TreantProtector,
    Heroes.Undying,
    Heroes.Rubick,
    Heroes.NagaSiren,
    Heroes.Medusa,
    Heroes.EarthSpirit,
    Heroes.Underlord,
    Heroes.MonkeyKing,
    Heroes.DarkWillow,
    Heroes.Hoodwink,
    Heroes.Muerta
)

//Confirmed
val dashingHeroes = listOf(
    Heroes.AntiMage,
    Heroes.Bloodseeker,
    Heroes.BountyHunter,
    Heroes.Broodmother,
    Heroes.Clinkz,
    Heroes.DrowRanger,
    Heroes.EmberSpirit,
    Heroes.FacelessVoid,
    Heroes.Gyrocopter,
    Heroes.Hoodwink,
    Heroes.Juggernaut,
    Heroes.Kez,
    Heroes.LoneDruid,
    Heroes.Luna,
    Heroes.Medusa,
    Heroes.Meepo,
    Heroes.Mirana,
    Heroes.MonkeyKing,
    Heroes.Morphling,
    Heroes.NagaSiren,
    Heroes.PhantomAssassin,
    Heroes.PhantomLancer,
    Heroes.Razor,
    Heroes.Riki,
    Heroes.ShadowFiend,
    Heroes.Slark,
    Heroes.Sniper,
    Heroes.TemplarAssassin,
    Heroes.Terrorblade,
    Heroes.TrollWarlord,
    Heroes.Ursa,
    Heroes.VengefulSpirit,
    Heroes.Viper,
    Heroes.Weaver
)