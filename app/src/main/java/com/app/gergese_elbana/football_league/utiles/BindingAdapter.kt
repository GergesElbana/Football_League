package com.app.gergese_elbana.football_league.utiles

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.gergese_elbana.football_league.base.BaseAdapter

@BindingAdapter(value = ["app:Items"])
fun <T> setRecyclerItem(view: RecyclerView, item: List<T>?) {
    if (item != null) {
        (view.adapter as BaseAdapter<T>).setItems(item)
    } else {
        (view.adapter as BaseAdapter<T>).setItems(emptyList())

    }


}
