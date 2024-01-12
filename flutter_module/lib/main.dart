import 'package:flutter/services.dart';

void main() {
  const MethodChannel channel = MethodChannel('sum_channel');

  channel.setMethodCallHandler((MethodCall call) async {
    if (call.method == 'computeSum') {
      int a = call.arguments['a'];
      int b = call.arguments['b'];

      int result = computeSum(a, b);
      return result;
    }
    return null;
  });
}

int computeSum(int a, int b) {
  return a + b;
}
