package com.firstapp.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var inputbox:TextView //late initialization
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputbox=findViewById(R.id.inputbox)
    }
    var dot:Boolean = false
    var newop:Boolean=true
    fun getNumbers(view:View){
        if(newop){
            inputbox.text=""
        }
        newop=false

        var getText : String = inputbox.text.toString()
        val selectedBtn = view as Button

        when(selectedBtn.id){
            R.id.bt0->{
                getText+="0"
            }
            R.id.bt1->{
                getText+="1"
            }
            R.id.bt2->{
                getText+="2"
            }
            R.id.bt3->{
                getText+="3"
            }
            R.id.bt4->{
                getText+="4"
            }
            R.id.bt5->{
                getText+="5"
            }
            R.id.bt6->{
                getText+="6"
            }
            R.id.bt7->{
                getText+="7"
            }
            R.id.bt8->{
                getText+="8"
            }
            R.id.bt9->{
                getText+="9"
            }
            R.id.btdot->{
                if(!dot){
                    getText+="."
                }
                dot=true
            }

        }
        inputbox.text=getText

    }
    var operator:String ="X"
    var oldNum:String=""
    fun getOperator(view:View){
        val selectedOp = view as Button
        when(selectedOp.id){
            R.id.btminus->{
                operator="-"
            }
            R.id.btdivide->{
                operator="/"
            }
           R.id.btplus->{
               operator="+"
           }
            R.id.btmultiply->{
                operator="x"
            }

        }
        oldNum = inputbox.text.toString()
        dot=false
        newop=true
    }
    fun equaloperator(view:View){
        val newNum = inputbox.text.toString()
        var result :Double?=null
        when(operator){
            "x"->{
                result = oldNum.toDouble()*newNum.toDouble()
            }
            "-"->{
                result=oldNum.toDouble()-newNum.toDouble()
            }
            "/"->{
                result=oldNum.toDouble()/newNum.toDouble()
            }
            "+"->{
                result=oldNum.toDouble()+newNum.toDouble()
            }
        }
        inputbox.text=result.toString()
    }
    fun cleanInput(view:View){
        inputbox.text=""
        newop=true
        dot=false
    }
    fun factorial(view:View){
        val num = inputbox.text.toString()
        var n = num.toInt()
        var fac=1
        for(i in 1..n){
            fac=fac*i
        }
        val result = fac.toDouble()
        inputbox.text=result.toString()
    }
    fun percentfind(view:View){
        val n = inputbox.text.toString()
        val n1 = n.toDouble()/100.0
        inputbox.text=n1.toString()
    }

}



