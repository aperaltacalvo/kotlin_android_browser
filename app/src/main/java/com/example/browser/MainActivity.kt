package com.example.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.browser.databinding.ActivityMainBinding
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleIntent()


    }


    private fun handleIntent() {

        // recover intent
        val intent = this.intent
        val data = intent.data
        var url: URL? = null
        try{
            if (data != null) {
                url = URL(data?.scheme, data?.host, data?.path)
                binding.activityMainWbVisor.loadUrl(url.toString())
            }
        } catch (e: Exception){
            e.printStackTrace()
        }

    }

}