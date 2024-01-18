package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.direction.Direction
import es.valhallalabs.kpdf.api.size.ImperialSize
import es.valhallalabs.kpdf.api.size.PixelSize
import es.valhallalabs.kpdf.api.size.Size

/**
 * Represents the margins of a box, specified by the margins at the top, right,
 * bottom, and left. The margins can be different sizes and are determined by
 * the [Margin] objects provided.
 *
 * @property top The margin at the top.
 * @property right The margin on the right.
 * @property bottom The margin at the bottom.
 * @property left The margin on the left.
 * @property horizontalMargin Calculated margin based on left and right margin sizes.
 * @property verticalMargin Calculated margin based on top and bottom margin sizes.
 */
data class Margins(
	val top: Margin,
	val right: Margin,
	val bottom: Margin,
	val left: Margin,
) {
	companion object {
		val NO_MARGINS = Margins(
			top = Margin(direction = Direction.TOP, size = Size.ZERO),
			right = Margin(direction = Direction.RIGHT, size = Size.ZERO),
			bottom = Margin(direction = Direction.BOTTOM, size = Size.ZERO),
			left = Margin(direction = Direction.LEFT, size = Size.ZERO)
		)

		val A4 = Margins(
			top = Margin(direction = Direction.TOP, size = PixelSize(36f)),
			right = Margin(direction = Direction.RIGHT, size = PixelSize(36f)),
			bottom = Margin(direction = Direction.BOTTOM, size = PixelSize(36f)),
			left = Margin(direction = Direction.LEFT, size = PixelSize(36f))
		)

		val US_LETTER = Margins(
			top = Margin(direction = Direction.TOP, size = ImperialSize(1.0f)),
			right = Margin(direction = Direction.RIGHT, size = ImperialSize(1.0f)),
			bottom = Margin(direction = Direction.BOTTOM, size = ImperialSize(1.0f)),
			left = Margin(direction = Direction.LEFT, size = ImperialSize(1.0f))
		)
	}

	val horizontalMargin: Size
		get() = left.size + right.size

	val verticalMargin: Size
		get() = top.size + bottom.size
}

/**
 * Represents the size and direction of a single margin.
 *
 * @property size The size of the margin, represented as a [Size].
 * @property direction The direction in which the margin is oriented.
 */
data class Margin(
	val size: Size = Size.ZERO,
	val direction: Direction
)