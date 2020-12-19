package `in`.ac.cet.studyjamapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    var op1: Long = 0
    var op2: Long = 0

    // Currently selected operator
    var operator: String? = null

    // A flag to check if the user is entering the second operand.
    // This is updated when the user clicks on an operator (Plus, Minus etc.)
    // and reset when the user clicks on the Equal button.
    var isOp2: Boolean = false

    private lateinit var txtDisplay : TextView

    // The +, -, =, and "Clear" buttons
    private lateinit var btnMinus : Button
    private lateinit var btnPlus : Button
    private lateinit var btnEq : Button
    private lateinit var btnClear : Button

    // Numeric Buttons
    private lateinit var btn0 : Button
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var btn8 : Button
    private lateinit var btn9 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        txtDisplay = findViewById(R.id.txtDisplay)

        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnEq = findViewById(R.id.btnEquals)

        btnClear = findViewById(R.id.btnClear)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        btn0.setOnClickListener { addNumber(0) }
        btn1.setOnClickListener { addNumber(1) }
        btn2.setOnClickListener { addNumber(2) }
        btn3.setOnClickListener { addNumber(3) }
        btn4.setOnClickListener { addNumber(4) }
        btn5.setOnClickListener { addNumber(5) }
        btn6.setOnClickListener { addNumber(6) }
        btn7.setOnClickListener { addNumber(7) }
        btn8.setOnClickListener { addNumber(8) }
        btn9.setOnClickListener { addNumber(9) }

        // Clear everything, the op1, op2, operator, flags, and set the text to "0"
        btnClear.setOnClickListener {
            isOp2 = false
            op1 = 0
            op2 = 0
            operator = null
            txtDisplay.text = "0"
        }

        btnPlus.setOnClickListener {
            isOp2 = true
            operator = "+"
            txtDisplay.text = "$op1$operator"
        }

        btnMinus.setOnClickListener {
            isOp2 = true
            operator = "-"
            txtDisplay.text = "$op1$operator"
        }

        btnEq.setOnClickListener {

            when(operator){
                "+" -> txtDisplay.text = "${ op1 + op2 }"
                "-" -> txtDisplay.text = "${ op1 - op2 }"
            }

            op1 = 0
            op2 = 0
            operator = null
            isOp2 = false
        }
    }

    private fun addNumber(n: Int){

        /* If the user is typing in the second operand, then update the
           `op2` field. Otherwise the user must be entering the first operand, so
            update the `op1` field.
        */
        if(isOp2){
            op2 = op2 * 10 + n
            txtDisplay.text = "$op1$operator$op2"
        } else {
            op1 = op1 * 10 + n
            txtDisplay.text = "$op1"
        }
    }

}