package es.valhallalabs.kpdf.api.component

import es.valhallalabs.kpdf.api.component.boxmodel.BoxModel

interface Component {
    val componentType: ComponentType
    val box: BoxModel
}

interface ComposedComponent : Component {
    val elements: List< Component>
}