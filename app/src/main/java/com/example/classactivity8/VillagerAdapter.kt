package com.example.classactivity8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VillagerAdapter(private val dataset: List<Villager>) : RecyclerView.Adapter<VillagerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_villager,
            parent,
            false
        )
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var villager : Villager = dataset[position]
        holder.textViewName.text = villager.name
        holder.textViewBirthday.text = villager.birthday
        holder.textViewPhrase.text = villager.phrase


        // ClassActivity8 - if image clicked, change the image
        if (villager.showVillager){
            Picasso.get().load(villager.villagerURL).into(holder.imageViewVillager)
        } else {
            Picasso.get().load(villager.houseURL).into(holder.imageViewVillager)
        }


        holder.imageViewVillager.setOnClickListener(View.OnClickListener {    // make changes in data model
            villager.showVillager = !villager.showVillager
            this.notifyItemChanged(position)
        })
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textViewName : TextView = view.findViewById(R.id.textView_name)
        val textViewBirthday : TextView = view.findViewById(R.id.textView_birthday)
        val textViewPhrase : TextView = view.findViewById(R.id.textView_phrase)
        val imageViewVillager : ImageView = view.findViewById(R.id.imageView_villager)

    }
}