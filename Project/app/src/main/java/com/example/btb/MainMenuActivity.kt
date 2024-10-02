package com.example.btb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.btb.R
import com.google.androidgamesdk.GameActivity


class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)


        val
                newGameButton = findViewById<Button>(R.id.newGameButton)
        val continueGameButton = findViewById<Button>(R.id.continueGameButton)

        newGameButton.setOnClickListener {
            // Új játék indítása, pl. másik Activity-t indítunk
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("newGame", true) // Extra adat átadása az új Activity-nek
            startActivity(intent)
            setContentView(GameActivity(this))
        }

        continueGameButton.setOnClickListener {
            // Meglévő játék folytatása
            // ... itt töltsük be a mentett adatokat és indítsuk el a megfelelő Activity-t
        }



    }



}



