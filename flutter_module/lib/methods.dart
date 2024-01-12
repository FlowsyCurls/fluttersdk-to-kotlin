import 'package:flutter/services.dart';

class FlutterMethodChannel {
  static const MethodChannel _channel = MethodChannel('channel');

  static void setUpMethodChannel() {
    _channel.setMethodCallHandler(_handleMethodCall);
    print('El canal de método se ha configurado correctamente.');
  }

  static Future<dynamic> _handleMethodCall(MethodCall call) async {
    switch (call.method) {
      case 'sum':
        final int a = call.arguments['a'];
        final int b = call.arguments['b'];
        //call.
        return a + b; // Devuelve el resultado de la suma.
      default:
        throw PlatformException(
          code: 'Unimplemented',
          details:
              'The method ${call.method} is not implemented on the Flutter side.',
        );
    }
  }
}
