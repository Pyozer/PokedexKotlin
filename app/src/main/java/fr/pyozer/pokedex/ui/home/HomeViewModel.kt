package fr.pyozer.pokedex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.pyozer.pokedex.api.PokemonRepository
import fr.pyozer.pokedex.model.PokemonResults
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val _pokemonList = MutableLiveData<List<PokemonResults>>()
    val pokemonList: LiveData<List<PokemonResults>> = _pokemonList

    private fun getMutableList() = _pokemonList.value.orEmpty().toMutableList()

    fun loadPokemonList(offset: Int, limit: Int) {
        viewModelScope.launch {
            repository.loadPokemonList(offset, limit)?.let { pokemons ->
                if (offset == 0) {
                    _pokemonList.value = pokemons.toMutableList()
                } else {
                    val newList = getMutableList()
                    newList.addAll(pokemons)
                    _pokemonList.value = newList
                }
            }
        }
    }
}