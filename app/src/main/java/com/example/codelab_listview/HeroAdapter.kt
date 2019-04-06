package com.example.codelab_listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HeroAdapter(private val context :Context) : BaseAdapter() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val  listHeroes : MutableList<Hero> = mutableListOf()

    fun setData(listHeroes : MutableList<Hero>){
        this.listHeroes.addAll(listHeroes)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        val holder = ViewHolder(itemView)
        holder.bind(listHeroes[position])

        return itemView
    }

    override fun getItem(position: Int) = this.listHeroes[position]

    override fun getCount() = this.listHeroes.size
}

class ViewHolder(val view : View){
    private val tvName : TextView = view.findViewById(R.id.hero_name)
    private val imgHero : ImageView = view.findViewById(R.id.hero_photo)
    private val tvDesc : TextView = view.findViewById(R.id.hero_desc)

    fun bind(hero: Hero){
        this.tvName.text = hero.name
        hero.photo?.let { this.imgHero.setImageResource(it) }
        this.tvDesc.text = hero.description
    }
}