package es.valhallalabs.kpdf.api.component.document

import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent

interface Document : ComposedComponent {
	val resources: List<DocumentResource>
	val properties: DocumentProperties
	override val componentType: ComponentType
		get() = ComponentType.DOCUMENT
}