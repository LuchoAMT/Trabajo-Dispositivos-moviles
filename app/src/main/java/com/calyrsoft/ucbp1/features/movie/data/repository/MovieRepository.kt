package com.calyrsoft.ucbp1.features.movie.data.repository

import com.calyrsoft.ucbp1.features.movie.data.database.dao.MovieDao
import com.calyrsoft.ucbp1.features.movie.data.datasource.MovieRemoteDataSource
import com.calyrsoft.ucbp1.features.movie.data.mapper.toEntity
import com.calyrsoft.ucbp1.features.movie.data.mapper.toModel
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel
import com.calyrsoft.ucbp1.features.movie.domain.repository.IMoviesRepository

class MovieRepository(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieDao: MovieDao
) : IMoviesRepository {

    override suspend fun fetchPopularMovies(): Result<List<MovieModel>> {
        return try {
            val apiResult = movieRemoteDataSource.fetchPopularMovies()
            if (apiResult.isSuccess) {
                val moviesFromApi = apiResult.getOrNull() ?: emptyList()

                movieDao.insertMovies(moviesFromApi.map { it.toEntity() })

                Result.success(moviesFromApi)
            } else {

                val localMovies = movieDao.getAllMovies().map { it.toModel() }
                Result.success(localMovies)
            }
        } catch (e: Exception) {

            val localMovies = movieDao.getAllMovies().map { it.toModel() }
            Result.success(localMovies)
        }
    }
}