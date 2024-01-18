package es.valhallalabs.kpdf.api.component.document

import java.nio.file.Path
import java.nio.file.Paths

interface DocumentResource {

	val resourceName: String
	val resourceLocation: String
	val resource: Path

}

class LocalDocumentResource(
	override val resourceName: String,
	override val resourceLocation: String
) : DocumentResource {

	override val resource: Path
		get() = Paths.get(
			this::class.java.classLoader.getResource(resourceLocation)?.toURI()
				?: throw NoSuchElementException("resource $resourceLocation not found")
		)
}