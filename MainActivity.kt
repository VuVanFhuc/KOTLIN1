package ph34858.laptrinhkotlin.lab7Ph34858

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import ph34858.laptrinhkotlin.R
import ph34858.laptrinhkotlin.lab7Ph34858.model.viewModel.MainViewModel
import ph34858.laptrinhkotlin.lab7Ph34858.ui.screens.ScreenNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel: MainViewModel = viewModel()
            val moviesState =
                mainViewModel.movies.observeAsState(initial = emptyList())
//            MovieScreen(moviesState.value)


            ScreenNavigation()

        }
    }
}