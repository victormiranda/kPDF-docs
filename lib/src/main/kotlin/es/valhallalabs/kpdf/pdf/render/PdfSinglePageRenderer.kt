package es.valhallalabs.kpdf.pdf.render

import es.valhallalabs.kpdf.api.component.page.SinglePageComponent
import es.valhallalabs.kpdf.api.render.ComponentRenderer
import es.valhallalabs.kpdf.api.render.RendererRegistry
import es.valhallalabs.kpdf.api.render.context.RenderContext
import es.valhallalabs.kpdf.pdf.render.context.PdfDocumentSectionRenderContext
import es.valhallalabs.kpdf.pdf.render.context.PdfNestedComponentRenderContext
import es.valhallalabs.kpdf.pdf.render.context.PdfPageRenderContext
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.common.PDRectangle

class PdfSinglePageRenderer : ComponentRenderer<SinglePageComponent> {

	override fun render(component: SinglePageComponent, parentContext: RenderContext): PdfPageRenderContext {
		val documentSectionRenderContext = parentContext as PdfDocumentSectionRenderContext
		val (pageBox, childComponent) = component
		val pdfPage = PDPage(PDRectangle(pageBox.effectiveWidth.points, pageBox.effectiveHeight.points))
		val pageContentStream = PDPageContentStream(parentContext.pdfDocument, pdfPage)
		val pageRenderContext = PdfPageRenderContext(
			pdfDocument = documentSectionRenderContext.pdfDocument,
			pdfPage = pdfPage,
			contentStream = pageContentStream,
			parentContext = documentSectionRenderContext
		)
		RendererRegistry.render(childComponent, pageRenderContext) as PdfNestedComponentRenderContext

		pageContentStream.close()

		return pageRenderContext
	}

}