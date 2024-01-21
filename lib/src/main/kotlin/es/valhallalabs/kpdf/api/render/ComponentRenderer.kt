package es.valhallalabs.kpdf.api.render

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.render.context.RenderContext

/**
 * This interface defines a ComponentRenderer that renders a specific type of Component
 * within a provided RenderContext.
 *
 * @param C The type of the Component to render.
 */
interface ComponentRenderer<C : Component> {
	/**
	 * Renders the given component within the provided parentContext.
	 * Produces a new RenderContext as a result of rendering the component.
	 *
	 * @param component The Component instance to be rendered.
	 * @param parentContext The context in which the component is rendered.
	 * @return RenderContext The new context resulting from the render operation.
	 */
	fun render(
		component: C,
		parentContext: RenderContext,
	): RenderContext
}