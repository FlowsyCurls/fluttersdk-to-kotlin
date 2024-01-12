package com.example.addflutter

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import kotlin.random.Random
import androidx.annotation.NonNull

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "example.com/channel").setMethodCallHandler {
                call, result ->
            if(call.method == "getRandomString") {
                val limit = call.arguments() ?: 4
                if(limit < 0) {
                    result.error("INVALIDARGS", "String length should not be a negative integer", null)
                }
                else {
                    val rand = ('a'..'z')
                        .shuffled()
                        .take(limit)
                        .joinToString("")
                    result.success(rand)
                }
            }
        }
    }
}