package com.quinientoscuarenta.myjcapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.ui.molecules.Header
import com.quinientoscuarenta.myjcapplication.ui.organisms.CoinExchangeCalculator
import com.quinientoscuarenta.myjcapplication.ui.organisms.ExchangeCoin
import com.quinientoscuarenta.myjcapplication.ui.theme.GenuineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Encapsulate the page in a Custom theme provider. Similar to how React Context works.
            GenuineTheme {
                // This app data is just to give a use example.
                val coins: Array<ExchangeCoin> = arrayOf(
                    ExchangeCoin(
                        name = "ETH",
                        value = 0.6948,
                        balance = 0.6948,
                        coinImageVector = Icons.Default.AccountCircle
                    ),
                    ExchangeCoin(
                        name = "USD",
                        value = 1801.73,
                        balance = 100.95,
                        coinImageVector = Icons.Default.AccountBox
                    )
                )
                // Scaffold is a pre-built layout that follows Material Design guidelines.
                // Here we're using it to get the inner padding of the screen.
                Scaffold() { innerPadding ->
                    Column(
                        // Setup basic page styling.
                        modifier = Modifier
                            .fillMaxSize()
                            // Set background to theme background color
                            .background(GenuineTheme.colors.background)
                            // Set inner padding passed by Scaffold,
                            // so that the content is not drawn under the status bar.
                            .padding(innerPadding)
                            // Add some padding near the edges of the screen.
                            .padding(8.dp, 12.dp)
                    ) {
                        // Not using the AppBar provided by Scaffold, because the second page of the reference doesn't have it.
                        Header(onButtonClick = { /*TODO*/ }) {
                            Title("Exchange")
                        }
                        Spacer(Modifier.height(18.dp))
                        CoinExchangeCalculator(coins)
                    }
                }
            }
        }
    }
}


