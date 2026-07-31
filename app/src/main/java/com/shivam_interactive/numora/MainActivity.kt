package com.shivam_interactive.numora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shivam_interactive.numora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var number:String?=null
    var firstnumber:Double=0.0
    var secondnumber:Double=0.0

    var dotcontrol:Boolean=true
    var status:String?=null
    var operator:Boolean=false
    var history:String?=null
    var current:String?=null
    var temp=0.0
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
        mainBinding.dot.setOnClickListener {
            if(dotcontrol)
            {
                number= if(number==null)
                {
                    "0."
                }
                else{
                    "${number}."
                }
                mainBinding.textresult.text=number
            }
            else
            {
                dotcontrol=false
            }
        }
        mainBinding.btndel.setOnClickListener {
            number = number?.dropLast(1)
            mainBinding.textresult.text = number.orEmpty()
        }
        mainBinding.btnAC.setOnClickListener{
            buttonAc()
        }
        mainBinding.btnplus.setOnClickListener{
            temp=mainBinding.textresult.text.toString().toDouble()
            mainBinding.textdisplay.text=temp.toString()
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
            dotcontrol=true
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
            dotcontrol=true
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
            dotcontrol=true
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
            dotcontrol=true
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
    fun buttonAc()
    {
        number=null
        status=null
        firstnumber=0.0
        secondnumber=0.0
        mainBinding.textresult.text=""
        mainBinding.textdisplay.text=""
    }
}