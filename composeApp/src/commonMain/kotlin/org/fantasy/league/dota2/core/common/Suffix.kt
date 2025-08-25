package org.fantasy.league.dota2.core.common

sealed class Suffix(
    val bonus: Float,
    val name: String,
) {
    object OfTheOctopus: Suffix(1.07f, "Of The Octopus / Послідовник Восьминога") //Conf
    object TheUnderdog: Suffix(1.15f, "The Underdog / Нещасливець")
    object TheFlayedTwinsAcolyte: Suffix(1.15f, "The Flayed Twins Acolyte / Послушник Білованих Близнюків")
    object TheLoquacious: Suffix(1.07f, "The Loquacious") //Conf
    object TheTormented: Suffix(1.09f, "The Tormented / Страдник") //Conf
    object TheDivineThief: Suffix(1.09f, "The Divine Thief / Божествений злодій") //Conf
    object OfTheRaven: Suffix(1.06f, "Of The Raven / Послідовник ворона") //Conf
    object TheNorthPilgrim: Suffix(1.07f, "The North Pilgrim / Пилігрим із Нотла")
    object TheAccomplice: Suffix(1.07f, "The Accomplice / Співучасник") //Conf
    object TheMule: Suffix(1.21f, "The Mule") //Conf
    object TheDecisive: Suffix(1.25f, "The Decisive / Спритник") //Conf
    object ThePacifist: Suffix(1.08f, "The Pacifist / Миролюбивець") //Conf
    object OfTheBull: Suffix(1.09f, "Of The Bull / Послідовник бика") //Conf
    object OfTheAnt: Suffix(1.08f, "Of The Ant / Послідовник мурахи") //Conf
    object TheEvenKeeled: Suffix(1.25f, "The Even Keeled") //Conf
    object ThePatient: Suffix(1.13f, "The Patient / Терпеливець") //Conf
}