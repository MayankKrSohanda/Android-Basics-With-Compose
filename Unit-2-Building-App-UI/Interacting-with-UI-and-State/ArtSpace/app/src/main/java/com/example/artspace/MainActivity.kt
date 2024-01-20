package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtworkWallPreview()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkWall(
            painter = R.drawable.gradient_smoky_wallpaper,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
        )

        ArtworkDescriptor(
            title = R.string.gradient_smoky_title,
            artist = R.string.artist,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        DisplayController(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes painter: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(160.dp)
            .border(2.dp, Color.Gray, RectangleShape)
    ) {
        Image(
            painter = painterResource(painter),
            contentDescription = null
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes title: Int,
    @StringRes artist: Int,
    modifier: Modifier = Modifier
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            ) {
                append(stringResource(title))
            }

            append(" - ")

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )
            ) {
                append(stringResource(artist))
            }
        },
        modifier = modifier
    )
}

@Composable
fun ControllerButton(
    @StringRes label: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = modifier
            .size(width = 136.dp, height = 36.dp)
    ) {
        Text(
            text = stringResource(label)
        )
    }
}

@Composable
fun DisplayController(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ControllerButton(
            label = R.string.previous_image_button
        )

        ControllerButton(
            label = R.string.next_image_button,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkWallPreview() {
    ArtSpaceLayout()
}