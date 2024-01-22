package es.valhallalabs.kpdf.api.layout

import es.valhallalabs.kpdf.api.component.ComposedComponent

interface Layout : ComposedComponent {

	val layoutType: LayoutType

	override val elements: List<WrappedComponent>

}