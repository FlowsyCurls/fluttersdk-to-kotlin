import 'package:flutter/services.dart';

class MethodChannelHelper {
  static const platform = const MethodChannel('com.example.sum_channel');

  static Future<int> calculateSum(int a, int b) async {
    try {
      final result =
          await platform.invokeMethod('calculateSum', {'a': a, 'b': b});
      return result;
    } on PlatformException catch (e) {
      print("Error: ${e.message}");
      return 0; // or some default value
    }
  }
}
