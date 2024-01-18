package es.valhallalabs.kpdf.api.component.document

import java.nio.file.Path
import java.nio.file.Paths

/**
 * The `DocumentResource` interface defines the methods that represents a document resource.
 *
 * @property resourceName The name of the resource.
 * @property resourceLocation The location of the resource.
 * @property resource The Path representing the resource.
 */
interface DocumentResource {

	val resourceName: String
	val resourceLocation: String
	val resource: Path
}

/**
 * `ClasspathDocumentResource` class that implements the `DocumentResource` interface.
 *
 * @property resourceName The name of the resource.
 * @property resourceLocation The location of the resource on the classpath.
 *
 * @constructor Create new instance of `ClasspathDocumentResource`
 */
class ClasspathDocumentResource(
	override val resourceName: String,
	override val resourceLocation: String
) : DocumentResource {

	/**
	 * Getting the resource as a Path.
	 * @return the `Path` representing the resource.
	 */
	override val resource: Path
		get() = Paths.get(
			this::class.java.classLoader.getResource(resourceLocation)?.toURI()
				?: throw NoSuchElementException("resource $resourceLocation not found")
		)
}