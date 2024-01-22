package es.valhallalabs.kpdf.api.component.container

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.style.BaseStyle
import es.valhallalabs.kpdf.api.component.style.Style

/**
 * Container interface for components
 */
interface Container : Component

interface ComposedContainer : ComposedComponent


data class FrameContainer(
	override val componentType: ComponentType = ComponentType.CONTAINER,
	override val style: Style = BaseStyle(),
	override val box: BoxModel
) : Container