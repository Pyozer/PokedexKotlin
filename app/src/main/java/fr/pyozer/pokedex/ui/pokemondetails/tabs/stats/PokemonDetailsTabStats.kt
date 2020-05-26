package fr.pyozer.pokedex.ui.pokemondetails.tabs.stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.ui.pokemondetails.tabs.BasePokemonDetailsTab
import kotlinx.android.synthetic.main.fragment_pokemon_details_tab_stats.*

class PokemonDetailsTabStats : BasePokemonDetailsTab() {

    var listStatsAdapter = PokemonStatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokemon_details_tab_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemon_stats_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listStatsAdapter
        }
    }

    override fun initData(pokemon: Pokemon) {
        Log.e("Error", "init data fragment")

        listStatsAdapter.listStats = pokemon.stats
    }
}