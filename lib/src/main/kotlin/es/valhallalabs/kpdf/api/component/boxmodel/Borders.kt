package es.valhallalabs.kpdf.api.component.boxmodel

/**
 * Represents the borders of a component.
 *
 * @property top Specifies the top border of the component.
 * @property right Specifies the right border of the component.
 * @property bottom Specifies the bottom border of the component.
 * @property left Specifies the left border of the component.
 */
data class Borders(
	val top: Border,
	val right: Border,
	val bottom: Border,
	val left: Border,
)

/**
 * Represents a single border in a component.
 *
 * @property size Specifies the size of the border.
 * @property borderType Specifies the type of the border.
 */
data class Border(
	val size: Float = 0f,
	val borderType: BorderType = BorderType.NONE
)