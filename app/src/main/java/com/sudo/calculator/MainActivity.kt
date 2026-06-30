package com.sudo.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Display
        val viewtv=findViewById<TextView>(R.id.tvCalc)
        val prev=findViewById<TextView>(R.id.perview)
        //opreators
        val divide=findViewById<Button>(R.id.divide)
        val multiply=findViewById<Button>(R.id.multiply)
        val minus=findViewById<Button>(R.id.minus)
        val plus=findViewById<Button>(R.id.plus)
        val mod=findViewById<Button>(R.id.mod)



        //Numbers
        val one=findViewById<Button>(R.id.one)
        val two=findViewById<Button>(R.id.two)
        val three=findViewById<Button>(R.id.three)
        val four=findViewById<Button>(R.id.four)
        val five=findViewById<Button>(R.id.five)
        val six=findViewById<Button>(R.id.six)
        val seven=findViewById<Button>(R.id.seven)
        val eight=findViewById<Button>(R.id.eight)
        val nine=findViewById<Button>(R.id.nine)
        val zero=findViewById<Button>(R.id.zero)




        //special
        val clear=findViewById<Button>(R.id.ac)
        val backspace=findViewById<Button>(R.id.backspace)
        val incdec=findViewById<Button>(R.id.incr_decr)
        val dot=findViewById<Button>(R.id.dot)
        val equal=findViewById<Button>(R.id.equal)




        //Logic
        var numberlist=listOf(one,two,three,four,five,six,seven,eight,nine,zero)

        for(numbers in numberlist)
        {
            numbers.setOnClickListener{
                viewtv.text=viewtv.text.toString()+numbers.text
            }
        }


        var firstno=0.0
        var operator=""

        //operators
        plus.setOnClickListener {

            firstno=viewtv.text.toString().toDouble()
            prev.text=firstno.toString()
            operator="+"
            viewtv.text=""

        }
        minus.setOnClickListener {

            firstno=viewtv.text.toString().toDouble()
            prev.text=firstno.toString()
            operator="-"
            viewtv.text=""

        }
        divide.setOnClickListener {

            firstno=viewtv.text.toString().toDouble()
            prev.text=firstno.toString()
            operator="/"
            viewtv.text=""

        }
        multiply.setOnClickListener {

            firstno=viewtv.text.toString().toDouble()
            prev.text=firstno.toString()
            operator="*"
            viewtv.text=""

        }
        mod.setOnClickListener {

            firstno=viewtv.text.toString().toDouble()
            prev.text=firstno.toString()
            operator="%"
            viewtv.text=""

        }







        //special
        clear.setOnClickListener {
            viewtv.text=" "
        }


        backspace.setOnClickListener {
            var currenttext=viewtv.text.toString()
            if(currenttext.isNotEmpty())
            {
                currenttext=currenttext.dropLast(1)
                viewtv.text=currenttext
            }
        }

        equal.setOnClickListener {

            var secondno=viewtv.text.toString().toDouble()
            prev.text=""
            var result=when(operator)
            {
                "+"->firstno+secondno
                "-"->firstno-secondno
                "*"->firstno*secondno
                "/"->firstno/secondno
                "%"->firstno%secondno
                else -> 0.0
            }

            viewtv.text=result.toString()

        }


    }
}