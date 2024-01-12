import 'package:flutter/services.dart';

class Calculator {
  static const MethodChannel _channel =
      MethodChannel('samples.flutter.dev/calculator');

  static void setup() {
    _channel.setMethodCallHandler((MethodCall call) async {
      if (call.method == "add") {
        final a = call.arguments['a'] as int;
        final b = call.arguments['b'] as int;
        return add(a, b);
      } else if (call.method == "mult") {
        final a = call.arguments['a'] as int;
        final b = call.arguments['b'] as int;
        return mult(a, b);
      } else if (call.method == "div") {
        final a = call.arguments['a'] as int;
        final b = call.arguments['b'] as int;
        return div(a, b);
      }
    });
  }

  static int add(int a, int b) {
    return a + b;
  }

  static int mult(int a, int b) {
    return a * b;
  }

  static double div(int a, int b) {
    if (b == 0) {
      throw Exception("Cannot divide by zero");
    }
    return a / b;
  }
}
