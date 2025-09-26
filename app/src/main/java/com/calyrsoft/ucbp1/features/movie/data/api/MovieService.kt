package com.calyrsoft.ucbp1.features.movie.data.api

import com.calyrsoft.ucbp1.features.movie.data.api.dto.MoviePageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/discover/movie" )
    suspend fun fetchPopularMovies(
        @Query("sort_by") sortBy : String = "popularity.desc",
        @Query("api_key") apiKey : String = "fa3e844ce31744388e07fa47c7c5d8c3") : Response<MoviePageDto>
}

//https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=fa3e844ce31744388e07fa47c7c5d8c3