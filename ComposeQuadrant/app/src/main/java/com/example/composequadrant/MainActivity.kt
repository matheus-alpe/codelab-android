package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.Purple100
import com.example.composequadrant.ui.theme.Purple200
import com.example.composequadrant.ui.theme.Purple300
import com.example.composequadrant.ui.theme.Purple400

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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Quadrant()
    }
}

@Composable
fun Quadrant() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(R.string.text_composable_title),
                description = stringResource(R.string.text_composable_description),
                background = Purple200,
                modifier = Modifier.weight(1f),
            )
            Card(
                title = stringResource(R.string.image_composable_title),
                description = stringResource(R.string.image_composable_description),
                background = Purple300,
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(R.string.row_composable_title),
                description = stringResource(R.string.row_composable_description),
                background = Purple400,
                modifier = Modifier.weight(1f),
            )
            Card(
                title = stringResource(R.string.column_composable_title),
                description = stringResource(R.string.column_composable_description),
                background = Purple100,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun Card(
    title: String,
    description: String,
    background: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Content()
}