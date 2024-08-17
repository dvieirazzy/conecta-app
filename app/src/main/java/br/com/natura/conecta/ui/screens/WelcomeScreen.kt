package br.com.natura.conecta.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getDrawable
import br.com.natura.conecta.R
import br.com.natura.conecta.model.OnBoardingPage
import br.com.natura.conecta.sampledata.onBoardingPages
import br.com.natura.conecta.ui.components.widgets.HorizontalPagerIndicator
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(onNavigateToLogin: () -> Unit = {}) {
    val pagerState = rememberPagerState(
        pageCount = { onBoardingPages.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Box(
        Modifier
            .background(Color.White)
            .systemBarsPadding()
    ) {
        Column(Modifier.fillMaxSize()) {
            HorizontalPager(
                modifier = Modifier
                    .weight(10f)
                    .padding(vertical = 22.dp),
                state = pagerState,
                verticalAlignment = Alignment.Top
            ) { position ->
                PagerScreen(onBoardingPage = onBoardingPages[position])
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .height(50.dp)
            ) {
                AnimatedVisibility(
                    visible = pagerState.currentPage != 3
                ) {
                    TextButton(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.pageCount - 1,
                                    animationSpec = tween(
                                        durationMillis = 600,
                                        easing = androidx.compose.animation.core.LinearOutSlowInEasing // Easing mais suave
                                    )
                                )
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Pular",
                            fontSize = 18.sp,
                            style = TextStyle(NaturaGradient),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                HorizontalPagerIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    pageCount = onBoardingPages.size,
                    currentPage = pagerState.currentPage
                )
                AnimatedVisibility(
                    visible = pagerState.currentPage != 3
                ) {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                                pagerState.animateScrollToPage(
                                    page = nextPage,
                                    animationSpec = tween(
                                        durationMillis = 600,
                                        easing = androidx.compose.animation.core.LinearOutSlowInEasing // Easing mais suave
                                    )
                                )
                            }
                        },
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                brush = NaturaGradient,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(12.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
            FinishButton(
                modifier = Modifier.weight(1f),
                pagerState = pagerState
            ) {
                onNavigateToLogin()
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.75f),
            painter = rememberDrawablePainter(
                drawable = getDrawable(context, onBoardingPage.image)
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = onBoardingPage.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        Spacer(modifier = Modifier
            .padding(top = 15.dp, bottom = 25.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(NaturaGradient)
            .fillMaxWidth(0.30f)
            .height(4.dp)
            .align(Alignment.CenterHorizontally)
        )
        Text(
            text = onBoardingPage.description,
            color = DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 3
        ) {
            Button(
                onClick = {
                    onClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            )
            {
                Row(
                    modifier = Modifier
                        .background(NaturaGradient)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Vamos Começar",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FirstOnBoardingPagePreview() {
    Column(Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = onBoardingPages[0])
    }
}

@Preview(showBackground = true)
@Composable
private fun SecondOnBoardingPagePreview() {
    Column(Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = onBoardingPages[1])
    }
}

@Preview(showBackground = true)
@Composable
private fun ThirdOnBoardingPagePreview() {
    Column(Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = onBoardingPages[2])
    }
}

@Preview(showBackground = true)
@Composable
private fun FourthOnBoardingPagePreview() {
    Column(Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = onBoardingPages[3])
    }
}
