package ph34858.laptrinhkotlin.lab8Ph34858.model

import com.google.gson.annotations.SerializedName
import ph34858.laptrinhkotlin.lab8Ph34858.ui.screen.MovieFormData

class Movie(
    @SerializedName("id") val id: String,
    @SerializedName("filmName") val filmName: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("national") val national: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
) {
    fun toMovieFormData() = this?.let {
        MovieFormData(
            this.id,
            this.filmName,
            this.duration,
            this.releaseDate,
            this.genre,
            this.national,
            this.description,
            this.image
        )
    }
}