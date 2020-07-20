package com.daniloosorio.restaurante2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_two.*

class FragmentTwo : Fragment(){
    var dato = arrayOf(0,0,0,0,0,0,0,0)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            dato= (activity as MainActivity?)?.back!!
            Toast.makeText(context, "${dato[0]},${dato[1]},${dato[2]},${dato[3]},${dato[4]},${dato[5]},${dato[6]},${dato[7]}", Toast.LENGTH_SHORT).show()
            textView.text=dato[0].toString()
        }
    }
}