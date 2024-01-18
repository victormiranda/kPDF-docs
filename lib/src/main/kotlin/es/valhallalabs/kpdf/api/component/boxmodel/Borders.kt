package es.valhallalabs.kpdf.api.component.boxmodel

data class Borders(
        val top: Border,
        val right: Border,
        val bottom: Border,
        val left: Border,
)

data class Border(
        val size: Float = 0f,
        val borderType: BorderType = BorderType.NONE
)