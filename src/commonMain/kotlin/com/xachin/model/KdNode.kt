package com.xachin.model


data class KdNode(
    val key: Point,
    val dimension: Int,
    val bounds: HyperRect,
    var left: KdNode?,
    var right: KdNode?
)
