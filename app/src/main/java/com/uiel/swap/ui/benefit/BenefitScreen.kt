package com.uiel.swap.ui.benefit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import com.uiel.swap.viewmodel.benefit.BenefitViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography

@Composable
fun BenefitScreen(
    viewModel: BenefitViewModel = viewModel(),
    onExternalPointClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PointsSection()

        TabSection(onExternalPointClick)

        MissionList()
    }
}

@Composable
private fun PointsSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = "지금까지 받은 포인트",
            style = SwapTypography.BodyLarge.copy(color = SwapColor.gray600)
        )
        Text(
            text = "1,200 P",
            style = SwapTypography.DisplaySmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White)
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "미션을 완료하면 자동으로 포인트가 들어와요",
                style = SwapTypography.BodyLarge.copy(color = SwapColor.gray600)
            )
        }
    }
}

@Composable
private fun TabSection(onExternalPointClick: () -> Unit) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF5F5F5))
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { selectedTabIndex = 0 }
                    .background(if (selectedTabIndex == 0) SwapColor.main500 else Color.Transparent)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "서비스 포인트",
                    color = if (selectedTabIndex == 0) Color.White else Color.DarkGray,
                    style = SwapTypography.TitleMedium
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        selectedTabIndex = 1
                        onExternalPointClick()
                    }
                    .background(if (selectedTabIndex == 1) SwapColor.main500 else Color.Transparent)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "외부 포인트",
                    color = if (selectedTabIndex == 1) Color.White else Color.DarkGray,
                    style = SwapTypography.TitleMedium
                )
            }
        }
    }
}

@Composable
private fun CircularProgressIndicator(
    percentage: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .drawBehind {
                val strokeWidth = 4.dp.toPx()
                val diameter = size.width

                drawCircle(
                    color = Color(0xFFF5F5F5),
                    radius = diameter / 2,
                    style = Stroke(strokeWidth)
                )

                drawArc(
                    color = SwapColor.gray600,
                    startAngle = -90f,
                    sweepAngle = 360 * percentage,
                    useCenter = false,
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
            }
    )
}

@Composable
private fun MissionList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(5) {
            MissionItem(
                isCompleted = false,
                progress = 75
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    color = SwapColor.gray300
                )
                Text(
                    text = "완료된 미션",
                    style = SwapTypography.BodyMedium.copy(color = SwapColor.gray450)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    color = SwapColor.gray300
                )
            }
        }

        items(2) {
            CompletedMissionItem()
        }
    }
}

@Composable
private fun MissionItem(
    isCompleted: Boolean = false,
    progress: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(48.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    percentage = progress / 100f,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = progress.toString(),
                    style = SwapTypography.TitleSmall
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "기기로 3km 이동하기",
                    style = SwapTypography.TitleMedium
                )
                Text(
                    text = "100 P",
                    style = SwapTypography.BodyMedium.copy(
                        color = SwapColor.gray450
                    )
                )
            }
        }
    }
}

@Composable
private fun CompletedMissionItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(48.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mission_complete),
                contentDescription = "Completed Mission Stamp",
                modifier = Modifier.size(40.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "기기로 3km 이동하기",
                    style = SwapTypography.TitleMedium
                )
                Text(
                    text = "100 P 획득 완료",
                    style = SwapTypography.BodyMedium.copy(
                        color = SwapColor.gray450
                    )
                )
            }
        }
    }
}