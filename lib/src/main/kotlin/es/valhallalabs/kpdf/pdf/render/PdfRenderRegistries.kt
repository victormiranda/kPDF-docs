package es.valhallalabs.kpdf.pdf.render

import es.valhallalabs.kpdf.api.component.document.Document
import es.valhallalabs.kpdf.api.component.page.SinglePageComponent
import es.valhallalabs.kpdf.api.component.section.DocumentSection
import es.valhallalabs.kpdf.api.render.RendererRegistry

/**
 * Object responsible for registering all PDF renderers
 */
object PdfRenderRegistries {

	// Constructing and registering renderers
	init {
		RendererRegistry.registerRenderer(Document::class.java, PdfDocumentRenderer())
		RendererRegistry.registerRenderer(DocumentSection::class.java, PdfDocumentSectionRenderer())
		RendererRegistry.registerRenderer(SinglePageComponent::class.java, PdfSinglePageRenderer())
	}
}