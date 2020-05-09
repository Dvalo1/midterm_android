package com.example.midterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postList.layoutManager = LinearLayoutManager(this)
        fetchjson()

    }

    fun fetchjson() {

        val url = "https://jsonplaceholder.typicode.com/posts"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Fail to load json")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                //println(body)

                val gson = GsonBuilder().create()
                val post_data: Array<PostData> = gson.fromJson(body, Array<PostData>::class.java)

                runOnUiThread {
                    //for (item in post_data) {
                    //    println(item.title)
                    //}
                    val adapter = MainAdapter(post_data)
                }

            }
        })

    }
}
