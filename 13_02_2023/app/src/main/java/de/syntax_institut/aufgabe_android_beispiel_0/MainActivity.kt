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
        findViewById<TextView>(R.id.textView).text = """
            |Februar-Nacht
            |
            |Der kalte Mond hat eine Delle.
            |Die Sterne glimmen trüb nd matt.
            |Die Nacht bringt mch an jene Schwelle,
            |wo ich das triste Urteil fälle:
            |Ach Februar, ich hab dich satt. 
            |Mach Platz für Sonnenschein und Blüten! 
            |Die Gärten sollen auferstehn, 
            |das Grün in wildem Wachstum wüten, 
            |die Vögel zwitschern und auch brüten, 
            |ach Februar! Wär das nicht schön?
            |
            |- von Hans Retep -
        """.trimMargin()
    }
}