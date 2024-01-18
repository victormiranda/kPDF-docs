package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.Size

data class Paddings(
	val top: Padding,
	val right: Padding,
	val bottom: Padding,
	val left: Padding,
) {
	companion object {
		val NO_PADDINGS: Paddings =
			Paddings(
				top = Padding(Size.ZERO),
				right = Padding(Size.ZERO),
				bottom = Padding(Size.ZERO),
				left = Padding(Size.ZERO),
			)

		fun buildSameSizePaddings(size: Size) =
			Paddings(
				top = Padding(size),
				right = Padding(size),
				bottom = Padding(size),
				left = Padding(size),
			)
	}

	val horizontalPadding: Size
		get() = left.size + right.size

	val verticalPadding: Size
		get() = top.size + bottom.size
}

data class Padding(val size: Size = Size.ZERO)