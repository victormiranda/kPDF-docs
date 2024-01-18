package es.valhallalabs.kpdf.api.component

/**
 * Enum for representing the various component types in a PDF document.
 *
 * @property DOCUMENT Represents the entire document
 * @property SECTION Denotes a section in the document
 * @property PAGE A single page in the document
 * @property CONTAINER A container element which may encompass other elements
 * @property LAYOUT Specifies a layout format in the document
 * @property TEXT Text element in the document
 * @property PARAGRAPH A paragraph in the document
 * @property IMAGE An image resource in the document
 */
enum class ComponentType {
	DOCUMENT,
	SECTION,
	PAGE,
	CONTAINER,
	LAYOUT,
	TEXT,
	PARAGRAPH,
	IMAGE
}