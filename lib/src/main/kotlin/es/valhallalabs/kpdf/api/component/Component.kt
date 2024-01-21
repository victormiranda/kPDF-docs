package es.valhallalabs.kpdf.api.component

import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.style.Style

/**
 * This is the root interface, the parent of every document component
 */
interface Component {
	val componentType: ComponentType
	val style: Style
	val box: BoxModel
}

/**
 * ComposedComponent is just a document with a collection of nested components
 */
interface ComposedComponent : Component {
	val elements: List<Component>
}