package com.shivam_interactive.numora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shivam_interactive.numora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var number:String?=null
    var firstnumber:Double=0.0
    var secondnumber:Double=0.0

    var status:String?=null
    var operator:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        var view=mainBinding.root
        setContentView(view)

        mainBinding.btn0.setOnClickListener {
            numberentered("0")
        }
        mainBinding.btn1.setOnClickListener {
            numberentered("1")
        }
        mainBinding.btn2.setOnClickListener {
            numberentered("2")
        }
        mainBinding.btn3.setOnClickListener {
            numberentered("3")
        }
        mainBinding.btn4.setOnClickListener {
            numberentered("4")
        }
        mainBinding.btn5.setOnClickListener {
            numberentered("5")
        }
        mainBinding.btn6.setOnClickListener {
            numberentered("6")
        }
        mainBinding.btn7.setOnClickListener {
            numberentered("7")
        }
        mainBinding.btn8.setOnClickListener {
            numberentered("8")
        }
        mainBinding.btn9.setOnClickListener {
            numberentered("9")
        }

        mainBinding.btndel.setOnClickListener {

        }
        mainBinding.btnAC.setOnClickListener{
            mainBinding.textdisplay.text=""
            mainBinding.textresult.text=""
            firstnumber=0.0
            secondnumber=0.0
        }
        mainBinding.btnplus.setOnClickListener{
            if(operator){
                when(status){
                    "Multiplication"->multiply()
                    "addition"->plus()
                    "subtration"->minus()
                    "division"->divide()
                    else -> firstnumber=mainBinding.textresult.text.toString().toDouble()
                }
            }
            operator=false
            status="addition"
            number=null
        }
        mainBinding.btnminus.setOnClickListener{
            if(operator){
                when(status){
                    "Multiplication"->multiply()
                    "addition"->plus()
                    "subtration"->minus()
                    "division"->divide()
                    else -> firstnumber=mainBinding.textresult.text.toString().toDouble()
                }
            }
            operator=false
            status="subtration"
            number=null

        }
        mainBinding.btnDiv.setOnClickListener{
            if(operator){
                when(status){
                    "Multiplication"->multiply()
                    "addition"->plus()
                    "subtration"->minus()
                    "division"->divide()
                    else -> firstnumber=mainBinding.textresult.text.toString().toDouble()
                }
            }
            operator=false
            status="division"
            number=null

        }
        mainBinding.btnmulti.setOnClickListener{
            if(operator){
                when(status){
                    "Multiplication"->multiply()
                    "addition"->plus()
                    "subtration"->minus()
                    "division"->divide()
                    else -> firstnumber=mainBinding.textresult.text.toString().toDouble()
                }
            }
            operator=false
            status="Multiplication"
            number=null
        }

        mainBinding.btnequal.setOnClickListener {
            if(operator){
                when(status){
                    "Multiplication"->multiply()
                    "addition"->plus()
                    "subtration"->minus()
                    "division"->divide()
                    else -> firstnumber=mainBinding.textresult.text.toString().toDouble()
                }
            }
            operator=false
            firstnumber=0.0
            secondnumber=0.0
        }




    }

    fun numberentered(clickedNumber: String)
    {
        if(number==null)
        {
            number=clickedNumber
        }
        else{
            number+=clickedNumber
        }
        mainBinding.textresult.text=number
        operator=true
    }

    fun plus(){
        secondnumber=mainBinding.textresult.text.toString().toDouble()
        firstnumber+=secondnumber
        mainBinding.textresult.text=firstnumber.toString()
    }
    fun minus(){
        secondnumber=mainBinding.textresult.text.toString().toDouble()
        firstnumber-=secondnumber
        mainBinding.textresult.text=firstnumber.toString()
    }
    fun multiply(){
        secondnumber=mainBinding.textresult.text.toString().toDouble()
        firstnumber*=secondnumber
        mainBinding.textresult.text=firstnumber.toString()
    }
    fun divide(){
        secondnumber=mainBinding.textresult.text.toString().toDouble()
        if(secondnumber==0.0)
        {
            Toast.makeText(applicationContext,"Can't Divisible By 0", Toast.LENGTH_SHORT).show()
        }
        else{
            firstnumber/=secondnumber
            mainBinding.textresult.text=firstnumber.toString()
        }
    }
}