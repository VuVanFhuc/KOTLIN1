package ph34858.laptrinhkotlin.lab3Ph34858.baitaplab3



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph34858.laptrinhkotlin.R

class bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCard("VU VAN PHUC -PH34858")
        }
    }
}

@Composable
fun GreetingCard(initialMsg: String) {
    var text by remember { mutableStateOf(initialMsg) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard(msg = text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { text = "Hi!" }) {
            Text("Say Hi!")
        }
    }
}

@Composable
fun MessageCard(msg: String) {
    Text(
        text = msg,
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth(),
        color = Color.DarkGray,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}
