package com.example.saeqalfirdaus.ui.screen

import android.R.attr.contentDescription
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.draw.rotate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.saeqalfirdaus.ui.screen.ProfileScreen
import com.example.saeqalfirdaus.ui.theme.SaeqalFirdausTheme
import kotlinx.coroutines.launch

sealed class Screen(val title: String, val icon: ImageVector) {
    object Profile : Screen(title = "Profile saya", icon = Icons.Default.Person)
    object FromRegistrasi : Screen(
        title = "Form Registrasi",
        icon = Icons.Default.Class
    )
    object DaftarMahasiswa : Screen("Daftar Mahasiswa", Icons.Default.SupervisedUserCircle)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val items = listOf(
        Screen.Profile,
        Screen.FromRegistrasi,
        Screen.DaftarMahasiswa
    )

    val pageState = rememberPagerState(pageCount = {
        items.size
    })
    val coroutineScope = rememberCoroutineScope()
    var isMenuExpanded by remember { mutableStateOf(value = false) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                ),
                title = {
                    Text(
                        text = items[pageState.currentPage].title
                            .uppercase(),
                        style = MaterialTheme.typography.titleLarge
                            .copy(
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 1.sp
                            )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.Unspecified
                )

            )
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {items.forEachIndexed { index, screen ->
                AnimatedVisibility(
                    visible = isMenuExpanded,
                    enter = slideInVertically(initialOffsetY =
                        {it}) + fadeIn() + scaleIn(),
                    exit = slideOutVertically(targetOffsetY = {it})+ fadeOut()+
                            scaleOut()
                ) {
                    ExtendedFloatingActionButton(
                        onClick = {
                            coroutineScope.launch {
                                pageState.animateScrollToPage(index)
                                isMenuExpanded = false
                            }
                        },
                        containerColor = if (pageState.currentPage == index)
                            MaterialTheme.colorScheme.secondaryContainer
                        else Color.White,
                        contentColor = if(pageState.currentPage == index)
                            MaterialTheme.colorScheme.onSecondaryContainer
                        else MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(size = 16.dp),
                        elevation = FloatingActionButtonDefaults.elevation(
                            defaultElevation = 8.dp
                        ),
                        icon = { Icon(imageVector = screen.icon,
                            contentDescription = null, modifier = Modifier.size
                                (24.dp)) },
                        text = {
                            Text(
                                screen.title,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.height(100.dp),
                                textAlign = TextAlign.Center
                            )
                        },
                        modifier = Modifier.height(56.dp)
                    )
                }
            }
                FloatingActionButton(
                    onClick = {isMenuExpanded = !isMenuExpanded},
                    containerColor = if (isMenuExpanded) Color.White else
                        MaterialTheme.colorScheme.primary,
                    contentColor = if(isMenuExpanded) MaterialTheme.colorScheme
                        .primary else
                        Color.White,
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(
                        12.dp
                    ),
                    modifier = Modifier.size(60.dp)
                ) {
                    val rotasi by animateFloatAsState(
                        targetValue = if(isMenuExpanded) 45f else 0f,
                        animationSpec = spring(stiffness = Spring.StiffnessLow),
                        label = ""
                    )
                    Icon(
                        imageVector = if (isMenuExpanded) Icons.Default.Close else Icons.Default.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier.rotate(degrees = rotasi).size(24.dp)
                    )
                }

            }

        }
    ) { innerPadding ->
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            state = pageState,
            verticalAlignment = Alignment.Top,
            userScrollEnabled = !isMenuExpanded
        ) { page ->

            Box(modifier = Modifier.fillMaxSize()) {
                when (items[page]) {
                    is Screen.Profile -> ProfileScreen()
                    is Screen.FromRegistrasi -> FromRegistrasiScreen(
                        onSuccess = {
                            coroutineScope.launch {
                                pageState.animateScrollToPage(2)
                            }
                        }
                    )
                    is Screen.DaftarMahasiswa -> DaftarMahasiswaScreen()
                }
            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    SaeqalFirdausTheme {
        MainScreen()
    }
}