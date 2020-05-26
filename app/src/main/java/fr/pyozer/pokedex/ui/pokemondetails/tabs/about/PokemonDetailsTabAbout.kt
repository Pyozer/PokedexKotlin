package fr.pyozer.pokedex.ui.pokemondetails.tabs.about

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.ui.pokemondetails.tabs.BasePokemonDetailsTab
import kotlinx.android.synthetic.main.fragment_pokemon_details_tab_about.*

class PokemonDetailsTabAbout : BasePokemonDetailsTab() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokemon_details_tab_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Nothing
    }

    override fun initData(pokemon: Pokemon) {
        pokemon_species?.text = pokemon.species.name.capitalize()
        pokemon_height?.text = "${pokemon.height.toDouble() / 10}cm"
        pokemon_weight?.text = "${pokemon.weight.toDouble() / 10}kg"
        pokemon_abilities?.text =
            pokemon.abilities.joinToString(", ") { it.ability.name.capitalize() }
    }
}