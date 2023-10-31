package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {

    var currentPic by remember { mutableStateOf(1) }

    when (currentPic) {
        1 -> ArtCard(
            titleResource = R.string.title,
            textResource = R.string.caption,
            imageResourceId = R.drawable.pic1
        )

        2 -> ArtCard(
            titleResource = R.string.title2,
            textResource = R.string.caption2,
            imageResourceId = R.drawable.pic2
        )

        3 -> ArtCard(
            titleResource = R.string.title3,
            textResource = R.string.caption3,
            imageResourceId = R.drawable.pic3
        )

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {
            currentPic--
            if(currentPic < 1){
                currentPic = 3
            }
        }) {
            Text("Previous")
        }
        Button(onClick = {
            currentPic++
            if(currentPic > 3){
                currentPic = 1
            }
        }) {
            Text("Next")


        }

    }




}

@Composable
fun ArtCard(
    titleResource: Int,
    textResource: Int,
    imageResourceId: Int,
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier.wrapContentSize()
        )
        {

            Image(
                painter = painterResource(id = imageResourceId), contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
                    .padding(32.dp)
            )


        }

        Spacer(modifier = Modifier.height(32.dp))

        Card {
            Column(modifier = Modifier.padding(20.dp)) {

                Text(
                    text = stringResource(id = titleResource),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = textResource),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )



            }

        }





    }


}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        Surface {
            ArtSpace()
        }
    }
}