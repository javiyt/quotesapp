package yt.javi.quotes.quotesapp

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter


class MainActivity : ListActivity() {
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= ArrayAdapter(this, R.id.list_item)
        listAdapter = adapter
        QuotesProvider().getQuotes(adapter)
    }
}
