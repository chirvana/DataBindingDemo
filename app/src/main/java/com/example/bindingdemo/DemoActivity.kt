package com.example.bindingdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        when (intent.getSerializableExtra(MainActivity.INTENT_KEY) as ScreenType) {
            ScreenType.ACTIVITY_DEMO -> {
                fragment_demo_container.visibility = View.GONE

                button.setOnClickListener {
                    text_view.text = items.random()
                }
            }
            else -> transact()
        }
    }

    private fun transact() {
        button.visibility = View.GONE
        text_view.visibility = View.GONE

        val fragment: Fragment =
            when (intent.getSerializableExtra(MainActivity.INTENT_KEY) as ScreenType) {
                ScreenType.FRAGMENT_DEMO -> DemoFragment.newInstance()
                ScreenType.CUSTOM_VIEW_DEMO -> CustomViewFragment.newInstance()
                ScreenType.RECYCLER_VIEW_DEMO -> ListDemoFragment.newInstance()
                else -> Fragment()
            }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_demo_container, fragment)
            .commit()
    }
}