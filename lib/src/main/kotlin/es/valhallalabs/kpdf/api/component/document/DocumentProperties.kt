package es.valhallalabs.kpdf.api.component.document

import es.valhallalabs.kpdf.api.component.boxmodel.PageFormat
import es.valhallalabs.kpdf.api.component.style.Style
import java.time.Instant
import java.util.UUID

/**
 * A data class that represents the properties of a Document.
 *
 * @property jobId The ID of the tenant.
 * @property generateIndexPage Flag that indicates if document index page should be generated.
 * @property pageFormat The page format of the document.
 * @property requestedAt The time at which the document was requested.
 * @property processedAt The time at which the document was processed. Defaults to the current time.
 */
data class DocumentProperties(
	val jobId: JobId,
	val generateIndexPage: Boolean = false,
	val pageFormat: PageFormat,
	val baseDocumentStyle: Style,
	val requestedAt: Instant,
	val processedAt: Instant = Instant.now(),
)

typealias JobId = UUID