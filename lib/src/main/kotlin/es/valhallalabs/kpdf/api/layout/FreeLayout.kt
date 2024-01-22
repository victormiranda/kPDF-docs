package es.valhallalabs.kpdf.api.layout

import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.style.Style

class FreeLayout(
	override val box: BoxModel,
	override val style: Style,
	override val elements: List<RelativePositionedWrappedComponent>
) : Layout, ComposedComponent {

	override val layoutType: LayoutType
		get() = LayoutType.FREE_LAYOUT

	override val componentType: ComponentType
		get() = ComponentType.FREE_LAYOUT

}