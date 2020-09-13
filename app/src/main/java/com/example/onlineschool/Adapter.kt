package com.example.onlineschool

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter (data:ArrayList<Lesson>, var context: Context)
            : RecyclerView.Adapter<Adapter.ViewHolder>()
{
    var data:List<Lesson>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout:View = LayoutInflater.from(parent.context).inflate(R.layout.vidoe_item,parent,false)
        return  ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoItem:Lesson = data[position]

        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)
        holder.download.setOnClickListener {

            var download:DownloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var videoUri : Uri = Uri.parse(videoItem.videoUrl)
            var GetVideo : DownloadManager.Request = DownloadManager.Request(videoUri)
            GetVideo.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(GetVideo)
        }


    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        var title :TextView
        var desc:TextView
        var video:VideoView
        var download:Button

        init {
            title = item.findViewById(R.id.video_title)
            desc = item.findViewById(R.id.video_desc)
            video = item.findViewById(R.id.lesson_video)
            download = item.findViewById(R.id.video_download)
        }
    }


}