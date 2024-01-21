package es.valhallalabs.kpdf.api.component.section

import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.ComposedComponent
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel
import es.valhallalabs.kpdf.api.component.page.Page
import es.valhallalabs.kpdf.api.component.style.BaseStyle
import es.valhallalabs.kpdf.api.component.style.Style

/**
 * Document section represents a section in a document structure.
 * It's a composed component consisting of multiple pages.
 *
 * @property isTitleSection Flag indicating if the section is the document title section.
 * @property sectionName The name of the section.
 * @property pages The list of pages that this section consists of.
 * @property box The box model of this component.
 */
class DocumentSection(
	val isTitleSection: Boolean = false,
	val sectionName: String,
	val pages: List<Page>,
	override val style: Style = BaseStyle(),
	override val box: BoxModel
) : ComposedComponent {

	override val elements: List<Page>
		get() = pages
	override val componentType: ComponentType
		get() = ComponentType.SECTION

}