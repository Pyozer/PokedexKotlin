package fr.pyozer.pokedex.ui.pokemondetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.pyozer.pokedex.api.PokemonRepository
import fr.pyozer.pokedex.model.Pokemon
import kotlinx.coroutines.launch

class PokemonDetailsViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun loadPokemon(id: Int) {
        viewModelScope.launch {
            repository.loadPokemon(id)?.let { pokemon ->
                _pokemon.value = pokemon
            }
        }
    }
}