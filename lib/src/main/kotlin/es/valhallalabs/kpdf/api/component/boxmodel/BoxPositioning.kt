package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.direction.HorizontalAlignment
import es.valhallalabs.kpdf.api.direction.VerticalAlignment


data class BoxPositioning(
	val verticalAlignment: VerticalAlignment = VerticalAlignment.TOP,
	val horizontalAlignment: HorizontalAlignment = HorizontalAlignment.LEFT,
	val growBehaviour: GrowBehaviour = GrowBehaviour(expandWidth = false, expandHeight = false)
) {
	companion object {
		val FULL_EXPANSION = BoxPositioning(
			growBehaviour = GrowBehaviour(expandHeight = true, expandWidth = true)
		)
	}
}

data class GrowBehaviour(
	val expandWidth: Boolean = false,
	val expandHeight: Boolean = false
)