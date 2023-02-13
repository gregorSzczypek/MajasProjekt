package de.syntax_institut.aufgabe_android_beispiel_0

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO Ändere die Textausgabe von "Quatsch" zu einem Text deiner Wahl
        findViewById<TextView>(R.id.textView).text = "Quatsch"
    }
}