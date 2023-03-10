package com.kooapps.stackybirdandroidw.gameActivity.fragments

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import architecture.BaseFragment
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.databinding.FragmentGameBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentGame : BaseFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    private val viewModel: FragmentGameViewModel by viewModels()
    private lateinit var imageViewsArray: Array<ImageView>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageViewsArray()

        createNewField()

        startTimer()

        setListeners()
        setObserver()
    }

    private fun setImageViewsArray() {
        with(binding) {
            imageViewsArray = arrayOf(
                iv1Variant, iv2Variant, iv3Variant, iv4Variant, iv5Variant,
                iv6Variant, iv7Variant, iv8Variant, iv9Variant, iv10Variant, iv11Variant,
                iv12Variant, iv13Variant, iv14Variant, iv15Variant, iv16Variant
            )
        }
    }

    private fun startTimer() {
        viewModel.gameStarted.observe(viewLifecycleOwner) {
            viewModel.startTimer()
        }
    }

    private fun setListeners() {
        for (imageView in imageViewsArray) {
            imageView.setOnClickListener {
                println("!!!!!!!!!!!!!!")
                println(viewModel.bitmapFirstBlock.value)
                println((imageView.drawable as BitmapDrawable).bitmap)
                println("!!!!!!!!!!!!!")
                if (viewModel.gameStarted.value == true) {
                    imageView.foreground = null
                    if (viewModel.bitmapFirstBlock.value == null) {
                        viewModel.setFirstBlock((imageView.drawable as BitmapDrawable).bitmap)
                        imageView.background = null
                    } else {
                        if ((imageView.drawable as BitmapDrawable).bitmap.sameAs(viewModel.bitmapFirstBlock.value) && imageView.background != null) {
                            viewModel.addAmountSameBlock()
                            imageView.background = null
                        } else viewModel.getIncorrectVariant()
                    }
                }
            }
        }
    }

    private fun createNewField() {
        CoroutineScope(Dispatchers.Main).launch {
            println("!!!!!!!!!!!!!!!!!!!!!")
            println(viewModel.gameStarted.value)
            println(viewModel.amountSameBlocks.value)
            println("!!!!!!!!!!!!!!!!!!!!!")
            for (i in 1..16) {
                val imageViewId =
                    resources.getIdentifier("iv$i" + "Variant", "id", requireActivity().packageName)
                val imageView = requireActivity().findViewById<ImageView>(imageViewId)
                imageView.setImageResource(randomBlocks())
                imageView.background = requireActivity().getDrawable(R.drawable.group_sixteen)
                imageView.foreground = null
            }
            delay(SHOWING_TIME)
            for (i in 1..16) {
                val id =
                    resources.getIdentifier("iv${i}Variant", "id", requireActivity().packageName)
                val imageView = requireActivity().findViewById<ImageView>(id)
                imageView.foreground = requireActivity().getDrawable(R.drawable.group_sixteen)
            }
            viewModel.setGameStatus()
        }
    }

    private fun randomBlocks(): Int {
        return when ((1..5).random()) {
            1 -> R.drawable.block_null_two
            2 -> R.drawable.block_two
            3 -> R.drawable.block_four
            4 -> R.drawable.block_neine //Neine is not bug - feature :)
            5 -> R.drawable.block_twentysix
            6 -> R.drawable.block_onehundredthirteen
            else -> 0
        }
    }

    private fun setObserver() {
        with(binding) {
            viewModel.amountSameBlocks.observe(viewLifecycleOwner) {
                if (it >= 3) {
                    viewModel.startNewRound()
                    createNewField()
                }
            }
            viewModel.timeSubject.observe(viewLifecycleOwner) {
                tvScore.text = getString(R.string.tv_time_string).format(it)
            }
            viewModel.scoreSubject.observe(viewLifecycleOwner) {
                tvTime.text = getString(R.string.tv_score_string).format(it)
            }
            viewModel.timeSubject.observe(viewLifecycleOwner) {
                if (it <= 0) {
                    findNavController().navigate(FragmentGameDirections.actionFragmentGameToFragmentOver(viewModel.scoreSubject.value.toString()))
                }
            }
        }
    }

    companion object {
        const val SHOWING_TIME = 1500L
    }
}