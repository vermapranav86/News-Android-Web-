package com.example.news

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), NewsItemListner {
    private  lateinit var mAadapter : NewsAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =LinearLayoutManager(this)
        fetchData()

        mAadapter = NewsAd(this)
        recyclerView.adapter=mAadapter
    }
    private fun fetchData() {
        //volly library
        val url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=9a8ba58a81e34daeaf3b18f343968a91"
        //making a request
        val jsonObjectRequest = object: JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val newsJsonArray = it.getJSONArray("articles")

                val newsArray = ArrayList<NewsData>()
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }

                mAadapter.update(newsArray)
            },
            Response.ErrorListener {
            }

        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }

        MySingleton.MySingleton.getIns(this).addToRequestQueue(jsonObjectRequest)
    }


    override fun onClickitem(item: NewsData) {
        val url:String  = item.url;

        CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(url));



    }
}