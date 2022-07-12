package com.example.tbc_homework_10

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_homework_10.databinding.ItemBinding

class ItemAdapter(val Items: MutableList<Item>, val recyclerViewInterface: RecyclerViewInterface) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val deleteButton = binding.deleteButton
        init {
            deleteButton.setOnClickListener {
                if (recyclerViewInterface != null) {
                    val pos = bindingAdapterPosition
                    if (pos != RecyclerView.NO_POSITION)
                        recyclerViewInterface.onDeleteButtonClick(pos)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            itemCost.text = Items[position].price
            itemName.text = Items[position].name
            imagePerson.setImageResource(Items[position].image)

        }
    }

    override fun getItemCount(): Int {
        return Items.size
    }

}