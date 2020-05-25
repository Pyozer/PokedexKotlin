package fr.pyozer.pokedex.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.pyozer.pokedex.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()
    private var currentPage = 0
    private var isLoading = true

    private companion object {
        const val POKEMON_LIST_LIMIT = 50
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayoutManager = GridLayoutManager(context, 2)
        home_list.apply {
            layoutManager = gridLayoutManager
            adapter = pokemonAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        if (!isLoading) {
                            if (gridLayoutManager.childCount + gridLayoutManager.findFirstVisibleItemPosition() >= gridLayoutManager.itemCount) {
                                currentPage++
                                isLoading = true
                                viewModel.loadPokemonList(
                                    currentPage * POKEMON_LIST_LIMIT,
                                    POKEMON_LIST_LIMIT
                                )
                            }
                        }
                    }
                }
            })
        }
        pokemonAdapter.listener = {
            val action = HomeFragmentDirections.actionNavigationHomeToPokemonDetailsFragment(it)
            findNavController().navigate(action)
        }

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer { newList ->
            isLoading = false
            pokemonAdapter.list = newList
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPokemonList(0, POKEMON_LIST_LIMIT)
    }
}
