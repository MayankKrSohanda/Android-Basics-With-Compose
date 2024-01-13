package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        TitleCard(
            name = stringResource(R.string.name_mayank_kumar_sohanda),
            title = stringResource(R.string.title_android_developer),
            image = painterResource(R.drawable.android_logo)
        )

        ContactInfoCard(
            phoneNumber = stringResource(R.string.phone_number),
            username = stringResource(R.string.username),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
fun TitleCard(
    name: String,
    title: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .background(Color(0xFF073042))
        )

        Text(
            text = name,
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = title,
            color = Color(0xFF1F7E4F)
        )
    }
}


@Composable
fun ContactInfoCard(
    phoneNumber: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
    ) {
        ContactInfo(
            info = phoneNumber,
            icon = Icons.Filled.Phone
        )

        ContactInfo(
            info = username,
            icon = Icons.Filled.Share
        )

        ContactInfo(
            info = email,
            icon = Icons.Filled.Email
        )
    }
}

@Composable
fun ContactInfo(
    info: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.width(320.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF1F7E4F),
            modifier = Modifier
                .padding(start = 100.dp, end = 8.dp)
        )

        Text(
            text = info,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFD2E8D4)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}

@Preview(showBackground = true)
@Composable
fun TitleCardPreview() {
    BusinessCardTheme {
        TitleCard(
            name = stringResource(R.string.name_mayank_kumar_sohanda),
            title = stringResource(R.string.title_android_developer),
            image = painterResource(R.drawable.android_logo)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoCardPreview() {
    BusinessCardTheme {
        ContactInfoCard(
            phoneNumber = stringResource(R.string.phone_number),
            username = stringResource(R.string.username),
            email = stringResource(R.string.email)
        )
    }
}