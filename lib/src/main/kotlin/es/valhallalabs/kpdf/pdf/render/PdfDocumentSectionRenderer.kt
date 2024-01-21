package es.valhallalabs.kpdf.pdf.render

import es.valhallalabs.kpdf.api.component.section.DocumentSection
import es.valhallalabs.kpdf.api.render.ComponentRenderer
import es.valhallalabs.kpdf.api.render.RendererRegistry
import es.valhallalabs.kpdf.api.render.context.RenderContext
import es.valhallalabs.kpdf.pdf.render.context.PdfDocumentRenderContext
import es.valhallalabs.kpdf.pdf.render.context.PdfDocumentSectionRenderContext
import org.apache.pdfbox.pdmodel.PDDocument

/**
 * This class handles the rendering of the section of a document in PDF format.
 */
class PdfDocumentSectionRenderer : ComponentRenderer<DocumentSection> {

	/**
	 * This function takes a document section and a parent rendering context as arguments
	 * and creates a rendering context for the subsection of the document. Elements of the component
	 * are then rendered into this subsection.
	 *
	 * @param component The document section that needs to be rendered.
	 * @param parentContext The parent rendering context of document section.
	 * @return PdfDocumentSectionRenderContext The rendering context of the document section.
	 */
	override fun render(component: DocumentSection, parentContext: RenderContext): PdfDocumentSectionRenderContext {
		val documentRenderContext = PdfDocumentSectionRenderContext(
			pdfDocument = PDDocument(), parentContext = parentContext as PdfDocumentRenderContext
		)
		return component.elements.fold(documentRenderContext) { context, page ->
			(RendererRegistry.render(page, context) as PdfDocumentSectionRenderContext).copy(
				sectionNumber = context.sectionNumber + 1
			)
		}
	}

}