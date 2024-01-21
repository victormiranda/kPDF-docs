package es.valhallalabs.kpdf.pdf.component

import es.valhallalabs.kpdf.api.component.boxmodel.Rectangle
import org.apache.pdfbox.pdmodel.common.PDRectangle

private fun Rectangle.pdfRectangle(): PDRectangle {
	return PDRectangle(width.points, height.points)
}
