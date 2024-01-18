package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.direction.HorizontalAlignment
import es.valhallalabs.kpdf.api.direction.VerticalAlignment

/**
 * Represents a box's positioning within a container.
 *
 * @property verticalAlignment Determines the vertical alignment of the box. Default is TOP.
 * @property horizontalAlignment Determines the horizontal alignment of the box. Default is LEFT.
 * @property growBehaviour Determines the grow behaviour of the box. Default is false for both height and width.
 *
 * @constructor Creates a new instance of BoxPositioning.
 */
data class BoxPositioning(
	val verticalAlignment: VerticalAlignment = VerticalAlignment.TOP,
	val horizontalAlignment: HorizontalAlignment = HorizontalAlignment.LEFT,
	val growBehaviour: GrowBehaviour = GrowBehaviour(expandWidth = false, expandHeight = false)
) {
	companion object {
		/**
		 * A constant representing a box positioning where both the width and height are expanded.
		 */
		val FULL_EXPANSION = BoxPositioning(
			growBehaviour = GrowBehaviour(expandHeight = true, expandWidth = true)
		)
	}
}

/**
 * Represents the grow behaviour of a box.
 *
 * @property expandWidth Determines if the box should expand in width. Default is false.
 * @property expandHeight Determines if the box should expand in height. Default is false.
 *
 * @constructor Create a new instance of GrowBehaviour.
 */
data class GrowBehaviour(
	val expandWidth: Boolean = false,
	val expandHeight: Boolean = false
)