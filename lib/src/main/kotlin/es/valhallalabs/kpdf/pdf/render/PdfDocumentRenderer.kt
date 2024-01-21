package es.valhallalabs.kpdf.pdf.render

import es.valhallalabs.kpdf.api.component.document.Document
import es.valhallalabs.kpdf.api.render.ComponentRenderer
import es.valhallalabs.kpdf.api.render.RendererRegistry.render
import es.valhallalabs.kpdf.api.render.context.DocumentRenderContext
import es.valhallalabs.kpdf.api.render.context.RenderContext

/**
 * Renderer configured to render a PDF document.
 *
 * @property ComponentRenderer superClass from which this class extends to override rendering behavior
 */
class PdfDocumentRenderer : ComponentRenderer<Document> {

	/**
	 * Renders the sections of a PDF document by creating and updating a DocumentRenderContext
	 * through the document's sections. After folding through all sections, the final RenderContext
	 * is returned.
	 *
	 * @param component Document which sections are to be rendered
	 * @param parentContext Initial render context
	 * @return DocumentRenderContext that contains rendering information after processing the document's sections
	 */
	override fun render(component: Document, parentContext: RenderContext): RenderContext {
		val documentRenderContext = DocumentRenderContext(parentContext)

		// for each section, it is needed to change the context updating the page number
		return component.sections.fold(documentRenderContext) { context, nestedElement ->
			render(
				nestedElement,
				context
			) as DocumentRenderContext
		}
	}
}