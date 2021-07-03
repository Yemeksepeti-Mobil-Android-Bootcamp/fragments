package com.kodluyoruz.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var listContact = mutableListOf<Person>()
    private var listener: IOnClickListener? = null

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val locationTextView: TextView = view.findViewById(R.id.locationTextView)
        private val containerCardView: CardView = view.findViewById(R.id.containerCardView)

        fun bind(person: Person, listener: IOnClickListener?) {
            nameTextView.text = person.name
            locationTextView.text = person.location
            containerCardView.setOnClickListener {
                listener?.onClick(it, person)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listContact[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int = listContact.size

    fun setPersonList(person: ArrayList<Person>) {
        listContact.addAll(person)
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: IOnClickListener) {
        this.listener = listener
    }

}