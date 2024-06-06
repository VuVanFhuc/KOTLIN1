package ph34858.laptrinhkotlin.labRoomDB

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ph34858.laptrinhkotlin.R

class MainRoomDB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayoutAppNavigation()
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {

}