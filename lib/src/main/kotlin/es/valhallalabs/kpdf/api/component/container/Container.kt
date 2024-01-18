package es.valhallalabs.kpdf.api.component.container

import es.valhallalabs.kpdf.api.component.Component
import es.valhallalabs.kpdf.api.component.ComponentType
import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel

interface Container : Component

class PageContainer(
	override val box: BoxModel
) : Container {

	override val componentType: ComponentType
		get() = ComponentType.CONTAINER

}