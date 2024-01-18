package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.ImperialSize
import es.valhallalabs.kpdf.api.size.MetricSize
import es.valhallalabs.kpdf.api.size.Size

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