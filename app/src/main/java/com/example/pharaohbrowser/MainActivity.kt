package com.example.pharaohbrowser

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var searchView: SearchView? = null
    var webview: WebView? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.search_view)
        webview = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progress_bar)

        webview!!.settings.javaScriptEnabled = true
        webview!!.webViewClient = WebViewClient() //displays web sites
    }

    fun imageClicked(view: View) {
        var id=view.id
        var ourId: String? = ""

        if (isInternetConnected()) {

            ourId = view.resources.getResourceEntryName(id)
            webview?.loadUrl("https://www." + ourId + ".com")
            webview!!.visibility = View.VISIBLE
            progressBar!!.visibility = View.GONE
        } else Toast.makeText(this,
                "ummm there is no internet connection. turn on wifi or make sure there is a data connection.",
                Toast.LENGTH_SHORT
        ).show()




        fun iconClicked(view: View) {}

        fun isInternetConnected(): Boolean {
            val connectivityManager: ConnectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkinfo = connectivityManager.activeNetworkInfo
            if(networkinfo != null && networkinfo.isConnected)
                return true
             else
                return false
        }


    }

    fun isInternetConnected(): Boolean {
        val connectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkinfo = connectivityManager.activeNetworkInfo
        if(networkinfo != null && networkinfo.isConnected)
            return true
        else
            return false
    }








}


