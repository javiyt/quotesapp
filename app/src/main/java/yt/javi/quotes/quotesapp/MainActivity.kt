package yt.javi.quotes.quotesapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mutableListOf<String>())

        (findViewById<View>(R.id.list) as ListView).adapter = adapter
        QuotesProvider().getQuotes(adapter)
    }
}
