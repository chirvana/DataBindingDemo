package com.example.bindingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        demo1.setOnClickListener {
            val intent = Intent(this, DemoActivity::class.java)
            intent.putExtra(INTENT_KEY, ScreenType.ACTIVITY_DEMO)
            startActivity(intent)
        }
        demo2.setOnClickListener {
            val intent = Intent(this, DemoActivity::class.java)
            intent.putExtra(INTENT_KEY, ScreenType.FRAGMENT_DEMO)
            startActivity(intent)
        }
        demo3.setOnClickListener {
            val intent = Intent(this, DemoActivity::class.java)
            intent.putExtra(INTENT_KEY, ScreenType.CUSTOM_VIEW_DEMO)
            startActivity(intent)
        }
        demo4.setOnClickListener {
            val intent = Intent(this, DemoActivity::class.java)
            intent.putExtra(INTENT_KEY, ScreenType.RECYCLER_VIEW_DEMO)
            startActivity(intent)
        }

    }

    companion object {
        const val INTENT_KEY = "intentKey"
    }
}