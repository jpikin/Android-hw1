package com.example.a1hw

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a1hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val maxSeat = 50
    private var counter = 0
    private var textCounter = maxSeat - counter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = binding.textView.context.getText((R.string.startText))
        binding.b1.text = binding.textView.context.getText((R.string.b1Text))
        binding.b2.text = binding.textView.context.getText((R.string.b2Text))
        binding.counter.text = counter.toString()

        binding.b1.setOnClickListener {
            if (counter < maxSeat) {
                counter++
                textCounter = maxSeat - counter
                if (textCounter == 0) {
                    binding.textView.setTextColor(Color.RED)
                    binding.textView.text = "Пассажиров слишком много"
                    binding.b3.visibility = View.VISIBLE
                } else {
                    binding.textView.setTextColor(Color.BLUE)
                    binding.textView.text = "Осталось мест: $textCounter"
                }
            }
            binding.counter.text = counter.toString()
        }
        binding.b2.setOnClickListener {

            if (counter > 0) {
                counter--
                textCounter = maxSeat - counter
                if (textCounter == maxSeat) {
                    binding.textView.setTextColor(Color.GREEN)
                    binding.textView.text = "Все места свободны"
                } else {
                    binding.textView.text = "Осталось мест: $textCounter"
                }

            }

            binding.counter.text = counter.toString()
        }

        binding.b3.setOnClickListener {
            counter = 0
            binding.counter.text = counter.toString()
            binding.textView.setTextColor(Color.GREEN)
            binding.textView.text = "Все места свободны"
            binding.b3.visibility = View.INVISIBLE
        }

    }
    fun check(){}
}