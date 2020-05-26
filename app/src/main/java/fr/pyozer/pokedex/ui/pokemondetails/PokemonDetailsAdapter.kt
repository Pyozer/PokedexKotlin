package fr.pyozer.pokedex.ui.pokemondetails

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.pyozer.pokedex.model.Pokemon
import fr.pyozer.pokedex.ui.pokemondetails.tabs.BasePokemonDetailsTab
import fr.pyozer.pokedex.ui.pokemondetails.tabs.about.PokemonDetailsTabAbout
import fr.pyozer.pokedex.ui.pokemondetails.tabs.moves.PokemonDetailsTabMoves
import fr.pyozer.pokedex.ui.pokemondetails.tabs.stats.PokemonDetailsTabStats

class PokemonDetailsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabs: List<BasePokemonDetailsTab> = listOf(
        PokemonDetailsTabAbout(),
        PokemonDetailsTabStats(),
        PokemonDetailsTabMoves()
    )
    var currentPage: Int = 0

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        currentPage = position
        return tabs[position]
    }

    fun initData(pokemon: Pokemon) {
        tabs.forEach {
            it.initData(pokemon)
        }
    }
}