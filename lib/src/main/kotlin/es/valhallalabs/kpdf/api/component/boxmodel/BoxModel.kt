package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.PointSize
import es.valhallalabs.kpdf.api.size.Size


/**
 * Define Box Model interface for specific box model in a component.
 * It includes width, height, paddings, margins, positioning information and reference to its parent box.
 *
 * Sizes should be stored in such a way that the library will be able to define them using points, pixels, inches and millimeters.
 *
 * @property width the width of the box model
 * @property height the height of the box model
 * @property paddings the paddings of the box model
 * @property margins the margins of the box model
 * @property positioning the positioning properties of the box model
 */
interface BoxModel {
	val width: Size
	val height: Size
	val paddings: Paddings
	val margins: Margins
	val positioning: BoxPositioning


	val effectiveWidth: Size
		get() = (width - paddings.horizontalPadding - margins.horizontalMargin)

	val effectiveHeight: Size
		get() =
			(height - paddings.verticalPadding - margins.verticalMargin)


	val rectangle: Rectangle
		get() = Rectangle(width = width, height = height)
	val innerRectangle: Rectangle
		get() = Rectangle(width = effectiveWidth, height = effectiveHeight)

	val innerBox: BoxModel
}

data class Box(
	override val width: Size,
	override val height: Size,
	override val paddings: Paddings = Paddings.NO_PADDINGS,
	override val margins: Margins = Margins.NO_MARGINS,
	override val positioning: BoxPositioning = BoxPositioning(),
) : BoxModel {

	companion object {
		fun pointBasedBox(width: Int, height: Int, growBehaviour: GrowBehaviour = GrowBehaviour()): Box = Box(
			width = PointSize(width.toFloat()),
			height = PointSize(height.toFloat()),
			positioning = BoxPositioning(growBehaviour = growBehaviour)
		)
	}
	override val innerBox: BoxModel
		get() = Box(
			width = this.effectiveWidth,
			height = this.effectiveHeight,
			paddings = Paddings.NO_PADDINGS,
			margins = Margins.NO_MARGINS,
			positioning = this.positioning
		)

}