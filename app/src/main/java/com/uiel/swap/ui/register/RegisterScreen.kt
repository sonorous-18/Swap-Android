package com.uiel.swap.ui.register

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapColoredButton
import com.uiel.swap.design_system.clickable
import com.uiel.swap.design_system.inputfield.SwapTextField

@Composable
fun RegisterScreen(
    navController: NavController,
) {
    var selectedPhotos by remember { mutableStateOf(listOf<Uri>()) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            if (selectedPhotos.size < 5) {
                selectedPhotos = selectedPhotos + it
            }
        }
    }
    var productName by remember { mutableStateOf("") }
    var usingTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(SwapColor.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navController.navigateUp() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            SwapText(
                text = "내 자전거 등록",
                style = SwapTypography.BodyLarge,
                color = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 8.dp,
                )
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = SwapColor.gray0,
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // 사진 추가 버튼
                if (selectedPhotos.size < 5) {
                    Column(
                        modifier = Modifier
                            .size(54.dp)
                            .background(
                                shape = RoundedCornerShape(12.dp),
                                color = SwapColor.gray200,
                            )
                            .clickable(
                                onClick = { galleryLauncher.launch("image/*") }
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_camera),
                            contentDescription = null
                        )
                        SwapText(
                            text = "${selectedPhotos.size}/5",
                            style = SwapTypography.LabelSmall,
                        )
                    }
                }
                // 추가된 사진들 표시
                for (photoUri in selectedPhotos) {
                    AsyncImage(
                        model = photoUri,
                        contentDescription = null,
                        modifier = Modifier
                            .size(54.dp)
                            .padding(8.dp)
                            .clip(shape = RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            SwapTextField.Text(
                value = productName,
                onValueChange = { productName = it },
                label = "상품명"
            )
            Spacer(modifier = Modifier.height(24.dp))
            SwapTextField.Text(
                value = usingTime,
                onValueChange = { usingTime = it },
                label = "자전거 사용 기간"
            )
            Spacer(modifier = Modifier.height(24.dp))
            SwapText(
                text = "분류",
                style = SwapTypography.LabelMedium,
                color = SwapColor.gray800
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                SwapColoredButton(
                    text = "전기자전거",
                    onClick = { },
                    shape = RoundedCornerShape(50.dp),
                )
                Spacer(modifier = Modifier.width(12.dp))
                SwapColoredButton(
                    text = "전기자전거",
                    onClick = { },
                    shape = RoundedCornerShape(50.dp),
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        SwapColoredButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 20.dp),
            text = "완료"
        ) {
            navController.navigate("mypage")
        }
    }
}
