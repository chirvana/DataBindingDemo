package com.example.bindingdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val items = listOf(
    "Movie 1",
    "Movie 2",
    "Movie 3",
    "Movie 4",
    "Movie 5",
    "Movie 6",
    "Movie 7",
    "Movie 8",
    "Movie 9",
    "Movie 10",
    "Movie 11",
    "Movie 12",
    "Movie 13",
    "Movie 14",
    "Movie 15",
    "Movie 16"
)

/**
 * A fragment representing a list of Items.
 */
class ListDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_demo_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyMovieRecyclerViewAdapter(items)
            }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListDemoFragment()
    }
}