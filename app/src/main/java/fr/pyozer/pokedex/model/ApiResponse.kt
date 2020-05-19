package fr.pyozer.pokedex.model

import com.squareup.moshi.Json

data class ApiResponse<T>(
    @field:Json(name = "count")
    val count: Int,

    @field:Json(name = "results")
    val results: List<T>
)