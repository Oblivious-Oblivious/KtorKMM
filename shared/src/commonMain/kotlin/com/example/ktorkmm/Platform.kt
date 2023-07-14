package com.example.ktorkmm;

// CLASSES
expect class PlatformClass {
    fun name(): String;
}

// FUNCTIONS
expect fun platformFunction(): String;

// PROPERTIES
expect val platformProperty: String;

// OBJECT DECLARATIONS
expect object PlatformObject {
    val name: String;
}

// ENUMS
expect enum class Direction {
    NORTH, SOUTH, EAST, WEST;

    fun display(): String
}


// NOTE Class below is used by both Kotlin and Swift
class CommonDataModel {
    companion object {
        val platformFunctionCommon: () -> String = { platformFunction() };
        val platformPropertyCommon: String = platformProperty;
        val platformObjectCommon: PlatformObject = PlatformObject;

        fun direction(direction: Direction): String {
            return direction.display();
        }
    }
}
