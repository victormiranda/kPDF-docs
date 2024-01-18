package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.Size

/**
 * Data class that represents a Rectangle
 *
 * @property width the width of the rectangle
 * @property height the height of the rectangle
 */
data class Rectangle(
	val width: Size,
	val height: Size
)