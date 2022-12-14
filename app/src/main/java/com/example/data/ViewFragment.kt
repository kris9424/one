package com.example.data

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewFragment : Fragment(R.layout.fragment_view) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.message)
        val backButton = view.findViewById<Button>(R.id.back)
        backButton.setOnClickListener {
            (requireActivity() as MainActivity).toEdit()
        }
        lifecycleScope.launch(Dispatchers.IO) {
            val posts = (requireActivity() as MainActivity).database.getDao().getPost()
            val adapter = Adapter(requireContext(), posts)
            withContext(Dispatchers.Main){
                recyclerView.adapter = adapter
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ViewFragment()
    }
}