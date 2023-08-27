package com.example.keries


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class Home : Fragment() {

    private lateinit var countDownTimer: CountDownTimer
    private lateinit var countdownTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countdownTextView = view.findViewById(R.id.countdownTextView)
        fetchSystemDateTime()
    }

    private fun fetchSystemDateTime() {
        val currentTimeMillis = System.currentTimeMillis()
        val targetDateString = "2023-10-23T23:59:59" // Replace with your target date
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val targetDate = sdf.parse(targetDateString)
        val timeDifferenceMillis = targetDate.time - currentTimeMillis

        startCountdown(timeDifferenceMillis)
    }

    private fun startCountdown(timeInMillis: Long) {
        countDownTimer = object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60

                val countdownText = String.format(
                    "%02d:%02d:%02d:%02d",
                    days, hours, minutes, seconds
                )
                countdownTextView.text = countdownText
            }

            override fun onFinish() {
                countdownTextView.text = "Countdown finished"
            }
        }.start()
    }
}
