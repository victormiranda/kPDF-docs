package es.valhallalabs.kpdf.api.component.page

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import es.valhallalabs.kpdf.api.component.style.BaseStyle
import es.valhallalabs.kpdf.api.component.style.Style

/**
 * Page interface represents a document page.
 * Each implementation of this interface represents a specific type of page.
 */
interface Page : Component {

	override val componentType: ComponentType
		get() = ComponentType.PAGE

}


class PageFrame(
	override val box: BoxModel,
	override val style: Style = BaseStyle()
) : Page

data class SinglePageComponent(
	override val box: PageFormat,
	val component: Component,
	override val style: Style = BaseStyle()
) : Page