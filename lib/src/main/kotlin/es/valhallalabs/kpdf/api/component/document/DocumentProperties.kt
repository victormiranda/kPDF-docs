package es.valhallalabs.kpdf.api.component.document

import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import java.time.Instant
import java.util.UUID

data class DocumentProperties(
	val requestedAt: Instant,
	val processedAt: Instant = Instant.now(),
	val jobId: UUID,
	val pageFormat: PageFormat
)

typealias JobId = UUID