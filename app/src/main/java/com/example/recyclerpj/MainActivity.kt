package com.example.recyclerpj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerpj.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var dataList: MutableList<DataList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList = mutableListOf<DataList>()
        for(i in 1..10){
            if(i % 2 == 0){
                dataList.add(DataList("비행기${i}", "${20+i}세","rlaeogus0911${i}@nate.com",R.drawable.ait_24))
            }else{
                dataList.add(DataList("동그라미${i}", "${20+i}세","rlaeogus0911${i}@nate.com",R.drawable.line_24))
            }
        }

        val customAdapter = CustomAdapter(dataList)
        binding.recyclerview.adapter = customAdapter
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerview.layoutManager = layoutManager



    }
}