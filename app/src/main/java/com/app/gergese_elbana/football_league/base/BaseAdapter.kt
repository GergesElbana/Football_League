package com.app.gergese_elbana.football_league.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.app.gergese_elbana.football_league.base.BaseAdapter.BaseDataViewHolder
import com.example.football_league.BR

abstract class BaseAdapter<T>(
    private var items: ArrayList<T>,
    private var listener: BaseInteractionListener
) : RecyclerView.Adapter<BaseDataViewHolder>() {
    abstract var layoutId: Int

    abstract class BaseDataViewHolder(
        binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class ItemDataViewHolder(val binding: ViewDataBinding) : BaseDataViewHolder(binding)

    fun setItems(newItems: List<T>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun getItems() = items

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: BaseDataViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemDataViewHolder -> {
                /** use it when you have recyclerview item but you should make items of recyclers have the same name of variable("item" and listener) **/

                holder.binding.setVariable(BR.item, currentItem)
             //   holder.binding.setVariable(BR.item, currentItem)
//                holder.binding.setVariable(BR.listener, listener)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDataViewHolder {
        return ItemDataViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
        )
    }



}