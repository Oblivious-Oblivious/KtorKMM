package com.example.ktorkmm;

import platform.UIKit.UIDevice;

// CLASSES
actual class PlatformClass {
    actual fun name(): String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion;
}

// FUNCTIONS
actual fun platformFunction(): String
    = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion;

// PROPERTIES
actual val platformProperty: String
    = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion;

// OBJECTS
actual object PlatformObject {
    actual val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion;
}

// ENUMS
actual enum class Direction {
    NORTH, SOUTH, EAST, WEST;

    actual fun display(): String =
        "iOS: Moving $name";
}
