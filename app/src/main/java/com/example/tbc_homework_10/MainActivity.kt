package com.example.tbc_homework_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbc_homework_10.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), RecyclerViewInterface {
    private fun fixColor(Buttons: kotlin.collections.MutableList<AppCompatButton>, targetID: Int) {
        for (i in Buttons) {
            if (i.id == targetID) i.setBackgroundResource(R.drawable.selected_category_button)
            else i.setBackgroundResource(R.drawable.regular_category_button)
        }
    }

    var adapter: ItemAdapter = ItemAdapter(Items, this)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView = binding.mainRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val categoryButtons = mutableListOf<AppCompatButton>(
            binding.allButton,
            binding.partyButton,
            binding.campingButton,
            binding.category1Button,
            binding.category2Button,
            binding.category3Button
        )

        val buttonClickListener = View.OnClickListener { v ->
            val button = v as AppCompatButton
            when (button.id) {
                R.id.allButton -> {
                    binding.mainRecyclerview.adapter = ItemAdapter(Items, this)
                    fixColor(categoryButtons, button.id)
                }
                R.id.partyButton -> {
                    val partyList = Items.filter { it.category == "Party" }.toMutableList()
                    binding.mainRecyclerview.adapter = ItemAdapter(partyList, this)
                    fixColor(categoryButtons, button.id)
                }
                R.id.campingButton -> {
                    val campingList =
                        Items.filter { it.category == "Camping" }.toMutableList()
                    binding.mainRecyclerview.adapter = ItemAdapter(campingList, this)
                    fixColor(categoryButtons, button.id)
                }
                R.id.category1Button -> {
                    val category1List =
                        Items.filter { it.category == "Category1" }.toMutableList()
                    binding.mainRecyclerview.adapter = ItemAdapter(category1List, this)
                    fixColor(categoryButtons, button.id)
                }
                R.id.category2Button -> {
                    val category2List =
                        Items.filter { it.category == "Category2" }.toMutableList()
                    binding.mainRecyclerview.adapter = ItemAdapter(category2List, this)
                    fixColor(categoryButtons, button.id)
                }
                R.id.category3Button -> {
                    val category3List =
                        Items.filter { it.category == "Category3" }.toMutableList()
                    binding.mainRecyclerview.adapter = ItemAdapter(category3List, this)
                    fixColor(categoryButtons, button.id)
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

    override fun onDeleteButtonClick(Position: Int) {
        Items.removeAt(Position)
        adapter.notifyItemRemoved(Position)
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
    }
}