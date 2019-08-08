package com.xachin.model


data class HyperRect(
    val lower: DoubleArray,
    val upper: DoubleArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as HyperRect

        if (!lower.contentEquals(other.lower)) return false
        if (!upper.contentEquals(other.upper)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lower.contentHashCode()
        result = 31 * result + upper.contentHashCode()
        return result
    }
}
