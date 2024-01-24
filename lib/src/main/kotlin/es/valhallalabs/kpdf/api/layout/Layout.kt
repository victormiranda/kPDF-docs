package es.valhallalabs.kpdf.api.layout

import es.valhallalabs.kpdf.api.component.ComposedComponent

interface Layout : ComposedComponent {

	val layoutType: LayoutType

	val parentLayout: Layout?

	val rootLayout: Layout

	override val elements: List<WrappedComponent>

}