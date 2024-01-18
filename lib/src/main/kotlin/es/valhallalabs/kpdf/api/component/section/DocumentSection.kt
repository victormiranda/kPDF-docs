package es.valhallalabs.kpdf.api.component.section

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.page.Page


class DocumentSection(
	val pages: List<Page>,
	override val box: BoxModel
): ComposedComponent {

	override val elements: List<Component>
		get() = pages
	override val componentType: ComponentType
		get() = ComponentType.SECTION

}