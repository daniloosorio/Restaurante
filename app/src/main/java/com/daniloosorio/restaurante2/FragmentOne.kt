package com.daniloosorio.restaurante2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {
    var array = arrayOf(0,0,0,0,0,0,0,0)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkBox1.setOnClickListener{
            if (checkBox1.isChecked){
                array[0]=1
            }else array[0]=0
        }
        checkBox2.setOnClickListener{
            if (checkBox2.isChecked){
                array[1]=1
            }else array[1]=0
        }
        checkBox3.setOnClickListener{
            if (checkBox3.isChecked){
                array[2]=1
            }else array[2]=0
        }
        checkBox4.setOnClickListener{
            if (checkBox4.isChecked){
                array[3]=1
            }else array[3]=0
        }
        checkBox5.setOnClickListener{
            if (checkBox5.isChecked){
                array[4]=1
            }else array[4]=0
        }
        checkBox6.setOnClickListener{
            if (checkBox6.isChecked){
                array[5]=1
            }else array[5]=0
        }
        checkBox7.setOnClickListener {
            if (checkBox7.isChecked) {
                array[6]=1
            }else array[6]=0
        }
        checkBox8.setOnClickListener {
            if (checkBox8.isChecked) {
                array[7]=1
            }else array[7]=0
        }
        passData(array)
    }
    interface OnDataPass {
        fun onDataPass(data: Array<Int>)
    }

    lateinit var dataPasser: OnDataPass

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }
    fun passData(data: Array<Int>){
        dataPasser.onDataPass(data)
    }

}