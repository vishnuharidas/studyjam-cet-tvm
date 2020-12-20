package `in`.ac.cet.studyjamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHello = findViewById<Button>(R.id.btnHelloWorld)

        val btnCalc = findViewById<Button>(R.id.btnCalculator)

        val btnMovieRec = findViewById<Button>(R.id.btnMovie)

        btnHello.setOnClickListener {

            val intent = Intent(this, HelloWorldActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Clicked on Hello World Button", Toast.LENGTH_SHORT).show()
        }

        btnCalc.setOnClickListener {

            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnMovieRec.setOnClickListener {

            val intent = Intent(this, MovieRecommendationActivity::class.java)
            startActivity(intent)
        }

    }
}