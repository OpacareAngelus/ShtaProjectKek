package com.kooapps.stackybirdandroidw.gameActivity.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import architecture.BaseFragment
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.databinding.FragmentOverBinding


class FragmentOver : BaseFragment<FragmentOverBinding>(FragmentOverBinding::inflate) {

    private val args: FragmentGameArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setScore()
        setListener()
    }

    private fun setScore() {
        binding.tvGameOver.text = getString(R.string.game_over).format(args.score)
    }

    private fun setListener() {
        binding.btnRestart.setOnClickListener {
            findNavController().navigate(FragmentOverDirections.actionFragmentOverToFragmentGame(""))
        }
    }
}