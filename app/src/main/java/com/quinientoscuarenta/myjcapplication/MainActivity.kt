package com.quinientoscuarenta.myjcapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.molecules.Header
import com.quinientoscuarenta.myjcapplication.organisms.CoinExchangeCalculator
import com.quinientoscuarenta.myjcapplication.organisms.ExchangeCoin
import com.quinientoscuarenta.myjcapplication.ui.theme.MyJCApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJCApplicationTheme {
                val coins: Array<ExchangeCoin> = arrayOf(
                    ExchangeCoin(
                        name = "ETH",
                        value = 0.6948,
                        balance = 0.6948,
                        coinImageVector = Icons.Default.AccountCircle
                    ),
                    ExchangeCoin(
                        name = "BTH",
                        value = 0.6948,
                        balance = 0.6948,
                        coinImageVector = Icons.Default.AccountBox
                    )
                )
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 8.dp)
                    ) {
                        Header(
                            "Exchange",
                            onButtonClick = { /*TODO*/ },
                        )
                        Spacer(Modifier.height(18.dp))
                        CoinExchangeCalculator(coins)
                    }

                }
            }
        }
    }
}


