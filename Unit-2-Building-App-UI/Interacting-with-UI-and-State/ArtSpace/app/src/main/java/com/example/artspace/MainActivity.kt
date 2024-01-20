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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                ArtSpaceLayout()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier
) {
    var currentArtwork by remember {
        mutableIntStateOf(1)
    }

    val imageDrawable = when (currentArtwork) {
        1 -> R.drawable.gradient_smoky_wallpaper
        2 -> R.drawable.nature_landscape
        else -> R.drawable.portrait_sketch
    }

    val imageTitle = when (currentArtwork) {
        1 -> R.string.gradient_smoky_title
        2 -> R.string.nature_landscape_title
        else -> R.string.portrait_sketch_title
    }

    val imageArtist = when (currentArtwork) {
        1 -> R.string.gradient_smoky_artist
        2 -> R.string.nature_landscape_artist
        else -> R.string.portrait_sketch_artist
    }

    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkWall(
            painter = imageDrawable,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
        )

        ArtworkDescriptor(
            title = imageTitle,
            artist = imageArtist,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        DisplayController(
            onClickNext = {
                currentArtwork = when (currentArtwork) {
                    1 -> 2
                    2 -> 3
                    else -> 1
                }
            },
            onClickPrevious = {
                currentArtwork = when (currentArtwork) {
                    1 -> 3
                    2 -> 1
                    else -> 2
                }
            },
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
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ControllerButton(
    @StringRes label: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
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
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ControllerButton(
            label = R.string.previous_image_button,
            onClick = onClickPrevious
        )

        ControllerButton(
            label = R.string.next_image_button,
            onClick = onClickNext,
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

// Works well in Landscape mode as well.