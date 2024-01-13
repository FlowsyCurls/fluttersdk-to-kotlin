package com.example.kotlintoflutter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch

class Calculator {
    fun sum(a: Int, b: Int): Int? {
        val latch = CountDownLatch(1)
        var result: Int? = null

        GlobalScope.launch {
            // Call the sum method of NativeMethodChannel and get the result from Flutter
            result = NativeMethodChannel.sum(a, b)
            latch.countDown() // Decrementa el contador del latch, permitiendo que el hilo principal continúe
        }

        latch.await() // Espera hasta que el contador del latch llegue a cero
        return result
    }
}
