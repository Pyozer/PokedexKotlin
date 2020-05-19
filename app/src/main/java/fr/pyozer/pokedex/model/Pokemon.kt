package fr.pyozer.pokedex.model

import com.squareup.moshi.Json

data class PokemonResults(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
)

data class Pokemon(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "weight")
    val weight: Int,

    @field:Json(name = "height")
    val height: Int,

    @field:Json(name = "species")
    val species: Species,

    @field:Json(name = "sprites")
    val sprites: Sprites
)

data class Species(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
)

data class Sprites(
    @field:Json(name = "back_default")
    val back_default: String,

    @field:Json(name = "front_default")
    val front_default: String
)
