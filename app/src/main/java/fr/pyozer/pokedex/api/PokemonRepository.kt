package fr.pyozer.pokedex.api;

import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.model.PokemonResults;

class PokemonRepository {
    private val pokemonService = Api.pokemonService

    suspend fun loadPokemonList(offset: Int, limit: Int): List<PokemonResults>? {
        val response = pokemonService.getPokemonList(offset, limit)
        return if (response.isSuccessful) response.body()?.results else null
    }

    suspend fun loadPokemon(id: Int): Pokemon? {
        val response = pokemonService.getPokemon(id)
        return if (response.isSuccessful) response.body() else null
    }
}
