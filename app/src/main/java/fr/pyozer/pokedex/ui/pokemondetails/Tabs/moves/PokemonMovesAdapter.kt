package fr.pyozer.pokedex.ui.pokemondetails.tabs.moves

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Move
import kotlinx.android.synthetic.main.pokemon_moves_row.view.*
import kotlin.properties.Delegates

class PokemonMovesAdapter : RecyclerView.Adapter<PokemonMovesAdapter.PokemonViewHolder>() {
    var listMoves: List<Move> by Delegates.observable(mutableListOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_moves_row, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        return holder.bind(listMoves[position])
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(move: Move) {
            itemView.pokemon_move_title.text = move.move.name.capitalize()
        }
    }

    override fun getItemCount(): Int {
        return listMoves.size
    }
}