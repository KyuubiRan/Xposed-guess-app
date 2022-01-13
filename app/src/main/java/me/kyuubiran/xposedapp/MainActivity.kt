package me.kyuubiran.xposedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var confirmBtn: Button
    lateinit var radioGroup: RadioGroup
    private var selected: Int = 0
    private val selectedText: String
        get() = when (selected) {
            0 -> "石头"
            1 -> "剪刀"
            2 -> "布"
            else -> "石头"
        }

    private fun confirm() {
        val game = Guess()
        AlertDialog.Builder(this).run {
            if (game.isDraw(selected)) {
                setTitle("平局！")
                setMessage("对手和你一样都出了${selectedText}")
                setPositiveButton("好吧！", null)
            } else {
                if (game.isWin(selected)) {
                    setTitle("你赢了！")
                    setMessage("你赢了对手！对手出了${game.getAnswer()}，而你出了${selectedText}")
                    setPositiveButton("好耶！", null)
                } else {
                    setTitle("你输了！")
                    setMessage("你输给了对手！对手出了${game.getAnswer()}，而你出了${selectedText}")
                    setPositiveButton("坏耶！", null)
                }
            }
            show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        confirmBtn = findViewById(R.id.btn_confirm)
        radioGroup = findViewById(R.id.radio_group)

        confirmBtn.setOnClickListener { confirm() }

        radioGroup.setOnCheckedChangeListener { _, c ->
            selected = when (c) {
                R.id.btn1 -> 0
                R.id.btn2 -> 1
                R.id.btn3 -> 2
                else -> 0
            }
        }
    }
}