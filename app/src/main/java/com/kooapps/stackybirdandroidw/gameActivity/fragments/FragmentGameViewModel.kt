package com.kooapps.stackybirdandroidw.gameActivity.fragments

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentGameViewModel : ViewModel() {

    private val _amountSameBlocks = MutableLiveData<Int>()
    val amountSameBlocks: LiveData<Int> = _amountSameBlocks

    private val _timeSubject = MutableLiveData<Int>()
    val timeSubject: LiveData<Int> = _timeSubject

    private val _scoreSubject = MutableLiveData<Int>()
    val scoreSubject: LiveData<Int> = _scoreSubject

    private val _gameStarted = MutableLiveData<Boolean>()
    val gameStarted: LiveData<Boolean> = _gameStarted

    private val _bitmapFirstBlock = MutableLiveData<Bitmap?>()
    val bitmapFirstBlock: LiveData<Bitmap?> = _bitmapFirstBlock

    init {
        _timeSubject.postValue(STARTING_TIME)
        _scoreSubject.postValue(0)
        _amountSameBlocks.postValue(0)
    }

    private fun setTime(time: Int) = _timeSubject.postValue(time)
    private fun setScore(score: Int) = _scoreSubject.postValue(score)

    fun setGameStatus() {
        if (_gameStarted.value == null) {
            _gameStarted.postValue(true)
        } else _gameStarted.value = !_gameStarted.value!!
    }

    fun setFirstBlock(bitmap: Bitmap) {
        _bitmapFirstBlock.value = bitmap
        addAmountSameBlock()
    }

    fun startTimer() {
        if (_gameStarted.value == true)
            viewModelScope.launch {
                while (_timeSubject.value!! > 0) {
                    setTime(_timeSubject.value!! - 1)
                    delay(ONE_SECOND_DELAY)
                }
                setGameStatus()
            }
    }

    fun addAmountSameBlock() {
        _amountSameBlocks.postValue(_amountSameBlocks.value?.plus(1))
    }

    private fun refreshAmountSameBlocks() {
        _amountSameBlocks.postValue(0)
    }

    fun startNewRound() {
        setScore(_scoreSubject.value!!.plus(SCORE_FOR_CORRECT_ANSWER * AMOUNT_BLOCKS_FOR_WIN))
        setTime(_timeSubject.value!!.plus(TIME_FOR_CORRECT_ANSWER))
        refreshAmountSameBlocks()
        refreshFirstBlock()
        setGameStatus()
        stopTimer()
    }

    private fun refreshFirstBlock() {
        _bitmapFirstBlock.postValue(null)
    }

    fun getIncorrectVariant() {
        setScore(_scoreSubject.value!!.minus(LOSE_SCORE_AFTER_MISTAKE))
    }

    fun stopTimer() {
        viewModelScope.coroutineContext.cancelChildren()
    }

    companion object {
        const val STARTING_TIME = 15
        const val LOSE_SCORE_AFTER_REFRESH = 2
        const val LOSE_SCORE_AFTER_MISTAKE = 1
        const val ONE_SECOND_DELAY = 1000L
        const val SCORE_FOR_CORRECT_ANSWER = 5
        const val AMOUNT_BLOCKS_FOR_WIN = 3
        const val TIME_FOR_CORRECT_ANSWER = 3
    }
}