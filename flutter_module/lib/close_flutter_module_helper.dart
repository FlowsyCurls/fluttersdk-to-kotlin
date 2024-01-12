import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';

class CloseFlutterModuleHelper {
  static const methodChannel =
      MethodChannel('samples.flutter.dev/close_flutter');

  CloseFlutterModuleHelper._privateConstructor();
  static Future<void> closeFlutterScreen() async {
    try {
      if (Platform.isAndroid) {
        SystemNavigator.pop();
      } else {
        await methodChannel.invokeListMethod('dismissFlutterModule');
      }
    } on PlatformException catch (e) {
      debugPrint(e.toString());
    }
  }
}
