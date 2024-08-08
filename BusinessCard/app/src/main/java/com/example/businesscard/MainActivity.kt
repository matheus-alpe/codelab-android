package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(Modifier.weight(1f))
                InfoCard(Modifier.weight(1f))
                ContactCard(
                    Modifier
                        .weight(1f)
                        .padding(bottom = 26.dp)
                )
            }
        }
    }
}

@Composable
fun InfoCard(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        ProfileImage(
            Modifier
                .fillMaxSize(fraction = 0.5f)
                .background(Color(0xFF01202d))
                .weight(1f)
        )
        Text(
            text = stringResource(R.string.card_full_name),
            fontSize = 32.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.card_title),
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ProfileImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier,
    ) {
        ContactRow(
            icon = Icons.Rounded.Call,
            text = stringResource(R.string.contact_phone)
        )

        ContactRow(
            icon = Icons.Rounded.Share,
            text = stringResource(R.string.contact_share)
        )

        ContactRow(
            icon = Icons.Rounded.Email,
            text = stringResource(R.string.contact_email),
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier.padding(vertical = 8.dp)) {
        Icon(icon, contentDescription = "Contact Icon", Modifier.padding(end = 16.dp))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Content()
}