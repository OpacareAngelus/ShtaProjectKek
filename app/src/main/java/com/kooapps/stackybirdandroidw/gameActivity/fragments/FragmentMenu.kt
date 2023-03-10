package com.kooapps.stackybirdandroidw.gameActivity.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import architecture.BaseFragment
import com.kooapps.stackybirdandroidw.databinding.FragmentMenuBinding

class FragmentMenu : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() {
        with(binding) {
            btnStartGame.setOnClickListener {
                findNavController().navigate(FragmentMenuDirections.actionFragmentMenuToFragmentGame())
            }
            btnExit.setOnClickListener {
                requireActivity().finish()
            }
        }
    }
}