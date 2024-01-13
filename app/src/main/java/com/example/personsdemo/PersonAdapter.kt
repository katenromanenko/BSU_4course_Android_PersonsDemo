package com.example.personsdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class PersonAdapter(val list: MutableList<Person>, val activity: MainActivity): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val iPhoto = itemView.findViewById<ImageView>(R.id.imagePhoto)
        val tName = itemView.findViewById<TextView>(R.id.textName)
        val tSName = itemView.findViewById<TextView>(R.id.textSName)
        val tAge = itemView.findViewById<TextView>(R.id.textAge)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_layout,parent,false)
        val holder = PersonViewHolder(itemView)
        holder.itemView.setOnClickListener{
            activity.onItemClick(holder.adapterPosition)
        }
        holder.itemView.setOnLongClickListener{
            activity.onItemDeleted(holder.adapterPosition)
            return@setOnLongClickListener true
        }

        return holder
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentPerson  =list[position]
        holder.tName.text = currentPerson.name
        holder.tSName.text = currentPerson.sName
        holder.tAge.text = currentPerson.age.toString()
        holder.iPhoto.setImageResource(currentPerson.photoId)

    }
}
