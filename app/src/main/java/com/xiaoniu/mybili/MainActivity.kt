package com.xiaoniu.mybili

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var adapter: upAdapter? = null  //感觉写法有亿点点烂，虽然实现了需求
        val upList = ArrayList<up>()
        fun getUpById(id: Int): up {
            return upList[id]
        }

        fun delUpById(id: Int) {
            upList.removeAt(id)
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUps()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        adapter = upAdapter(upList, detailTitle, detailImg)
        recyclerView.adapter = adapter
        detailTitle.text="Coded by 快乐小牛"
    }

    private fun initUps() {
        upList.add(up("Apple", R.drawable.apple_pic, 100))  //素材懒得找，直接借用第一行代码（
        upList.add(up("Banana", R.drawable.banana_pic, 200))
        upList.add(up("Orange", R.drawable.orange_pic, 300))
        upList.add(up("Watermelon", R.drawable.watermelon_pic, 400))
        upList.add(up("Pear", R.drawable.pear_pic, 500))
        upList.add(up("Grape", R.drawable.grape_pic, 600))
        upList.add(up("Pineapple", R.drawable.pineapple_pic, 700))
        upList.add(up("Strawberry", R.drawable.strawberry_pic, 800))
        upList.add(up("Cherry", R.drawable.cherry_pic, 900))
        upList.add(up("Mango", R.drawable.mango_pic, 1000))
    }


}