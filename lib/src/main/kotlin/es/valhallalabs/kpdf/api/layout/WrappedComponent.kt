package es.valhallalabs.kpdf.api.layout

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.style.Style

interface WrappedComponent : Component

data class StackedWrappedComponent(override val componentType: ComponentType, override val style: Style, override val box: BoxModel) :
	WrappedComponent

data class RelativePositionedWrappedComponent(override val componentType: ComponentType, override val style: Style, override val box: BoxModel) :
	WrappedComponent