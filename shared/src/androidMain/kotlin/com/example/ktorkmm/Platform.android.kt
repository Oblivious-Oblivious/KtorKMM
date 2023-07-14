package com.example.ktorkmm;

// CLASSES
actual class PlatformClass {
    actual fun name(): String =
        "Android ${android.os.Build.VERSION.SDK_INT}";
}

// FUNCTIONS
actual fun platformFunction(): String =
    "Android ${android.os.Build.VERSION.SDK_INT}";

// PROPERTIES
actual val platformProperty: String =
    "Android ${android.os.Build.VERSION.SDK_INT}";

// OBJECTS
actual object PlatformObject {
    actual val name: String =
        "Android ${android.os.Build.VERSION.SDK_INT}";
}

// ENUMS
actual enum class Direction {
    NORTH, SOUTH, EAST, WEST;

    actual fun display(): String =
        "Android: Moving $name";
}
