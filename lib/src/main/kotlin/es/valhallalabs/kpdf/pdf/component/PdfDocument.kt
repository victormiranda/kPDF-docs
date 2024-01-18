package es.valhallalabs.kpdf.pdf.component

import es.valhallalabs.kpdf.api.component.document.Document
import es.valhallalabs.kpdf.api.component.document.DocumentProperties
import es.valhallalabs.kpdf.api.component.document.DocumentResource
import es.valhallalabs.kpdf.api.component.section.DocumentSection

/**
 * PDF implementation of the Document interface.
 *
 * @property sections List of document sections.
 * @property resources List of document resources.
 * @property properties Properties of the document.
 */
data class PdfDocument(
	val sections: List<DocumentSection>,
	override val resources: List<DocumentResource>,
	override val properties: DocumentProperties
) : Document {

	override val box = properties.pageFormat

	override val elements = sections
}