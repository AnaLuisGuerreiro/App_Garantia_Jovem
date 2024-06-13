package com.example.myapplication.Views

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Adapters.ExpandableListAdapter
import com.example.myapplication.R

class FAQsActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: ExpandableListAdapter
    private lateinit var listGroup: List<String>
    private lateinit var listItem: HashMap<String, List<String>>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqs)

        listGroup = mutableListOf()
        listItem = hashMapOf()
        expandableListAdapter = ExpandableListAdapter(this, listGroup, listItem)
        expandableListView.setAdapter(expandableListAdapter)

        updateListData(3, 5) // Por exemplo, 3 grupos com 5 itens cada
    }


    private fun updateListData(numGroups: Int, numItemsPerGroup: Int) {
        listGroup = mutableListOf()
        listItem = hashMapOf()

        for (i in 0 until numGroups) {
            val group = "Group ${i + 1}"
            (listGroup as MutableList<String>).add(group)

            val items = mutableListOf<String>()
            for (j in 0 until numItemsPerGroup) {
                items.add("Item ${j + 1}")
            }
            listItem[group] = items
        }

        expandableListAdapter.notifyDataSetChanged()
    }



}

