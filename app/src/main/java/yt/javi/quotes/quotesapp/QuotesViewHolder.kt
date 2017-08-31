package yt.javi.quotes.quotesapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class QuotesViewHolder(private val onShareClick: (String, String) -> Unit, view: View) : RecyclerView.ViewHolder(view) {
    private val contentView = view.findViewById<TextView>(R.id.content)
    private val titleView = view.findViewById<TextView>(R.id.title)
    private val buttonShare = view.findViewById<ImageView>(R.id.share)

    fun render(quote: Quote) {
        contentView.text = quote.content
        titleView.text = quote.title

        buttonShare.setOnClickListener {
            onShareClick.invoke(quote.title, quote.content)
        }
    }
}