package org.fantasy.league.dota2.stats.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import fantasyleaguedota.composeapp.generated.resources.Res
import fantasyleaguedota.composeapp.generated.resources.arrow_down
import org.fantasy.league.dota2.core.common.Emblems
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdown(
    selectedEmblem: Emblems,
    options: List<Emblems?>,
    borderColor: Color,
    label: String = "Select emblem",
    onSelected: (Emblems) -> Unit,
    modifier: Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember(selectedEmblem) {
        mutableStateOf(selectedEmblem)
    }

    var rowSize by remember { mutableStateOf(Size.Zero) }

    val safeOptions = remember(options) { options.filterNotNull() }

    Column(
        modifier
            .onGloballyPositioned { layoutCoordinates ->
                rowSize = layoutCoordinates.size.toSize()
            }
    ) {
//        Text(
//            text = label,
//            style = TextStyle(
//                fontSize = 14.sp
//            ),
//            modifier = Modifier
//                .padding(bottom = 8.dp),
//        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .defaultMinSize(minHeight = 56.dp)
                .border(
                    1.dp,
                    color = borderColor,
                    RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.background)
                .padding(vertical = 14.dp, horizontal = 12.dp)
        ) {
            Text(
                text = selected.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .weight(1f)
            )

            Image(
                painter = painterResource(Res.drawable.arrow_down),
                contentDescription = "Expand menu",
                modifier = Modifier
                    .size(18.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { rowSize.width.toDp() })
                .heightIn(0.dp, 250.dp)
        ) {
            safeOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.title) },
                    onClick = {
                        selected = option
                        expanded = false
                        onSelected(option)
                    }
                )
            }
        }
    }
}