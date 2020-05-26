package fr.pyozer.pokedex.model

import com.squareup.moshi.Json

class PokemonResults(
    @Json(name = "name")
    val name: String,

    @Json(name = "url")
    val url: String
) {
    fun id(): String {
        return url.removeSuffix("/").split('/').last()
    }

    fun getImage(): String {
        return "https://pokeres.bastionbot.org/images/pokemon/${id()}.png"
    }
}

class Pokemon(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "weight")
    val weight: Int,

    @Json(name = "height")
    val height: Int,

    @Json(name = "species")
    val species: NameUrl,

    @Json(name = "sprites")
    val sprites: Sprites,

    @Json(name = "types")
    val types: List<Type>,

    @Json(name = "abilities")
    val abilities: List<Ability>,

    @Json(name = "stats")
    val stats: List<Stat>,

    @Json(name = "moves")
    val moves: List<Move>
) {
    fun getImage(): String {
        return "https://pokeres.bastionbot.org/images/pokemon/${id}.png"
    }
}

data class Sprites(
    @Json(name = "back_default")
    val back_default: String,

    @Json(name = "front_default")
    val front_default: String
)

data class Type(
    @Json(name = "slot")
    val slot: Int,

    @Json(name = "type")
    val type: NameUrl
)

data class Ability(
    @Json(name = "ability")
    val ability: NameUrl,

    @Json(name = "is_hidden")
    val isHidden: Boolean,

    @Json(name = "slot")
    val slot: Int
)

data class Stat(
    @Json(name = "base_stat")
    val baseStat: Int,

    @Json(name = "effort")
    val effort: Int,

    @Json(name = "stat")
    val stat: NameUrl
)

data class Move(
    @Json(name = "move")
    val move: NameUrl
)

data class NameUrl(
    @Json(name = "name")
    val name: String,

    @Json(name = "url")
    val url: String
)
