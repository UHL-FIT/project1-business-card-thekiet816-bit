package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    // Bao quanh toàn bộ bằng một Box để căn giữa Card vào màn hình
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)), // Màu nền xanh nhạt cho dễ nhìn
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 1. Ảnh đại diện (Dùng icon mặc định của Android cho tiện)
            Image(
                painter = painterResource(id = android.R.drawable.btn_star_big_on),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            // 2. Dòng chữ Android Studio dưới Avatar
            Text(
                text = "Android Studio",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3DDC84) // Màu xanh đặc trưng của Android
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 3. Họ và tên
            Text(
                text = "NGUYỄN THẾ KIỆT",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 4. Thông tin liên hệ
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "📞 0123 456 8910", fontSize = 16.sp)
                Text(text = "✉️ thekiet816@@gmail.com", fontSize = 16.sp)
            }
        }
    }
