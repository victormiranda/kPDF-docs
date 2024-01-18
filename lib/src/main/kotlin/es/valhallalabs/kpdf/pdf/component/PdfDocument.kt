package es.valhallalabs.kpdf.pdf.component

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.document.Document
import es.valhallalabs.kpdf.api.component.document.DocumentProperties
import es.valhallalabs.kpdf.api.component.document.DocumentResource
import es.valhallalabs.kpdf.api.component.section.DocumentSection

data class PdfDocument(
	val sections: List<DocumentSection>,
	override val resources: List<DocumentResource>,
	override val properties: DocumentProperties
) : Document {

	override val box: BoxModel
		get() = properties.pageFormat

	override val elements: List<Component>
		get() = sections
}
