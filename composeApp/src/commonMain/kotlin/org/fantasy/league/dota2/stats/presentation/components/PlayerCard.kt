package org.fantasy.league.dota2.stats.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.fantasy.league.dota2.core.common.GameStats
import org.fantasy.league.dota2.core.common.Player
import org.fantasy.league.dota2.core.common.PlayerStats
import org.fantasy.league.dota2.core.common.Role
import org.fantasy.league.dota2.core.common.averageAverageAll
import org.fantasy.league.dota2.core.common.averageAverageCore
import org.fantasy.league.dota2.core.common.averageAverageSupp
import org.fantasy.league.dota2.core.common.averageTopAll
import org.fantasy.league.dota2.core.common.averageTopCore
import org.fantasy.league.dota2.core.common.averageTopSupp
import org.fantasy.league.dota2.core.common.prefixes
import org.fantasy.league.dota2.core.common.suffixes
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

@Composable
fun PlayerCard(
    playerStats: Pair<Player, PlayerStats?>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                color = Color(0xFF000000),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(
                    playerStats.first.team.logoId
                ),
                contentDescription = "team_logo",
                modifier = Modifier
                    .size(60.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = playerStats.first.name,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = "Average stats (" +
                            "${
                                if (playerStats.first.role == Role.CORE) {
                                    playerStats.second?.averageAverageCore()?.roundToInt()
                                } else if (playerStats.first.role == Role.MID) {
                                    playerStats.second?.averageAverageAll()?.roundToInt()
                                } else {
                                    playerStats.second?.averageAverageSupp()?.roundToInt()
                                }
                            }" +
                            ")",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                if (playerStats.first.role == Role.CORE || playerStats.first.role == Role.MID) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Deaths: \n" + playerStats.second?.deathsAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Kills: \n" + playerStats.second?.killsAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Creeps: \n" + playerStats.second?.creepsAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "GPM: \n" + playerStats.second?.gpmAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Towers: \n" + playerStats.second?.towersAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Stones: \n" + playerStats.second?.madstoneAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    HorizontalDivider()
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Stuns: \n" + playerStats.second?.stunsAverage.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Torm: \n" + playerStats.second?.tormentorAverage.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "FB: \n" + playerStats.second?.fbAverage?.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Teamfight: \n" + playerStats.second?.teamfightAverage.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Rosh: \n" + playerStats.second?.roshanAverage.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Courier: \n" + playerStats.second?.courierAverage.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )
                }

                if (playerStats.first.role == Role.MID || playerStats.first.role == Role.SUPPORT) {
                    HorizontalDivider()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Wards: \n" + playerStats.second?.wardsAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Stacks: \n" + playerStats.second?.campsAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Lotuses: \n" + playerStats.second?.lotusesAverage?.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Watchers: \n" + playerStats.second?.watchersAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Runes: \n" + playerStats.second?.runesAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Smokes: \n" + playerStats.second?.smokesAverage.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }
                }

                Text(
                    text = "Top stats (${
                        if (playerStats.first.role == Role.CORE) {
                            playerStats.second?.averageTopCore()?.roundToInt()
                        } else if (playerStats.first.role == Role.MID) {
                            playerStats.second?.averageTopAll()?.roundToInt()
                        } else {
                            playerStats.second?.averageTopSupp()?.roundToInt()
                        }
                    })",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                if (playerStats.first.role == Role.CORE || playerStats.first.role == Role.MID) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Deaths: \n" + playerStats.second?.deathsTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Kills: \n" + playerStats.second?.killsTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Creeps: \n" + playerStats.second?.creepsTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "GPM: \n" + playerStats.second?.gpmTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Towers: \n" + playerStats.second?.towersTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Stones: \n" + playerStats.second?.madstoneTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    HorizontalDivider()
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Stuns: \n" + playerStats.second?.stunsTop.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Torm: \n" + playerStats.second?.tormentorTop.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "FB: \n" + playerStats.second?.fbTop?.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Teamfight: \n" + playerStats.second?.teamfightTop.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Rosh: \n" + playerStats.second?.roshanTop.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )

                    Text(
                        text = "Courier: \n" + playerStats.second?.courierTop.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .weight(0.33f)
                    )
                }

                if (playerStats.first.role == Role.MID || playerStats.first.role == Role.SUPPORT) {
                    HorizontalDivider()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Wards: \n" + playerStats.second?.wardsTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Stacks: \n" + playerStats.second?.campsTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Lotuses: \n" + playerStats.second?.lotusesTop?.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Watchers: \n" + playerStats.second?.watchersTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Runes: \n" + playerStats.second?.runesTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )

                        Text(
                            text = "Smokes: \n" + playerStats.second?.smokesTop.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .weight(0.33f)
                        )
                    }
                }

                Text(
                    text = "Prefixes",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                playerStats.second?.prefixes()?.sortedByDescending { it.second }?.forEach { prefix ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = prefix.first.name,
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            modifier = Modifier
                                .weight(1f)
                        )

                        Text(
                            text = "${prefix.second.roundToInt()}%",
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                        )
                    }
                }

                Text(
                    text = "Suffixes",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                playerStats.second?.suffixes()?.sortedByDescending { it.second }?.forEach { suffix ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = suffix.first.name,
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                            modifier = Modifier
                                .weight(1f)
                        )

                        Text(
                            text = "${suffix.second.roundToInt()}%",
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                            ),
                        )
                    }
                }
            }
        }
    }
}