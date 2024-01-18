package es.valhallalabs.kpdf.api.component.page

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import es.valhallalabs.kpdf.api.component.container.Container

/**
 * Page interface represents a document page.
 * Each implementation of this interface represents a specific type of page.
 */
interface Page : Component {

	override val componentType: ComponentType
		get() = ComponentType.PAGE

}

/**
 * This subtype of page is represented with a container filling all the page
 */
data class FullContainerPage(
	override val box: PageFormat
) : Page, Container