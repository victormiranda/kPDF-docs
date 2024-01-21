package es.valhallalabs.kpdf.api.render.context

/**
 * Interface for render context, an essential part of kPDF API.
 * It allows for a hierarchical structure, where each context is aware of its parent context.
 */
interface RenderContext {
	val parentContext: RenderContext
}

