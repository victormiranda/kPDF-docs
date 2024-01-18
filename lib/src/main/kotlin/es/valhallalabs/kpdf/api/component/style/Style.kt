package es.valhallalabs.kpdf.api.component.style

interface Style {
    val name: String
    val parentStyle: Style?
}