package org.fantasy.league.dota2.stats.presentation.my_emblems

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.fantasy.league.dota2.core.common.Filter
import org.fantasy.league.dota2.core.common.Role
import org.fantasy.league.dota2.core.common.blueEmblems
import org.fantasy.league.dota2.core.common.greenEmblems
import org.fantasy.league.dota2.core.common.redEmblems
import org.fantasy.league.dota2.core.presentation.splash.SplashScreenViewModel
import org.fantasy.league.dota2.stats.presentation.components.CalculatorPlayerCard
import org.fantasy.league.dota2.stats.presentation.components.SimpleDropdown
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.roundToInt

@Composable
fun MyEmblemsScreen(
    splashScreenViewModel: SplashScreenViewModel = koinViewModel(),
    myEmblemsViewModel: MyEmblemsViewModel = koinViewModel()
) {
    val allPlayerStats = splashScreenViewModel.playerStats
    val roleSelected = myEmblemsViewModel.selectedRole
    val filterSelected = myEmblemsViewModel.selectedFilter

    //Core
    val firstCoreRedEmblem = myEmblemsViewModel.firstCoreRedEmblem
    val firstCoreRedEmblemPercent = myEmblemsViewModel.firstCoreRedEmblemPercent
    val secondCoreRedEmblem = myEmblemsViewModel.secondCoreRedEmblem
    val secondCoreRedEmblemPercent = myEmblemsViewModel.secondCoreRedEmblemPercent
    val firstCoreGreenEmblem = myEmblemsViewModel.firstCoreGreenEmblem
    val firstCoreGreenEmblemPercent = myEmblemsViewModel.firstCoreGreenEmblemPercent

    val corePlayersStats = myEmblemsViewModel.corePlayersStats

    //Mid
    val midRedEmblem = myEmblemsViewModel.midRedEmblem
    val midRedEmblemPercent = myEmblemsViewModel.midRedEmblemPercent
    val midGreenEmblem = myEmblemsViewModel.midGreenEmblem
    val midGreenEmblemPercent = myEmblemsViewModel.midGreenEmblemPercent
    val midBlueEmblem = myEmblemsViewModel.midBlueEmblem
    val midBlueEmblemPercent = myEmblemsViewModel.midBlueEmblemPercent

    val midPlayersStats = myEmblemsViewModel.midPlayersStats

    //Support
    val support1BlueEmblem = myEmblemsViewModel.support1BlueEmblem
    val support1BlueEmblemPercent = myEmblemsViewModel.support1BlueEmblemPercent
    val supportGreenEmblem = myEmblemsViewModel.supportGreenEmblem
    val supportGreenEmblemPercent = myEmblemsViewModel.supportGreenEmblemPercent
    val support2BlueEmblem = myEmblemsViewModel.support2BlueEmblem
    val support2BlueEmblemPercent = myEmblemsViewModel.support2BlueEmblemPercent

    val supportPlayersStats = myEmblemsViewModel.supportPlayersStats

    val scrollState = rememberLazyListState()

    LaunchedEffect(allPlayerStats) {
        myEmblemsViewModel.setAllPlayersStats(allPlayerStats.value.toMutableList())
    }

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    GlobalScope.launch(Dispatchers.Main) {
                        scrollState.scrollBy(delta)
                    }
                },
            ),
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            myEmblemsViewModel.selectRole(Role.CORE)
                        }
                        .background(
                            color = if (roleSelected.value == Role.CORE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Core",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = if (roleSelected.value == Role.CORE) Color.White else Color.Black
                        ),
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            myEmblemsViewModel.selectRole(Role.MID)
                        }
                        .background(
                            color = if (roleSelected.value == Role.MID) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Mid",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = if (roleSelected.value == Role.MID) Color.White else Color.Black
                        ),
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.33f)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            myEmblemsViewModel.selectRole(Role.SUPPORT)
                        }
                        .background(
                            color = if (roleSelected.value == Role.SUPPORT) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Support",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = if (roleSelected.value == Role.SUPPORT) Color.White else Color.Black
                        ),
                    )
                }
            }
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Filter by:",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            myEmblemsViewModel.selectFilter(Filter.BY_AVERAGE)
                        }
                        .background(
                            color = if (filterSelected.value == Filter.BY_AVERAGE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 6.dp, horizontal = 12.dp)
                ) {
                    Text(
                        text = "By average",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = if (filterSelected.value == Filter.BY_AVERAGE) Color.White else Color.Black
                        ),
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            myEmblemsViewModel.selectFilter(Filter.BY_TOP)
                        }
                        .background(
                            color = if (filterSelected.value == Filter.BY_TOP) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                        )
                        .border(
                            1.dp,
                            Color(0xFF3F1818),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 6.dp, horizontal = 12.dp)
                ) {
                    Text(
                        text = "By top",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = if (filterSelected.value == Filter.BY_TOP) Color.White else Color.Black
                        ),
                    )
                }
            }
        }

        if (roleSelected.value == Role.CORE) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = firstCoreRedEmblem.value,
                        options = redEmblems,
                        borderColor = Color(0xFF950606),
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setFirstCoreRedEmblem(emblemSelected)
                        },
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = firstCoreRedEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setFirstCoreRedEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = firstCoreGreenEmblem.value,
                        options = greenEmblems,
                        borderColor = Color(0xFF06402B),
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setFirstCoreGreenEmblem(emblemSelected)
                        },
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = firstCoreGreenEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setFirstCoreGreenEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = secondCoreRedEmblem.value,
                        options = redEmblems,
                        borderColor = Color(0xFF950606),
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setSecondCoreRedEmblem(emblemSelected)
                        },
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = secondCoreRedEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setSecondCoreRedEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = {
                            myEmblemsViewModel.calculateCorePlayerStats(
                                allPlayerStats = splashScreenViewModel.playerStats.value
                            )
                        },
                    ) {
                        Text(
                            text = "Calculate",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                }
            }

            items(corePlayersStats.value) { playerStat ->
                CalculatorPlayerCard(playerStat)
            }
        } else if (roleSelected.value == Role.MID) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = midRedEmblem.value,
                        options = redEmblems,
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setMidRedEmblem(emblemSelected)
                        },
                        borderColor = Color(0xFF950606),
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = midRedEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setMidRedEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = midGreenEmblem.value,
                        options = greenEmblems,
                        borderColor = Color(0xFF06402B),
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setMidGreenEmblem(emblemSelected)
                        },
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = midGreenEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setMidGreenEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = midBlueEmblem.value,
                        options = blueEmblems,
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setMidBlueEmblem(emblemSelected)
                        },
                        borderColor = Color.Blue,
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = midBlueEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setMidBlueEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = {
                            myEmblemsViewModel.calculateMidPlayerStats(
                                allPlayerStats = splashScreenViewModel.playerStats.value
                            )
                        },
                    ) {
                        Text(
                            text = "Calculate",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                }
            }

            items(midPlayersStats.value) { playerStat ->
                CalculatorPlayerCard(playerStat)
            }
        } else if (roleSelected.value == Role.SUPPORT) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = support1BlueEmblem.value,
                        options = blueEmblems,
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setSupport1BlueEmblem(emblemSelected)
                        },
                        borderColor = Color.Blue,
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = support1BlueEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setSupport1BlueEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = supportGreenEmblem.value,
                        options = greenEmblems,
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setSupportGreenEmblem(emblemSelected)
                        },
                        borderColor = Color(0xFF06402B),
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = supportGreenEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setSupportGreenEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    SimpleDropdown(
                        selectedEmblem = support2BlueEmblem.value,
                        options = blueEmblems,
                        onSelected = { emblemSelected ->
                            myEmblemsViewModel.setSupport2BlueEmblem(emblemSelected)
                        },
                        borderColor = Color.Blue,
                        modifier = Modifier
                            .weight(0.6f)
                    )

                    OutlinedTextField(
                        value = support2BlueEmblemPercent.value?.roundToInt()?.toString() ?: "",
                        placeholder = {
                            Text(
                                "Buff, %"
                            )
                        },
                        onValueChange = { newPercent ->
                            myEmblemsViewModel.setSupport2BlueEmblemPercent(newPercent.toFloatOrNull())
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .weight(0.4f)
                    )
                }
            }

            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = {
                            myEmblemsViewModel.clearSupportList()
                            myEmblemsViewModel.calculateSupportPlayerStats(
                                allPlayerStats = splashScreenViewModel.playerStats.value
                            )
                        },
                    ) {
                        Text(
                            text = "Calculate",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                            ),
                        )
                    }
                }
            }

            items(supportPlayersStats.value) { playerStat ->
                CalculatorPlayerCard(playerStat)
            }
        }
    }
}