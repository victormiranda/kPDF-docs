package es.valhallalabs.kpdf.api.render

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.render.context.RenderContext

/**
 * An object responsible for managing component renderers.
 *
 * It holds a registry of renderers for different types of components.
 * It also provides methods to register a renderer for a particular component type
 * and to render a given component using its respective renderer.
 */
object RendererRegistry {

	/**
	 *  A mutable map to hold the renderers for different types of components.
	 */
	private val renderers = mutableMapOf<Class<out Component>, ComponentRenderer<out Component>>()

	/**
	 * Registers a renderer for a particular component type.
	 *
	 * @param componentClass The class of components that the provided renderer can render.
	 * @param renderer       The renderer to register.
	 * @param <T>            A type that extends [Component].
	 */
	fun <T : Component> registerRenderer(componentClass: Class<out T>, renderer: ComponentRenderer<T>) {
		renderers[componentClass] = renderer
	}

	/**
	 * Renders a given component using its respective renderer.
	 *
	 * This method looks up the renderer capable of rendering the component,
	 * invokes it to render the component, and returns the rendering context.
	 *
	 * @param component      The component to render.
	 * @param parentContext  The parent context of the component to render.
	 *
	 * @return The rendering context after rendering the component.
	 */
	fun render(component: Component, parentContext: RenderContext): RenderContext {
		val renderer = renderers[component::class.java]
			?: throw IllegalStateException("Renderer not registered for ${component::class.java.simpleName}")
		return (renderer as ComponentRenderer<Component>).render(component, parentContext)
	}
}