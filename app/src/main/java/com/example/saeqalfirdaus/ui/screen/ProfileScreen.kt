package com.example.saeqalfirdaus.ui.screen

import android.R.attr.icon
import android.R.attr.onClick
import androidx.compose.foundation.Image
import com.example.saeqalfirdaus.ui.theme.SaeqalFirdausTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saeqalfirdaus.R


@Composable
fun ProfileScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.onSecondary,
                    )
                )
            )
    ){
// start code box hytam
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                        )
                    ),
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd =20.dp)
                )
        )
// end code box hytam
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, bottom = 40.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            // start Card kotak putih
            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 60.dp),
                shape = RoundedCornerShape(size = 24.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                // Column isi card: nama, nim, bio
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 50.dp, bottom = 30.dp, start = 20.dp, end = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //     statr Teks nama
                    Text(
                        text = "Muh.Saeqal fidaus",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineMedium
                            .copy(
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface,
                            ),
                        textAlign = TextAlign.Center
                    )
                    //     end Teks nama

                // start text nim
                    Text(
                        text = "2232800",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.primary,
                            ),
                        textAlign = TextAlign.Center
                    )
                    // end text nim

                    // start garis pemisah
                    Spacer(modifier = Modifier.height(16.dp)) // jarak kosong vertikal

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(0.3f),
                        thickness = 3.dp,
                        color = MaterialTheme.colorScheme.primaryContainer,
                    )
                    // end garis pemisah


                    Spacer(modifier = Modifier.height(16.dp))

                    // start text untuk bio
                    Text(
                        text = "Saya adalah mahasiswa it dari universitas muhammadiyah parepare dan saat ini saya sedang fokus di bidang mobile dev",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 24.sp
                    )
                    // end text untuk bio

                    Spacer(modifier = Modifier.height(32.dp))

                    //start label untuk tombol icon
                    Text(
                        text = "hubungi saya",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    )
                    //end label untuk tombol icon

                    Spacer(modifier = Modifier.height(12.dp))
                    //start baris horizontal unutk tombol2 sosial media
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    //end baris horizontal unutk tombol2 sosial media
                    {
                        // start tombol sosmet
                        SocialButton(
                            icon = Icons.Filled.Phone,
                            contentDescription = "WhatsApp",
                            color = Color(0xFF25D366),
                            onClick = {}
                        )
                        SocialButton(
                            icon = Icons.Filled.CameraAlt,
                            contentDescription = "WhatsApp",
                            color = Color(0xFFFF0000),
                            onClick = {}
                        )
                        SocialButton(
                            icon = Icons.Filled.Apartment,
                            contentDescription = "WhatsApp",
                            color = Color(0xFF87CEEB),
                            onClick = {}
                        )
                    }
                }
            }
            // end Card kotak putih

            // start circle gambar
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .border(width = 4.dp, color = MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
            ){
                // start content atau image di dalam cirle
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "foto profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()

                )
                // end image
            }
            // end circle gambar

        }
    }
}



@Composable
fun SocialButton(
    icon: ImageVector,
    contentDescription: String,
    color: Color,
    onClick: () -> Unit = {}
){
    // icon jadi bundar
    Surface(
        shape = CircleShape,
        color = color.copy(alpha = 0.1f),
        modifier = Modifier.size(50.dp),
        onClick = onClick
    ) {
        Box(contentAlignment = Alignment.Center){
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
// end untuk social button



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    SaeqalFirdausTheme{
        ProfileScreen()
    }
}