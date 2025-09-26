package com.calyrsoft.ucbp1.features.movie.data.mapper

import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

fun MovieModel.toEntity(): MovieEntity {
    return MovieEntity(
//        id = this.id,
        title = this.title,
        pathUrl = this.pathUrl
    )
}

fun MovieEntity.toModel(): MovieModel {
    return MovieModel(
        title = this.title,
        pathUrl = this.pathUrl ?: ""
    )
}
