package fr.pyozer.pokedex.ui.pokemondetails.tabs.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.ui.pokemondetails.tabs.BasePokemonDetailsTab
import kotlinx.android.synthetic.main.fragment_pokemon_details_tab_moves.*

class PokemonDetailsTabMoves : BasePokemonDetailsTab() {

    var listMovesAdapter = PokemonMovesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokemon_details_tab_moves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemon_moves_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listMovesAdapter
        }
    }

    override fun initData(pokemon: Pokemon) {
        listMovesAdapter.listMoves = pokemon.moves
    }
}