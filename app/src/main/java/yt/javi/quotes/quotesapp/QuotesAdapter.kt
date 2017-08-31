package yt.javi.quotes.quotesapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlin.properties.Delegates


class QuotesAdapter(private val onShareClick: (String, String) -> Unit) : RecyclerView.Adapter<QuotesViewHolder>() {
    var quotes: List<Quote> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return QuotesViewHolder(onShareClick, view)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.render(quotes[position])
    }

    override fun getItemCount(): Int = quotes.size
}