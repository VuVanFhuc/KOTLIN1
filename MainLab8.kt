package ph34858.laptrinhkotlin.lab8Ph34858

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph34858.laptrinhkotlin.lab8Ph34858.ui.screen.ScreenNavigation
import ph34858.laptrinhkotlin.lab8Ph34858.ui.theme.LapTrinhKotLinTheme


class MainLab8 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LapTrinhKotLinTheme {
                Scaffold(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
                    ScreenNavigation()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier:Modifier=Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LapTrinhKotLinTheme {
        Greeting("Android")
    }
}