package es.valhallalabs.kpdf.api.component.document

import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import java.time.Instant

data class DocumentProperties(
	val requestedAt: Instant,
	val processedAt: Instant = Instant.now(),
	val tenantId: String,
	val pageFormat: PageFormat
)