package es.valhallalabs.kpdf.api.component.page

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import es.valhallalabs.kpdf.api.component.container.Container

interface Page : Component {

	override val componentType: ComponentType
		get() = ComponentType.PAGE

}

data class FullContainerPage(
	override val box: PageFormat
) : Page, Container
