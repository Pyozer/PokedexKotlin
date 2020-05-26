package fr.pyozer.pokedex.ui.pokemondetails.tabs.stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.pyozer.pokedex.R
import fr.pyozer.pokedex.model.Stat
import kotlinx.android.synthetic.main.pokemon_stats_row.view.*
import kotlin.properties.Delegates

class PokemonStatsAdapter : RecyclerView.Adapter<PokemonStatsAdapter.PokemonViewHolder>() {
    var listStats: List<Stat> by Delegates.observable(mutableListOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_stats_row, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        return holder.bind(listStats[position])
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(stat: Stat) {
            itemView.pokemon_stat_title.text = stat.stat.name.capitalize()
            itemView.pokemon_stat_value.text = stat.baseStat.toString()
            itemView.pokemon_stat_progress.progress = stat.baseStat
        }
    }

    override fun getItemCount(): Int {
        return listStats.size
    }
}