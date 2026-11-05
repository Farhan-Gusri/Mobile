package com.example.Pertemuan10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.example.mars_farhan3tie.R

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    private class ViewHolder(view: View) {
        val avatarImg: ImageView = view.findViewById(R.id.avatarImg)
        val textSender: TextView = view.findViewById(R.id.textSender)
        val textMessage: TextView = view.findViewById(R.id.textMessage)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val data = messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .into(holder.avatarImg)

        holder.textSender.text = data.senderName
        holder.textMessage.text = data.messageText

        // OnClick di dalam Adapter sesuai spesifikasi modul
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
