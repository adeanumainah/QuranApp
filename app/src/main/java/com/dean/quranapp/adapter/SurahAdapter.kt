package com.dean.quranapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dean.quranapp.R
import com.dean.quranapp.model.ModelSurah
import kotlinx.android.synthetic.main.list_item_surah.view.*
import org.w3c.dom.Text

class SurahAdapter(
    private val mContext: Context,
    private val items: List<ModelSurah>,
    private val onSelectData: onSelectDataa
) : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {

    interface onSelectDataa {
        fun onSelected(modelSurah: ModelSurah?)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_surah, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SurahAdapter.ViewHolder, position: Int) {
        val data = items[position]
        holder.txtNumber.text = data.nomor
        holder.txtAyat.text = data.nama
        holder.txtInfo.text = data.type + " - "+ data.ayat + "Ayat"
        holder.txtName.text = data.asma
        holder.cvSurah.setOnClickListener {
            onSelectData.onSelected(data)
        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var cvSurah: CardView
        var txtNumber: TextView
        var txtAyat: TextView
        var txtInfo: TextView
        var txtName: TextView

        init {
            cvSurah = itemView.findViewById(R.id.cv_surah)
            txtNumber = itemView.findViewById(R.id.txt_number)
            txtAyat = itemView.findViewById(R.id.txt_ayat)
            txtInfo = itemView.findViewById(R.id.txt_info)
            txtName = itemView.findViewById(R.id.txt_name)
        }

    }
}