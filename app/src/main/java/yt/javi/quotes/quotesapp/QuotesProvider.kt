package yt.javi.quotes.quotesapp

import android.text.Html
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL




class QuotesProvider {
    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

    fun getQuotes(adapter: ArrayAdapter<String>) {
        doAsync {
            val result = Gson().fromJson<List<Quote>>(URL("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=10").readText())
            uiThread {
                result.forEach { adapter.add(stripHtml(it.content)) }
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun stripHtml(html: String): String {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            return Html.fromHtml(html).toString()
        }
    }
}
