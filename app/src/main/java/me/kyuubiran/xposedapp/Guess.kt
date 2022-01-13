package me.kyuubiran.xposedapp

import android.util.Log

class Guess {
    private val answer: Int = (0..2).random()

    fun isDraw(guess: Int): Boolean {
        val isDraw = guess == answer
        Log.i("Guess", "isDraw: $isDraw")
        return isDraw
    }

    fun isWin(guess: Int): Boolean {
        val isWin = when (guess) {
            0 -> answer == 1
            1 -> answer == 2
            2 -> answer == 0
            else -> false
        }
        Log.i("Guess", "isWin: $isWin")
        return isWin
    }

    fun getAnswer(): String {
        return when (answer) {
            0 -> "石头"
            1 -> "剪刀"
            2 -> "布"
            else -> ""
        }
    }
}