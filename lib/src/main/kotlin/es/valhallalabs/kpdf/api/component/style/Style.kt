package es.valhallalabs.kpdf.api.component.style

/**
 * Interface that represents a style
 *
 * @property name Name of the style
 * @property parentStyle Style from which this style inherits, if any
 */
interface Style {
	val name: String
	val parentStyle: Style?
}