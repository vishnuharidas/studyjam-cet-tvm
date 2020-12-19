package `in`.ac.cet.studyjamapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelloWorldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)

        val input = findViewById<EditText>(R.id.editTextTextPersonName)
        val btn = findViewById<Button>(R.id.btnGreet)
        val greetingMessageTextView = findViewById<TextView>(R.id.txtMessage)

        btn.setOnClickListener {

            val typed = input.text.toString()

            if( typed.isEmpty() ){
                greetingMessageTextView.text = "Hello, Guest!"
                greetingMessageTextView.setTextColor(Color.RED)
            } else {
                greetingMessageTextView.text = "Hello, $typed"
                greetingMessageTextView.setTextColor(Color.GREEN)
            }


        }
    }
}