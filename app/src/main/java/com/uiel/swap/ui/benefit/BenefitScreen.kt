package com.uiel.swap.ui.benefit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.uiel.swap.model.ChallengeListResponse

@Composable
fun BenefitScreen(
    viewModel: BenefitViewModel = viewModel(),
    onExternalPointClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getChallenge()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SwapColor.background)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PointsSection()

        TabSection(onExternalPointClick)

        MissionList(
            challenge = uiState.challenge
        )
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
            style = SwapTypography.BodyLarge,
            color = SwapColor.gray600,
        )
        Text(
            text = "1,200 P",
            style = SwapTypography.DisplaySmall,
            modifier = Modifier.padding(vertical = 8.dp),
            color = SwapColor.gray900,
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
            .background(SwapColor.gray0)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        if (selectedTabIndex == 0) SwapColor.main500 else Color.Transparent
                    )
                    .padding(vertical = 8.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { selectedTabIndex = 0 }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "서비스 포인트",
                    color = if (selectedTabIndex == 0) Color.White else SwapColor.gray600,
                    style = if (selectedTabIndex == 0) SwapTypography.TitleMedium else SwapTypography.BodyLarge,
                    modifier = Modifier
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        if (selectedTabIndex == 1) SwapColor.main500 else Color.Transparent
                    )
                    .padding(vertical = 8.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            selectedTabIndex = 1
                            onExternalPointClick()
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "외부 포인트",
                    color = if (selectedTabIndex == 1) Color.White else SwapColor.gray600,
                    style = if (selectedTabIndex == 1) SwapTypography.TitleMedium else SwapTypography.BodyLarge,

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
                    color = SwapColor.gray200,
                    radius = diameter / 2,
                    style = Stroke(strokeWidth)
                )

                drawArc(
                    color = SwapColor.main500,
                    startAngle = -90f,
                    sweepAngle = (percentage * 3.6).toFloat(),
                    useCenter = false,
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
            }
    )
}

@Composable
private fun MissionList(
    challenge: List<ChallengeListResponse>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(challenge.filter { !it.isClear }) {
            MissionItem(
                title = it.title,
                point = it.point,
                percentage = it.percentage,
                isCompleted = it.isClear,
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
                    style = SwapTypography.TitleMedium.copy(color = SwapColor.gray450)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    color = SwapColor.gray300
                )
            }
        }

        items(challenge.filter { it.isClear }) {
            CompletedMissionItem(
                title = it.title,
                point = it.point,
            )
        }
    }
}

@Composable
private fun MissionItem(
    title: String,
    point: Int,
    isCompleted: Boolean = false,
    percentage: Int
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
                    percentage = percentage.toFloat(),
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = percentage.toString(),
                    style = SwapTypography.TitleSmall,
                    color = SwapColor.gray900,
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = title,
                    style = SwapTypography.TitleMedium,
                    color = Color.Black,
                )
                Text(
                    text = "$point P",
                    style = SwapTypography.BodyMedium.copy(
                        color = SwapColor.gray450
                    )
                )
            }
        }
    }
}

@Composable
private fun CompletedMissionItem(
    title: String,
    point: Int,
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
                    text = title,
                    style = SwapTypography.TitleMedium,
                    color = Color.Black,
                )
                Text(
                    text = "$point P 획득 완료",
                    style = SwapTypography.BodyMedium.copy(
                        color = SwapColor.gray450
                    )
                )
            }
        }
    }
}