package ph34858.laptrinhkotlin.lab8Ph34858.service

import ph34858.laptrinhkotlin.lab8Ph34858.model.MovieRequest
import ph34858.laptrinhkotlin.lab8Ph34858.model.StatusResponse
import ph34858.laptrinhkotlin.lab8Ph34858.response.MovieResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MovieService {
    @GET("Film")
    suspend fun getListFilms(): Response<List<MovieResponse>>

    @GET("Film/{id}")
    suspend fun getFilmDetail(@Path("id") id: String): Response<MovieResponse>

    @POST("Film")
    suspend fun addFilm(@Body filmRequest: MovieRequest): Response<StatusResponse>

    @PUT("Film/{id}")
    suspend fun updateFilm(
        @Path("id") id: String,
        @Body filmRequest: MovieRequest
    ): Response<StatusResponse>

    @DELETE("Film/{id}")
    suspend fun deleteFilm(@Path("id") id: String): Response<StatusResponse>
}