package fr.pyozer.pokedex.api

import retrofit2.http.GET
import retrofit2.http.Query
import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.model.ApiResponse
import fr.pyozer.pokedex.model.PokemonResults
import retrofit2.Response
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 50
    ): Response<ApiResponse<PokemonResults>>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>
}