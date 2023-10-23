package com.mubin.harrypotter.ui.characterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mubin.harrypotter.R
import com.mubin.harrypotter.api.models.CharacterListResponse
import com.mubin.harrypotter.databinding.ItemViewCharacterBinding

class CharacterListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<CharacterListResponse.CharacterListResponseItem> = mutableListOf()
    var characterItemClicked: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharacterListViewHolder(ItemViewCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        if (holder is CharacterListViewHolder) {
            holder.bindCharacterData(data)
        }
    }

    inner class CharacterListViewHolder(private val binding: ItemViewCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindCharacterData(data: CharacterListResponse.CharacterListResponseItem) {

            binding.root.setOnClickListener {
                characterItemClicked?.invoke(data.id ?: "")
            }

            Glide.with(binding.characterIv).load(data.image).placeholder(R.drawable.image_loading_placeholder).error(R.drawable.image_error_placeholder).into(binding.characterIv)

            if (data.name.isNullOrEmpty()) {
                binding.characterNameTv.visibility = View.GONE
            } else {
                binding.characterNameTv.visibility = View.VISIBLE
                binding.characterNameTv.text = data.name
            }

            if (data.actor.isNullOrEmpty()) {
                binding.characterActorNameTv.visibility = View.GONE
            } else {
                binding.characterActorNameTv.visibility = View.VISIBLE
                binding.characterActorNameTv.text = data.actor
            }

            if (data.house.isNullOrEmpty()) {
                binding.houseNameTv.visibility = View.GONE
            } else {
                binding.houseNameTv.visibility = View.VISIBLE
                binding.houseNameTv.text = data.house
            }

        }

    }

    fun addAll(dataList: List<CharacterListResponse.CharacterListResponseItem>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

}
