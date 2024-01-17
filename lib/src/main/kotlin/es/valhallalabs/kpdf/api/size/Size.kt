package es.valhallalabs.kpdf.api.size

import kotlin.math.round

/**
 * Interface defining methods and properties related to sizes.
 */
interface Size {
    val points: Float

    companion object {
        const val MILLIMETERS_PER_INCH = 25.4f
        const val DEFAULT_DPI: Int = 72
        val ZERO: Size = PointSize(points = 0f)
    }

    /**
     * Operator for adding sizes together.
     *
     * @param another The size to be added.
     * @return A new size that is the sum of the two sizes.
     */
    operator fun plus(another: Size): Size = PointSize(points = this.points + another.points)

    /**
     * Operator for adding sizes together.
     *
     * @param another The size to be subtracted.
     * @return A new size that is the subtraction of the two sizes.
     */
    operator fun minus(another: Size): Size = PointSize(points = this.points - another.points)

}

/**
 * Class representing a size in points, a physical unit.
 *
 * @property points The size in points.
 */
open class PointSize(override val points: Float) : Size

/**
 * Class representing a size in pixels, ideal for screen representation.
 *
 * @property pixels The size in pixels.
 * @property dpi The dots per inch used for conversion.
 * @property points The size in points, obtained after converting and rounding pixels and dpi .
 */
open class PixelSize(
        private val pixels: Float,
        val dpi: Int = Size.DEFAULT_DPI,
) : Size {
    override val points: Float
        get() = (pixels * 72.0 / dpi).round(decimals = 2)
}

/**
 * Class representing a size in inches.
 *
 * @property inches The size in inches.
 * @property dpi The dots per inch used for conversion.
 * @property points The size in points, obtained after converting and rounding inches and dpi.
 */
open class ImperialSize(
        val inches: Float,
        val dpi: Int = Size.DEFAULT_DPI,
) : Size {
    override val points: Float
        get() = inches * dpi
}

/**
 * Class representing a size in millimeters.
 *
 * @property mm The size in millimeters.
 * @property dpi The dots per inch used for conversion.
 * @property points The size in points, obtained after converting and rounding mm and dpi ..
 */
data class MetricSize(
        val mm: Float,
        val dpi: Int = Size.DEFAULT_DPI,
) : Size {
    override val points: Float
        get() = (mm / Size.MILLIMETERS_PER_INCH) * dpi
}

/**
 * Extension function to round a Double value to a specific number of decimal places.
 *
 * @param decimals The number of decimal places to round to.
 * @return The rounded Float value.
 */
private fun Double.round(decimals: Int): Float {
    var multiplier = 1f
    repeat(decimals) { multiplier *= 10 }
    return (round(this * multiplier) / multiplier).toFloat()
}