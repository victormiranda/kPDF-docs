package es.valhallalabs.kpdf.api.component.style

import es.valhallalabs.kpdf.api.color.Color


/**
 * Interface that represents a style
 *
 * @property name Name of the style
 * @property parentStyle Style from which this style inherits, if any
 */
interface Style {
	val name: String
	val parentStyle: Style?
	val backgroundColor: Color
	val foregroundColor: Color
}

open class BaseStyle(
	override val name: String = "BASE_STYLE",
	override val parentStyle: Style? = null,
	override val backgroundColor: Color = Color.TRANSPARENT,
	override val foregroundColor: Color = Color.BLACK
) : Style

data class PlainStyle(
	override val parentStyle: Style? = null,
	override val backgroundColor: Color = Color.TRANSPARENT,
	override val foregroundColor: Color = Color.BLACK
) : BaseStyle(
	name = "PLAIN_STYLE",
	parentStyle = parentStyle,
	backgroundColor = backgroundColor,
	foregroundColor = foregroundColor
)