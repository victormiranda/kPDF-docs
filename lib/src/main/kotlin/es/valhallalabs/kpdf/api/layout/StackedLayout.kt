package es.valhallalabs.kpdf.api.layout

import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.style.Style

interface StackedLayout : Layout {
	val stackStyle: Style
	override val style
		get() = stackStyle
	override val elements: List<StackedWrappedComponent>
	override val componentType: ComponentType
		get() = ComponentType.STACKED_LAYOUT

}

data class RowLayout(
	override val box: BoxModel,
	override val stackStyle: Style,
	override val elements: List<StackedWrappedComponent>
) : StackedLayout {
	override val layoutType: LayoutType
		get() = LayoutType.ROW
	override val parentLayout: Layout
		get() = TODO("Not yet implemented")
	override val rootLayout: Layout
		get() = TODO("Not yet implemented")
}

data class ColumnLayout(
	override val box: BoxModel,
	override val stackStyle: Style,
	override val elements: List<StackedWrappedComponent>, override val parentLayout: Layout?, override val rootLayout: Layout
) : StackedLayout {
	override val layoutType: LayoutType
		get() = LayoutType.ROW
}
