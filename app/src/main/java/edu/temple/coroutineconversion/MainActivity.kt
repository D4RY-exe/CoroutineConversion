package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Locale
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    private val cakeImageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    private val currentTextView: TextView by lazy {
        findViewById(R.id.currentTextView)
    }

    //val handler = Handler(Looper.getMainLooper(), Handler.Callback {
    //    currentTextView.text = String.format(Locale.getDefault(), "Current opacity: %d", it.what)
    //    cakeImageView.alpha = it.what / 100f
    //    true
    //})
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            lifecycleScope.launch {
                repeat(100){opacityValue ->
                    currentTextView.text = String.format (Locale.getDefault(), "Current opacity: %d", opacityValue)
                    cakeImageView.alpha = opacityValue / 100f
                    delay(40)
                }
            }
        }
    }
}