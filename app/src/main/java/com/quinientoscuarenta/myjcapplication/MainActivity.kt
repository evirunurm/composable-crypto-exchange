package com.quinientoscuarenta.myjcapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.atoms.ExchangeCardButton
import com.quinientoscuarenta.myjcapplication.designsystem.molecules.ExchangeCard
import com.quinientoscuarenta.myjcapplication.designsystem.molecules.Header
import com.quinientoscuarenta.myjcapplication.ui.theme.MyJCApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJCApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Header(
                            "Exchange",
                            onButtonClick = { /*TODO*/ },
                        )
                        Spacer(Modifier.height(18.dp))
                        ExchangeCard(
                            coinImageVector = Icons.Default.AccountCircle,
                            coinName = "BTH",
                            coinValue = "0,6948",
                            coinBalance = "0.6948 ETH",
                            mainButton = { modifier ->
                                ExchangeCardButton(
                                    text = "Send",
                                    onClick = { /*TODO*/ },
                                    modifier = modifier
                                )
                            },
                            secondaryButton = { modifier ->
                                ExchangeCardButton(
                                    text = "Max",
                                    onClick = { /*TODO*/ },
                                    modifier = modifier
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}


