package com.example.wrapper

import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.coroutineScope

object NativeMethodChannel {
    private const val CHANNEL_NAME = "channel"
    private lateinit var methodChannel: MethodChannel

    fun configureChannel(flutterEngine: FlutterEngine) {
        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL_NAME)
    }

    suspend fun sum(a: Int, b: Int): Int? = coroutineScope {
        val arguments = mapOf("a" to a, "b" to b)
        val result = CompletableDeferred<Int?>()

        methodChannel.invokeMethod("sum", arguments, object : MethodChannel.Result {
            override fun success(sumResult: Any?) {
                val castedResult = (sumResult as? Double)?.toInt() ?: sumResult as? Int
                result.complete(castedResult)
            }

            override fun error(code: String, error: String?, details: Any?) {
                println("Error al realizar la suma: $error")
                result.complete(null)
            }

            override fun notImplemented() {
                println("El método 'sum' no está implementado en Flutter.")
                result.complete(null)
            }
        })

        result.await() // Espera a que la llamada al método se complete antes de continuar.
    }

}
