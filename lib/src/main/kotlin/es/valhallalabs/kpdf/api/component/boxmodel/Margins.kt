package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.direction.Direction
import es.valhallalabs.kpdf.api.size.ImperialSize
import es.valhallalabs.kpdf.api.size.PixelSize
import es.valhallalabs.kpdf.api.size.Size

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

data class Margin(
	val size: Size = Size.ZERO,
	val direction: Direction
)