package es.valhallalabs.kpdf.api.component.boxmodel

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
 * @property parentBox reference to parent of this box model
 */
interface BoxModel {
	val width: Size
	val height: Size
	val paddings: Paddings
	val margins: Margins
	val positioning: BoxPositioning
	val parentBox: BoxModel?


	val effectiveWidth: Size
		get() = (width - paddings.horizontalPadding - margins.horizontalMargin)

	val effectiveHeight: Size
		get() =
			(height - paddings.verticalPadding - margins.verticalMargin)

	val innerRectangle: Rectangle
		get() = Rectangle(width = effectiveWidth, height = effectiveHeight)

	val innerBox: BoxModel
}

open class Box(
	override val width: Size,
	override val height: Size,
	override val paddings: Paddings,
	override val margins: Margins,
	override val positioning: BoxPositioning,
	override val parentBox: BoxModel? = null
) : BoxModel {

	override val innerBox: BoxModel
		get() = Box(
			width = this.effectiveWidth,
			height = this.effectiveHeight,
			paddings = Paddings.NO_PADDINGS,
			margins = Margins.NO_MARGINS,
			positioning = this.positioning,
			parentBox = this
		)

}