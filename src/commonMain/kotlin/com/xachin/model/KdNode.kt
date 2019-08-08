package com.xachin.model


data class KdNode(
    val key: Point,
    val dimension: Int,
    var left: KdNode?,
    var right: KdNode?
)
