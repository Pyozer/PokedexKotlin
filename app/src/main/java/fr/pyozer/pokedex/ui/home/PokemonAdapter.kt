package fr.pyozer.pokedex.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.PokemonResults
import kotlinx.android.synthetic.main.pokemon_item.view.*
import kotlin.properties.Delegates

class PokemonAdapter() : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    var list: List<PokemonResults> by Delegates.observable(mutableListOf()) { _, _, _ ->
        notifyDataSetChanged()
    }
    var listener: ((pokemonId: Int) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pokemon: PokemonResults) {
            val id = pokemon.id()
            Glide.with(itemView.context)
                .load(pokemon.getImage())
                .into(itemView.pokemon_item_photo)
            itemView.pokemon_item_title.text = pokemon.name.capitalize()
            itemView.pokemon_item_id.text = "#$id"
            itemView.pokemon_item_card.setOnClickListener {
                listener(id.toInt())
            }

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}