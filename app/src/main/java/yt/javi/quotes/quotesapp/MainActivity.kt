package yt.javi.quotes.quotesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mutableListOf<String>())

        (findViewById(R.id.list) as ListView).adapter = adapter
        QuotesProvider().getQuotes(adapter)
    }
}
