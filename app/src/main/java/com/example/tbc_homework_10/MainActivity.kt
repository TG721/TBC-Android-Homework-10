package com.example.tbc_homework_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbc_homework_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ItemAdapter(Items)
        val recyclerView = binding.mainRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        val buttonClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val button = v as AppCompatButton
                when (button.id) {
                    R.id.allButton -> {
                        binding.mainRecyclerview.adapter = ItemAdapter(Items)
                    }
                    R.id.partyButton -> {
                        val partyList = Items.filter { it.category == "Party" }.toMutableList()
                        binding.mainRecyclerview.adapter = ItemAdapter(partyList)
                    }
                    R.id.campingButton -> {
                        val CampingList =
                            Items.filter { it.category == "Camping" }.toMutableList()
                        binding.mainRecyclerview.adapter = ItemAdapter(CampingList)
                    }
                    R.id.category1Button -> {
                        val category1List =
                            Items.filter { it.category == "Category1" }.toMutableList()
                        binding.mainRecyclerview.adapter = ItemAdapter(category1List)
                    }
                    R.id.category2Button -> {
                        val category2List =
                            Items.filter { it.category == "Category2" }.toMutableList()
                        binding.mainRecyclerview.adapter = ItemAdapter(category2List)
                    }
                    R.id.category3Button -> {
                        val category3List =
                            Items.filter { it.category == "Category3" }.toMutableList()
                        binding.mainRecyclerview.adapter = ItemAdapter(category3List)
                    }
                }
            }

        }
        binding.apply {
            allButton.setOnClickListener(buttonClickListener)
            partyButton.setOnClickListener(buttonClickListener)
            campingButton.setOnClickListener(buttonClickListener)
            category1Button.setOnClickListener(buttonClickListener)
            category2Button.setOnClickListener(buttonClickListener)
            category3Button.setOnClickListener(buttonClickListener)
        }
    }
}