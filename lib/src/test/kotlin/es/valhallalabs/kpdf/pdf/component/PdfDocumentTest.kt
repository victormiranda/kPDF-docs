package es.valhallalabs.kpdf.pdf.component

import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import es.valhallalabs.kpdf.api.component.document.ClasspathDocumentResource
import es.valhallalabs.kpdf.api.component.document.DocumentProperties
import es.valhallalabs.kpdf.api.component.page.FullContainerPage
import es.valhallalabs.kpdf.api.component.section.DocumentSection
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.UUID

internal class PdfDocumentTest {

	private val document: PdfDocument = PdfDocument(
		properties = DocumentProperties(
			requestedAt = Instant.now(), jobId = UUID.randomUUID(), pageFormat = PageFormat.PAGE_BASE_A4
		),
		resources = listOf(
			ClasspathDocumentResource(resourceName = "Acme font", resourceLocation = "fonts/acme.ttf")
		), sections = listOf(
			DocumentSection(
				box = PageFormat.PAGE_BASE_A4,
				sectionName = "main section",
				pages = listOf(
					FullContainerPage(
						box = PageFormat.PAGE_BASE_A4.innerBox as PageFormat
					)
				)
			)
		)
	)

	@Test fun `check basic A4 document object page size `() {
		val a4BoxModel: BoxModel = document.box

		assertThat(a4BoxModel.width.points).isEqualTo(595.2756f)
		assertThat(a4BoxModel.height.points).isEqualTo(841.88983f)
	}

	@Test fun `check basic A4 document object inner container size `() {
		val firstPage: FullContainerPage = document.sections[0].pages[0] as FullContainerPage

		assertThat(firstPage.box.width.points).isEqualTo(523.2756f)
		assertThat(firstPage.box.height.points).isEqualTo(769.88983f)
	}

	@Test fun `check access to local classpath document resources`() {
		val resource = document.resources[0]

		assertThat(resource.resource).exists()
	}


}