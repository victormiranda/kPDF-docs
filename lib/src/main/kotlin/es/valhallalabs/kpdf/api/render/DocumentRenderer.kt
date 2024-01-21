package es.valhallalabs.kpdf.api.render

import es.valhallalabs.kpdf.api.component.document.Document
import es.valhallalabs.kpdf.api.render.context.DocumentRenderContext
import es.valhallalabs.kpdf.api.render.context.RenderContext

/**
 * Interface for rendering a Document component.
 *
 * Implementations of this interface should detail how a Document component is rendered
 * into a DocumentRenderContext.
 */
interface DocumentRenderer : ComponentRenderer<Document> {

	/**
	 * Renders the specified Document component, within the provided parent render context.
	 *
	 * This function should return a new DocumentRenderContext, which represents the result
	 * of the render operation.
	 *
	 * @param component the Document component to render.
	 * @param parentContext the parent RenderContext in which the Document component is being rendered.
	 *
	 * @return DocumentRenderContext the result of the render operation.
	 */
	override fun render(component: Document, parentContext: RenderContext): DocumentRenderContext
}