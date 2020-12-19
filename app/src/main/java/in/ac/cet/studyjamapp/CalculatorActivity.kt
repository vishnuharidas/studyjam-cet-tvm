package `in`.ac.cet.studyjamapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    var resultValue: Int = 0;

    var op1 = 0;
    var op2 = 0;

    var isOp2: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnEq = findViewById<Button>(R.id.btnEquals)

        val btnClear = findViewById<Button>(R.id.btnClear)

        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        btn4.setOnClickListener { addNumber(4, txtDisplay) }
        btn5.setOnClickListener { addNumber(5, txtDisplay) }
        btn6.setOnClickListener { addNumber(6, txtDisplay) }
        btn7.setOnClickListener { addNumber(7, txtDisplay) }
        btn8.setOnClickListener { addNumber(8, txtDisplay) }
        btn9.setOnClickListener { addNumber(9, txtDisplay) }

        btnClear.setOnClickListener {
            isOp2 = false
            op1 = 0
            op2 = 0
            txtDisplay.text = "0"
        }

        btnPlus.setOnClickListener {
            isOp2 = true
            txtDisplay.text = "0"
        }

        btnEq.setOnClickListener {
            txtDisplay.text = "${ op1 + op2 }"
            op1 = 0
            op2 = 0
            isOp2 = false
        }
    }

    fun addNumber(n: Int, txtDisplay: TextView){
        if(isOp2){
            op2 = op2 * 10 + n
            txtDisplay.text = "$op2"
        } else {
            op1 = op1 * 10 + n
            txtDisplay.text = "$op1"
        }
    }

}