package com.route.islami

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentTasbehBinding


class TasbehFragment : Fragment() {

    var counter = 0
    var counterTextView: TextView? = null
    var tasbehText:TextView?=null
    lateinit var viewBinding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterTextView = viewBinding.tasbehRectangle
        tasbehText=viewBinding.textTasbeh
        onSebhaClick()
    }

    fun onSebhaClick(){

        viewBinding.sebhaBody.setOnClickListener{
            viewBinding.sebhaBody.rotation+=11F
            incrementCounter()
        }

    }
    var counter2 = 0
    fun incrementCounter() {
        counter++
        counter2++
        if(counter==33){
            counter=0
            updateTasbehText()
        }
        if(counter2==100){
            counter2=0
            updateTasbehText()
        }
        updateCounterText()
    }

    private fun updateTasbehText() {
        if(counter2<33){
            tasbehText!!.text="Subhan Allah"

        }
        if(counter2==33){
            tasbehText!!.text="Alhamdullah"
        }
        if(counter2==66){
            tasbehText!!.text="Allah Akbar"
        }
        if(counter2==99&&counter2<=100){
            tasbehText!!.text="La ellah ela Allah"
        }
        counter=0
    }

    private fun updateCounterText() {
        counterTextView!!.text = "$counter"
    }
}
