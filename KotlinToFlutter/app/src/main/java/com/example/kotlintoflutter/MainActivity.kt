package com.example.kotlintoflutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wrapper.Calculator

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var btnAdd: Button
    private lateinit var etA: EditText
    private lateinit var etB: EditText
    private lateinit var resultTv: TextView

    // Use lib
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set FlutterEngine.
        //val flutterEngine = configureFlutterEngine()

        // Configures the native method channel.
        //NativeMethodChannel.configureChannel(flutterEngine)


        // Kotlin testing interface
        btnAdd = findViewById(R.id.btn_add)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_tv)

        btnAdd.setOnClickListener(this)
    }

//    private fun configureFlutterEngine(): FlutterEngine {
//        // Create a new FlutterEngine instance.
//        val flutterEngine = FlutterEngine(this)
//
//        // Start the Dart execution in the FlutterEngine.
//        flutterEngine.dartExecutor.executeDartEntrypoint(
//            DartExecutor.DartEntrypoint.createDefault()
//        )
//
//        // Register the plugins generated with the FlutterEngine.
//        GeneratedPluginRegistrant.registerWith(flutterEngine)
//
//        return flutterEngine
//    }


    override fun onClick(v: View?) {
        val a = etA.text.toString().toInt()
        val b = etB.text.toString().toInt()
        when (v?.id) {
            R.id.btn_add -> {
                // Call the sum method of Calculator
                val result = calculator.sum(a, b)
                resultTv.text = result.toString()
            }
        }
    }
}