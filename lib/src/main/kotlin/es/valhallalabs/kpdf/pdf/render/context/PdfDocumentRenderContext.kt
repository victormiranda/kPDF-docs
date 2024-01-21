package es.valhallalabs.kpdf.pdf.render.context

import es.valhallalabs.kpdf.api.render.context.RenderContext
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream

interface BasePdfRenderContext : RenderContext {
	val pdfDocument: PDDocument
}

data class PdfDocumentRenderContext(
	override val pdfDocument: PDDocument
) : BasePdfRenderContext {
	override val parentContext: RenderContext
		get() = this
}

data class PdfDocumentSectionRenderContext(
	val sectionNumber: Int = 0,
	val sectionFirstPageNumber: Int = 0,
	override val pdfDocument: PDDocument,
	override val parentContext: PdfDocumentRenderContext
) : BasePdfRenderContext


data class PdfPageRenderContext(
	val pdfPage: PDPage,
	val contentStream: PDPageContentStream,
	override val pdfDocument: PDDocument,
	override val parentContext: PdfDocumentSectionRenderContext
) : BasePdfRenderContext


data class PdfPageInnerComponentRenderContext(
	val pdfPage: PDPage,
	override val pdfDocument: PDDocument,
	override val parentContext: PdfDocumentRenderContext
) : BasePdfRenderContext


data class PdfNestedComponentRenderContext(
	val pdfPage: PDPage,
	override val pdfDocument: PDDocument,
	override val parentContext: PdfDocumentRenderContext
) : BasePdfRenderContext