package com.xachin.model


data class Point(
    val coordinates: DoubleArray,
    val tag: Any? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Point

        if (!coordinates.contentEquals(other.coordinates)) return false
        if (tag != other.tag) return false

        return true
    }

    override fun hashCode(): Int {
        var result = coordinates.contentHashCode()
        result = 31 * result + (tag?.hashCode() ?: 0)
        return result
    }
}
