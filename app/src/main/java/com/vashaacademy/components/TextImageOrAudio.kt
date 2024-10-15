package com.vashaacademy.components

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.vashaacademy.R

@Composable
fun SingleOption(
    modifier: Modifier = Modifier,
    optionIdentifier: String = "A",
    optionText : String? = null, // "YEs, I know.",
    imageUrl: String? = null, //"https://media.istockphoto.com/id/1696167872/photo/aerial-view-of-forest-at-sunset-on-the-background-of-mountains-in-dolomites.jpg?s=612x612&w=is&k=20&c=mW0RiTTyqnRnmuIq4OfqIpRqCtPNqtaoTG_DUDzDCSQ=",
    audiourl: String? = " "
){

    var isImagePreview by remember { mutableStateOf(false) }
    var isAudioPlayedOnce by remember { mutableStateOf(false) }
    var isAudioPlaying by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val mediaPlayer = MediaPlayer()

    if (isImagePreview){
        Dialog(
            onDismissRequest = { isImagePreview = false }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                IconButton(
                    onClick = { isImagePreview = false },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }

                AsyncImage(
                    model = imageUrl,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp),
                    contentDescription = null,
                )
            }
        }
    }

    Row(
        modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("$optionIdentifier.",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Column(
            modifier = Modifier
                .then(modifier)
                .padding(horizontal = 10.dp)
                .padding(bottom = 1.dp)
        ){
            if (optionText != null){
                Text(
                    text = optionText,
                    fontSize = 18.sp
                )
            }
            else if(imageUrl != null){
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .height(90.dp)
                )
            }else if(audiourl != null){
                Button(
                    onClick = {
                        try{
                            mediaPlayer.setDataSource(context, Uri.parse(audiourl))
                            mediaPlayer.prepareAsync()
                            mediaPlayer.start()
                            isAudioPlaying = true
                            mediaPlayer.setOnCompletionListener {
                                isAudioPlayedOnce = true
                                isAudioPlaying = false
                            }

                        }catch (err: Exception){
                            err.printStackTrace()
                        }
                    },
                    enabled = !isAudioPlayedOnce
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_spatial_audio_off_24),
                        contentDescription = " "
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        if (isAudioPlaying) "Listening..."
                        else if (isAudioPlayedOnce) "Completed"
                        else "Listen"
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun TextImageOrBothPrev() {
    SingleOption()
}