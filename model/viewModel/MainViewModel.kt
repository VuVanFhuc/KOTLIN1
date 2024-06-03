package ph34858.laptrinhkotlin.lab7Ph34858.model.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ph34858.laptrinhkotlin.lab7Ph34858.model.entities.Movie

class MainViewModel: ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies
    init {
        _movies.value = Movie.getSampleMovies()
    }
}