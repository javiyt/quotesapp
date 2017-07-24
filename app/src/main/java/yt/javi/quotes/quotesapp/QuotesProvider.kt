package yt.javi.quotes.quotesapp

import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL


class QuotesProvider {
    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

    fun getQuotes(quotes: ArrayAdapter<String>) {
        doAsync {
            val result = Gson().fromJson<List<Quote>>(URL("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=10").readText())
            uiThread {
                result.forEach { quotes.add(it.content) }
            }
        }
    }
}
