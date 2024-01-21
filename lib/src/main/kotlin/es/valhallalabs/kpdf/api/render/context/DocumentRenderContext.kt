package es.valhallalabs.kpdf.api.render.context

/**
 * This data class is used for Document Rendering Context.
 *
 * @property parentContext: The parent context for this render context.
 */
data class DocumentRenderContext(
	override val parentContext: RenderContext
) : RenderContext