package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.button).setOnClickListener {
            val flow = flow {
                emit(runCatching { "SAMPLE" })
            }
            lifecycleScope.launch {
                flow.collect { result ->
                    result.onSuccess { text ->
                        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
                    }
                    result.onFailure { e ->
                        Toast.makeText(this@MainActivity, e.localizedMessage, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

}