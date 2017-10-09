package yt.javi.quotes.quotesapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.list) as RecyclerView
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager

        recyclerView.adapter = QuotesAdapter(fun(title: String, content: String) {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "$title $content")
            sendIntent.type = "text/plain"
            startActivity(Intent.createChooser(sendIntent, "Share the quote"))
        })

        QuotesProvider().getQuotes(recyclerView.adapter as QuotesAdapter)
    }
}