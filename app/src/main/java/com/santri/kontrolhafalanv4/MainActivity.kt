package com.santri.kontrolhafalanv4
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import org.json.JSONArray
import android.widget.TextView
import android.view.ViewGroup

class MainActivity: AppCompatActivity(){
 override fun onCreate(s:Bundle?){
  super.onCreate(s); setContentView(R.layout.activity_main)
  val list=findViewById<RecyclerView>(R.id.rv)
  list.layoutManager=LinearLayoutManager(this)
  val json=assets.open("quran_30juz.json").bufferedReader().readText()
  val arr=JSONArray(json)
  val items=mutableListOf<String>()
  for(i in 0 until arr.length()){
   val o=arr.getJSONObject(i)
   items.add("Juz ${o.getInt("juz")} - ${o.getInt("no")}. ${o.getString("surah")} (${o.getInt("ayat")} ayat)")
  }
  findViewById<TextView>(R.id.tvTitle).text="Kontrol Hafalan Santri V4 - 30 Juz, 114 Surah"
  list.adapter=object: RecyclerView.Adapter<VH>(){
   override fun onCreateViewHolder(p:ViewGroup,v:Int)=VH(TextView(p.context).apply{textSize=16f; setPadding(32,24,32,24)})
   override fun getItemCount()=items.size
   override fun onBindViewHolder(h:VH,p:Int){ (h.itemView as TextView).text=items[p] }
  }
 }
 class VH(v:android.view.View): RecyclerView.ViewHolder(v)
}
