package es.valhallalabs.kpdf.api.component.boxmodel

import es.valhallalabs.kpdf.api.size.Size
import org.w3c.dom.css.Rect


/**
 * Define Box Model data class representation for specific box model in a component.
 * It includes width, height, paddings, margins, positioning information and reference to its parent box.
 *
 * Sizes should be stored in such a way that the library will be able to define them using points, pixels, inches and millimeters.
 *
 * @property width the width of the box model
 * @property height the height of the box model
 * @property paddings the paddings of the box model
 * @property margins the margins of the box model
 * @property positioning the positioning properties of the box model
 * @property parentBox reference to parent of this box model
 */
data class BoxModel(
        val width: Size,
        val height: Size,
        val paddings: Paddings,
        val margins: Margins,
        val positioning: BoxPositioning,
        val parentBox: BoxModel? = null
) {

    val effectiveWidth: Size
        get() = (width - paddings.horizontalPadding)

    val effectiveHeight: Size
        get() = (height + paddings.verticalPadding)

    val innerRectangle: Rectangle
        get() = Rectangle(width = effectiveWidth, height = effectiveHeight)

}