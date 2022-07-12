package com.example.tbc_homework_10

data class Item(
    val name: String,
    val price: String,
    val image: Int,
    val category: String
)

val Items = mutableListOf<Item>(
    Item("Belt suit Blazer", "$120", R.drawable.person1, "Party"),
    Item("Belt suit Blazer", "$140", R.drawable.person2, "Camping"),
    Item("Belt suit Blazer", "$170", R.drawable.person3, "Category1"),
    Item("Belt suit Blazer", "$190", R.drawable.person4, "Category2")
//    Item("Belt suit Blazer", "$170", R.drawable.person3, ),
//    Item("Belt suit Blazer", "$190", R.drawable.person4, )
//    Item("Belt suit Blazer", "$190", R.drawable.person4, )
)
