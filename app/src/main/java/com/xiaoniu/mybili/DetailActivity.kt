package com.xiaoniu.mybili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val pos = intent.getIntExtra("pos",-1)
        //Toast.makeText(this, "" + pos, Toast.LENGTH_SHORT).show()
        val up = MainActivity.getUpById(pos)
        detailName.text = up.name
        detailFan.text = getString(R.string.fanCnt) + up.fan
        detailIconImg.setImageResource(up.imageId)
        detailFollow.setOnClickListener {
            MainActivity.delUpById(pos)
            finish()
        }
    }
}