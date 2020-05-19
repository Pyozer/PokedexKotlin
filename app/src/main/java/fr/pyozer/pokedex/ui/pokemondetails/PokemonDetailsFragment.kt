package fr.pyozer.pokedex.ui.pokemondetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.fragment_pokemon_details.*

class PokemonDetailsFragment : Fragment() {

    private val args: PokemonDetailsFragmentArgs by navArgs()
    private val viewModel: PokemonDetailsViewModel by viewModels()
    private var isLoading = true

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
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPokemon(args.pokemonId)
    }

    private fun initView(pokemon: Pokemon) {
        pokemon_title.text = pokemon.name.capitalize()
    }
}
