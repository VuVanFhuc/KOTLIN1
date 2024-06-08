package ph34858.laptrinhkotlin.lab8Ph34858.model

import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("id") var filmId: String? = null,
    val filmName: String,
    val duration: Int,
    val releaseDate: String,
    val genre: String,
    val national: String,
    val description: String,
    val image: String
)
data class StatusResponse(
    val status: Int,
    val message: String
){
}