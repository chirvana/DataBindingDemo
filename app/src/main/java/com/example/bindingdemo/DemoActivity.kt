package com.example.bindingdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bindingdemo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getSerializableExtra(MainActivity.INTENT_KEY) as ScreenType) {
            ScreenType.ACTIVITY_DEMO -> {
                binding.fragmentDemoContainer.visibility = View.GONE

                binding.button.setOnClickListener {
                    binding.textView.text = items.random()
                }
            }
            else -> transact()
        }
    }

    private fun transact() {
        with(binding) {
            button.visibility = View.GONE
            textView.visibility = View.GONE
        }


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