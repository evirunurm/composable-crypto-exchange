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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.ui.molecules.Header
import com.quinientoscuarenta.myjcapplication.ui.organisms.CoinExchangeCalculator
import com.quinientoscuarenta.myjcapplication.ui.organisms.ExchangeCoin
import com.quinientoscuarenta.myjcapplication.ui.theme.GenuineTheme
import com.quinientoscuarenta.myjcapplication.ui.theme.LocalCustomColors
import com.quinientoscuarenta.myjcapplication.ui.theme.customColorsScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Encapsulate the page in a Custom theme provider. Similar to how React Context works.
            GenuineTheme(customColorsScheme()) {
                // This app data is just to give a use example.
                var coins by rememberSaveable {
                    mutableStateOf(
                        arrayOf(
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
                    )
                }

                val onSwitchCoins = {
                    // We have to create a copy of the list to trigger a recomposition.
                    // This is because the list itself is not being modified, only its content.
                    coins = coins.copyOf().apply {
                        reverse()
                    }
                }

                // Scaffold is a pre-built layout that follows Material Design guidelines.
                // Here we're using it to get the inner padding of the screen.
                Scaffold() { innerPadding ->
                    Column(
                        // Setup basic page styling.
                        modifier = Modifier
                            .fillMaxSize()
                            // Set background to theme background color
                            .background(LocalCustomColors.current.genericBlack)
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
                        CoinExchangeCalculator(coins, onSwitchCoins)
                    }
                }
            }
        }
    }
}


