import 'package:flutter/material.dart';
import 'methods.dart';

void main() {
  // Asegurar  que el método se ejecute después de que se haya inicializado el binding.
  WidgetsFlutterBinding.ensureInitialized();

  // Configurar el canal de método.
  FlutterMethodChannel.setUpMethodChannel();
  
  // Aquí normalmente iría la ejecución de la app Flutter, pero como no se necesita interfaz
}
