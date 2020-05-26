package fr.pyozer.pokedex.ui.pokemondetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.fragment_pokemon_details.*

class PokemonDetailsFragment : Fragment() {

    private val args: PokemonDetailsFragmentArgs by navArgs()
    private val viewModel: PokemonDetailsViewModel by viewModels()
    private var isLoading = true
    private var pokemonDetailsAdapter: PokemonDetailsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pokemon.observe(viewLifecycleOwner, Observer { pokemon ->
            isLoading = false
            initView(pokemon)
        })

        pokemonDetailsAdapter = PokemonDetailsAdapter(this)
        pokemon_details_pages.adapter = pokemonDetailsAdapter

        TabLayoutMediator(pokemon_tabs, pokemon_details_pages) { tab, position ->
            when (position) {
                0 -> tab.text = "About"
                1 -> tab.text = "Stats"
                else -> tab.text = "Moves"
            }
        }.attach()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPokemon(args.pokemonId)
    }

    private fun initView(pokemon: Pokemon) {
        pokemon_title.text = pokemon.name.capitalize()
        pokemon_id.text = "#${pokemon.id}"
        Glide.with(requireContext())
            .load(pokemon.getImage())
            .fitCenter()
            .into(pokemon_image)

        pokemonDetailsAdapter?.initData(pokemon)

        val type = pokemon.types.sortedBy { it.slot }.first()
        when (type.type.name) {
            "water" -> pokemon_view.setBackgroundColor(getColor(R.color.blue))
            "fire" -> pokemon_view.setBackgroundColor(getColor(R.color.red))
            "electric" -> pokemon_view.setBackgroundColor(getColor(R.color.yellow))
            else -> pokemon_view.setBackgroundColor(getColor(R.color.green))
        }
    }

    private fun getColor(color: Int): Int {
        return ContextCompat.getColor(requireContext(), color)
    }
}
