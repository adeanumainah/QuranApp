package com.dean.quranapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dean.quranapp.R
import com.dean.quranapp.model.ModelAyat
import kotlinx.android.synthetic.main.list_item_ayat.view.*
import org.w3c.dom.Text

class Ayatdapter(
    private val mContext: Context,
    private val items: List<ModelAyat>
) : RecyclerView.Adapter<Ayatdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Ayatdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_ayat, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Ayatdapter.ViewHolder, position: Int) {
        val data = items[position]
        holder.tvNomorAyat.text = data.nomor
        holder.tvArabic.text = data.arab
        holder.tvTerjemahan.text = data.indo
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var tvNomorAyat: TextView
        var tvArabic: TextView
        var tvTerjemahan: TextView

        init {
            tvNomorAyat = itemView.findViewById(R.id.tv_nomer_ayat)
            tvArabic = itemView.findViewById(R.id.tv_arabic)
            tvTerjemahan = itemView.findViewById(R.id.tv_terjemahan)
        }

    }
}