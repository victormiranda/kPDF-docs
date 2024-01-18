package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.Size

/**
 * Class Paddings is responsible for representing the padding properties of a component.
 * It includes the top, right, bottom and left padding size for the component box model.
 *
 * @property top Represents padding size on the top of component.
 * @property right Represents padding size on the right side of component.
 * @property bottom Represents padding size at the bottom of component.
 * @property left Represents padding size on the left of component.
 * @property horizontalPadding Total horizontal padding size i.e., sum of left and right padding size.
 * @property verticalPadding Total vertical padding size i.e., sum of top and bottom padding size.
 */
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

		/**
		 * Function to create paddings of the same size.
		 */
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

/**
 * Class Padding holds the size information in a padding.
 *
 * @property size Size of the padding.
 */
data class Padding(val size: Size = Size.ZERO)