package com.example.bitcointicketer.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bitcointicketer.R
import java.text.SimpleDateFormat
import java.util.*

class MainFragment private constructor(val position: Int) : Fragment() {
    var txtDateTime:TextView?=null
    var txtPrice:TextView?=null
    companion object {
        fun newInstance(position: Int):Fragment {
            return MainFragment(position)
        }
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.screen_slide_fragment, container,
            false)
        txtDateTime=view.findViewById(R.id.txtDateTime)
        txtPrice=view.findViewById(R.id.txtBitCoinPrice)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.fetchData().observe(this, Observer { currencies->
            if (currencies==null){
                //show error message
            }else{
                if(position==0){
                    val currency = currencies.usd
                    txtPrice?.text=currency?.buy.toString()+" USD "
                }else if(position==1){
                    val currency = currencies.cad
                    txtPrice?.text=currency?.buy.toString()+" CAD"
                }else{
                    val currency = currencies.gbp
                    txtPrice?.text=currency?.buy.toString()+" GBP"
                }
                val timeStamp: String = SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Date())
                txtDateTime?.text=timeStamp
            }
        })

    }

}