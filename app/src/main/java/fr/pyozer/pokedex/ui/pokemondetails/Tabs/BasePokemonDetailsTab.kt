package fr.pyozer.pokedex.ui.pokemondetails.tabs;

import androidx.fragment.app.Fragment
import fr.pyozer.pokedex.model.Pokemon;

abstract class BasePokemonDetailsTab: Fragment() {
    abstract fun initData(pokemon: Pokemon)
}
