package com.tatsuro.app.bottomsheetdialogfragmentsample.ui.typeselect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.tatsuro.app.bottomsheetdialogfragmentsample.IncomeOrExpenseType
import com.tatsuro.app.bottomsheetdialogfragmentsample.R

class TypeAdapter(
    private val types: Array<IncomeOrExpenseType>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TypeAdapter.ViewHolder>() {

    fun interface OnItemClickListener {
        fun onItemClick(item: IncomeOrExpenseType)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textButton: MaterialButton = view.findViewById(R.id.textButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.type_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textButton.apply {
            setIconResource(types[position].drawableResId)
            text = types[position].toString()
            setOnClickListener {
                listener.onItemClick(types[position])
            }
        }
    }

    override fun getItemCount() = types.size
}
