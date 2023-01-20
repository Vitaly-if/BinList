package com.example.binlist.cards.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.binlist.R
import com.example.binlist.main.presentation.Mapper

/**
 * @author Vitaly.N on 20.01.2023.
 */
class CardsAdapter (private val clickListener: ClickListener) :
    RecyclerView.Adapter<NumberViewHolder>(), Mapper.Unit<List<CardUi>> {

    private val list = mutableListOf<CardUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NumberViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false),
        clickListener
    )

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    override fun map(source: List<CardUi>) {
        val diff = DiffUtilCallback(list, source)
        val result = DiffUtil.calculateDiff(diff)
        list.clear()
        list.addAll(source)
        result.dispatchUpdatesTo(this)
    }
}

class NumberViewHolder(view: View, private val clickListener: ClickListener) :
    RecyclerView.ViewHolder(view) {

    private val title = itemView.findViewById<TextView>(R.id.titleBinTextView)
    private val subTitle = itemView.findViewById<TextView>(R.id.subTitleTextView)
    private val mapper = ListItemUi(title, subTitle)

    fun bind(model: CardUi) {
        model.map(mapper)
        itemView.setOnClickListener { clickListener.click(model) }
    }
}

interface ClickListener {
    fun click(item: CardUi)
}

class DiffUtilCallback(
    private val oldList: List<CardUi>,
    private val newList: List<CardUi>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].map(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].equals(newList[newItemPosition])
}