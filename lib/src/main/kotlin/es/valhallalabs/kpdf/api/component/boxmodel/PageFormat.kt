package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.ImperialSize
import es.valhallalabs.kpdf.api.size.MetricSize
import es.valhallalabs.kpdf.api.size.Size

/**
 * Data class representing the format of a page.
 *
 * @property width The width of the page.
 * @property height The height of the page.
 * @property paddings The padding of the page.
 * @property margins The margins of the page.
 * @property parentBox The parent box model of this page format.
 * @property positioning The positioning of the box on the page.
 *
 * @constructor Create empty Page format
 */
data class PageFormat(
	override val width: Size,
	override val height: Size,
	override val paddings: Paddings,
	override val margins: Margins,
	override val parentBox: BoxModel? = null,
	override val positioning: BoxPositioning
) : BoxModel {
	companion object {
		val US_LETTER = PageFormat(
			width = ImperialSize(8.5f),
			height = ImperialSize(11.0f),
			positioning = BoxPositioning.FULL_EXPANSION,
			margins = Margins.US_LETTER,
			paddings = Paddings.NO_PADDINGS
		)

		val PAGE_BASE_A4 = PageFormat(
			width = MetricSize(mm = 210f),
			height = MetricSize(mm = 297f),
			margins = Margins.A4,
			positioning = BoxPositioning.FULL_EXPANSION,
			paddings = Paddings.NO_PADDINGS
		)
	}

	/**
	 * Returns an inner box model for the page which represents
	 * the effective width and height taking into account margins and paddings.
	 */
	override val innerBox: BoxModel
		get() = PageFormat(
			width = this.effectiveWidth,
			height = this.effectiveHeight,
			paddings = Paddings.NO_PADDINGS,
			margins = Margins.NO_MARGINS,
			positioning = this.positioning,
			parentBox = this
		)
}