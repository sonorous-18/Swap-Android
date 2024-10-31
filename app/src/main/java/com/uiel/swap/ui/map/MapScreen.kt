package com.uiel.swap.ui.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uiel.swap.viewmodel.map.MapViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapColoredButton

@Composable
fun MapScreen(
    viewModel: MapViewModel = viewModel()
) {
    val singapore = LatLng(36.353092, 127.344656)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 16f)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
//            Marker(
//                state = MarkerState(position = singapore),
//                title = "Singapore",
//                snippet = "Marker in Singapore"
//            )
        }
        Subscribe()
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(24.dp),
            painter = painterResource(id = R.drawable.b),
            contentDescription = null)
//        SmartControl(
//            modifier = Modifier.align(Alignment.BottomCenter)
//        )
    }
}

@Composable
private fun Subscribe(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(
                shape = RoundedCornerShape(50.dp),
                color = SwapColor.gray800,
            )
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            tint = SwapColor.main500,
        )
        Spacer(modifier = Modifier.width(8.dp))
        SwapText(
            text = "구독하면 실시간 기기 위치가 표시돼요",
            style = SwapTypography.BodyMedium,
            color = Color.White,
        )
    }
}

@Composable
private fun SmartControl(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = SwapColor.gray0
            )
            .padding(24.dp),
        //horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SwapText(
            text = "스마트 컨트롤",
            style = SwapTypography.TitleMedium,
            color = SwapColor.gray900,
        )
        Spacer(modifier = Modifier.height(2.dp))
        SwapText(
            text = "원하는 모빌리티를 등록하고\n실시간 위치 정보 및 제휴 서비스를 받아보세요",
            style = SwapTypography.BodyMedium,
            color = SwapColor.gray600,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 82.dp),
            painter = painterResource(id = R.drawable.img_bicycle),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        SwapColoredButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "한달 무료로 타보기",
            onClick = { },
            small = false,
        )
    }
}