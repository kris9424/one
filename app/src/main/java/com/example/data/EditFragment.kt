package com.example.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditFragment : Fragment(R.layout.fragment_edit) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titeleText = view.findViewById<EditText>(R.id.titleText)
        val messageText = view.findViewById<EditText>(R.id.massageText)
        val add = view.findViewById<Button>(R.id.addPost)
        val viewButton = view.findViewById<Button>(R.id.viewButton)

        add.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                (requireActivity() as MainActivity).database.getDao().insertPost(
                    Post(
                        0, titeleText.text.toString(),
                        messageText.text.toString()
                    )

                )
            }

        }
        viewButton.setOnClickListener {
            (requireActivity() as MainActivity).toView()

        }

    }

    companion object {

        fun newInstance() =
            EditFragment()
                }

    }
