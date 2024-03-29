package com.example.homework

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.graphics.drawable.AnimationDrawable
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var mAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.ivAnimator)
        val startButton = findViewById<Button>(R.id.buttonStart)
        val stopButton = findViewById<Button>(R.id.buttonStop)
        val nextButton = findViewById<Button>(R.id.buttonNext)

        val frames = arrayOf(R.drawable.archer, R.drawable.puma, R.drawable.bird)
        var currentFrame = 0

        image.setBackgroundResource(frames[0])
        mAnimation = image.background as AnimationDrawable

        startButton.setOnClickListener {
            mAnimation.start()
        }

        stopButton.setOnClickListener {
            mAnimation.stop()
        }

        nextButton.setOnClickListener {
            val framesCount = frames.size

            if (currentFrame + 1 != framesCount) {
                image.setBackgroundResource(frames[currentFrame + 1])
                mAnimation = image.background as AnimationDrawable
                currentFrame += 1
            } else {
                currentFrame = 0
                image.setBackgroundResource(frames[currentFrame])
                mAnimation = image.background as AnimationDrawable
            }

//            if (currentFrame < framesCount) {
//                currentFrame + 1
//                image.setBackgroundResource(frames[currentFrame])
//                mAnimation = image.background as AnimationDrawable
//            } else {
//                currentFrame = 0
//                image.setBackgroundResource(frames[currentFrame])
//                mAnimation = image.background as AnimationDrawable
//            }
        }
    }
}
