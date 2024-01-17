package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.ImperialSize
import es.valhallalabs.kpdf.api.size.MetricSize


object PageFormats  {
    val US_LETTER = BoxModel(
            width = ImperialSize(8.5f),
            height = ImperialSize(11.0f),
            positioning = BoxPositioning.FULL_EXPANSION,
            margins =  Margins.US_LETTER,
            paddings = Paddings.NO_PADDINGS
    )

    val PAGE_BASE_A4 =
            BoxModel(
                    width = MetricSize(mm = 210f),
                    height = MetricSize(mm = 297f),
                    margins = Margins.A4,
                    positioning = BoxPositioning.FULL_EXPANSION,
                    paddings = Paddings.NO_PADDINGS
            )
}