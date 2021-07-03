package com.kodluyoruz.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : BaseFragment() {
    lateinit var recyclerView: RecyclerView
    private var adapter: ListAdapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setPersonListData()
    }

    fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.listRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setOnClickListener(object : IOnClickListener {
            override fun onClick(view: View, person: Person) {
                Log.v("Person", "$person")
                Toast.makeText(context, "${person.name}", Toast.LENGTH_SHORT).show()
                iNavigation?.navigateDetailPage("${person.name}")
            }
        })
        recyclerView.adapter = adapter
    }

    private fun setPersonListData() {
        val list = ArrayList<Person>()
        for (i in 0..100) {
            list.add(Person("name $i", "${getLocation(i)}"))
        }
        adapter.setPersonList(list)
    }

    fun getLocation(n: Int): String {
        return if (n % 2 == 0) {
            "Istanbul"
        } else {
            "Ankara"
        }
    }

}