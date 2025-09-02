package org.fantasy.league.dota2.stats.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.fantasy.league.dota2.core.common.CalculatorPlayerStats
import org.fantasy.league.dota2.core.common.Team
import org.fantasy.league.dota2.core.common.prefixes
import org.fantasy.league.dota2.core.common.suffixes
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

@Composable
fun CalculatorPlayerCard(
    playerStats: CalculatorPlayerStats
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
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
                    playerStats.playerStats.first.team.logoId
                ),
                contentDescription = "team_logo",
                modifier = Modifier
                    .size(60.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = playerStats.playerStats.first.name,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = "Average stats (${playerStats.playerAverageScore.roundToInt()})",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                Text(
                    text = "Top stats (${playerStats.playerTopScore.roundToInt()})",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )
            }
        }

        if (playerStats.playerStats.first.team == Team.Wildcart || playerStats.playerStats.first.team == Team.Nemesis) {
            Text(
                text = "Цей гравець з команди-аутсайдера. НЕ рекомендую обирати",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )
        }

        Text(
            text = "Prefixes",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(vertical = 4.dp)
        )

        playerStats.playerStats.second?.prefixes()?.sortedByDescending { it.second }?.take(5)?.forEach { prefix ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${prefix.first.name} | ${prefix.second.roundToInt()}%",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                )
            }
        }

        Text(
            text = "Suffixes",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(vertical = 4.dp)
        )

        Text(
            text = "Choose \"Of The Octopus\" over everything else / Завжди вибирайте \"Послідовник Восьминога\"",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
            ),
            modifier = Modifier
                .padding(bottom = 6.dp)
        )

        playerStats.playerStats.second?.suffixes()?.sortedByDescending { it.second }?.take(5)?.forEach { suffix ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${suffix.first.name} | ${suffix.second.roundToInt()}%",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                )
            }
        }
    }
}