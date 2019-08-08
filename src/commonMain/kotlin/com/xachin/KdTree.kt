package com.xachin

import com.xachin.model.KdNode
import com.xachin.model.Point


class KdTree(inputPoints: Collection<Point>) {

    private val k: Int
    private val root: KdNode?

    init {
        if (inputPoints.isEmpty()) throw IllegalArgumentException("no input points")
        k = inputPoints.first().coordinates.size
        if (k < 1) throw IllegalArgumentException("dimensions cannot be less than 1")

        val points = if (inputPoints is MutableList<Point>) inputPoints else inputPoints.toMutableList()
        root = generateTree(points, 0)
    }

    /**
     * @param d index of dimension to split with
     */
    private fun generateTree(points: MutableList<Point>, d: Int): KdNode? {
        if (points.isEmpty()) return null

        val sortedPoints = points.sortedBy { it.coordinates[d] }
        sortedPoints.forEachIndexed { index, point -> points[index] = point }

        var median = points.size / 2
        while (median > 0 && points[median - 1].coordinates[d] == points[median].coordinates[d]) median--

        val nextDimension = if (k - d < 1) d + 1 else 0

        return KdNode(
            points[median],
            d,
            generateTree(points.subList(0, median), nextDimension),
            generateTree(points.subList(median + 1, points.size), nextDimension)
        )
    }

}
