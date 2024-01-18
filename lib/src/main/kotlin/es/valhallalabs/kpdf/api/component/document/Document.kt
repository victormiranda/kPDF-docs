package es.valhallalabs.kpdf.api.component.document

import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent

/**
 * Interface for Document modeling within the system.
 */
interface Document : ComposedComponent {

	/**
	 * The resources associated with this document.
	 */
	val resources: List<DocumentResource>

	/**
	 * The properties of this document.
	 */
	val properties: DocumentProperties

	/**
	 * Returns the ComponentType constant that represents a document component.
	 */
	override val componentType: ComponentType
		get() = ComponentType.DOCUMENT
}