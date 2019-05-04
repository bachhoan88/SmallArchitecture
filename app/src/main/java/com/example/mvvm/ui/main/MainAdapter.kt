package com.example.mvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.mvvm.base.BaseRecyclerAdapter
import com.example.mvvm.databinding.CustomRepoItemBinding
import com.example.mvvm.R
import com.example.mvvm.data.model.Item

class MainAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val callback: ((Item) -> Unit)?
) : BaseRecyclerAdapter<Item>(
        callBack = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.name == newItem.name && oldItem.description == newItem.description
            }

        }) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding =
            DataBindingUtil.inflate<com.example.mvvm.databinding.CustomRepoItemBinding>(
                    LayoutInflater.from(parent.context), R.layout.custom_repo_item,
                    parent, false, dataBindingComponent
            ).apply {
                root.setOnClickListener {
                    this.repo?.let { item ->
                        callback?.invoke(item)
                    }
                }
            }

    override fun bind(binding: ViewDataBinding, item: Item) {
        if (binding is CustomRepoItemBinding) binding.repo = item
    }

}
