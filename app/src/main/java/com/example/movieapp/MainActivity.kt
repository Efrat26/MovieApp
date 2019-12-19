package com.example.movieapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val avengers_url = "https://www.youtube.com/watch?v=6ZfuNTqbHE8"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun linkToYoutube(view : View){
        var webpage : Uri = Uri.EMPTY
        if(view.id == avengers_trailer_button.id) {
            webpage = Uri.parse(avengers_url)
        }
        if(webpage != Uri.EMPTY) {
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
