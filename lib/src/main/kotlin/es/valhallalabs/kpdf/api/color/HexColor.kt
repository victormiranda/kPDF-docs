package es.valhallalabs.kpdf.api.color

/**
 * HexColor represents a color as a hexadecimal (hex) color code.
 * It offers utility methods to handle color operations, like fading and darkening.
 *
 * @property hexRepresentation The HexColorCode instance representing the hex color code.
 * @constructor Creates a new HexColor instance with a given hex color representation.
 *
 * @see HexColorCode
 */
data class HexColor(val hexRepresentation: HexColorCode) : Color {

	/**
	 * Overrides the javaColor functionality of the Color interface with hexadecimal color calculations.
	 */
	override val javaColor: java.awt.Color
		get() {
			val rgba = ColorUtils.hexToRgba(hexRepresentation)
			return java.awt.Color(rgba.red, rgba.green, rgba.blue, (rgba.alpha * 255).toInt().coerceIn(0, 255))
		}

	/**
	 * Fades the hex color according to a given percentage.
	 * Returns a new HexColor instance with the faded color.
	 *
	 * @param percent The percentage to fade the color.
	 * @return HexColor instance with the faded color.
	 */
	override fun fade(percent: Int): HexColor {
		val rgba = ColorUtils.hexToRgba(hexRepresentation)
		val fadedRgba = RgbaColor(rgba.red, rgba.green, rgba.blue, rgba.alpha).fade(percent)
		return HexColor(fadedRgba.toHexColorCode())
	}

	/**
	 * Darkens the hex color according to a given percentage.
	 * Returns a new HexColor instance with the darkened color.
	 *
	 * @param percent The percentage to darken the color.
	 * @return HexColor instance with the darkened color.
	 */
	override fun darken(percent: Int): Color {
		val rgba = ColorUtils.hexToRgba(hexRepresentation)
		val factor = (100 - percent) / 100.0
		val newRed = (rgba.red * factor).coerceIn(0.0, 255.0).toInt()
		val newGreen = (rgba.green * factor).coerceIn(0.0, 255.0).toInt()
		val newBlue = (rgba.blue * factor).coerceIn(0.0, 255.0).toInt()
		val newAlpha = rgba.alpha
		val newRgba = RgbaComponents(newRed, newGreen, newBlue, newAlpha)
		return HexColor(ColorUtils.rgbaToHex(newRgba))
	}
}


/**
 * A class representing a HexColorCode, essentially a string containing a valid hexadecimal color code.
 *
 * @property value The string holding the hex color code.
 * @constructor Creates a new instance and verifies that the hex color code is valid.
 */
class HexColorCode(private val value: String) {

	init {
		require(value.matches(Regex("#[0-9a-fA-F]{6}|#[0-9a-fA-F]{8}"))) {
			"Invalid hex color code: $value"
		}
	}

	/**
	 * A companion object to provide some utility methods.
	 */
	companion object {

		/**
		 * Creates a HexColorCode instance from a string.
		 *
		 * @param hexString The string containing the hex color code.
		 * @return A new HexColorCode instance.
		 */
		fun fromString(hexString: String) = HexColorCode(hexString)
	}

	/**
	 * Returns the hex color code as a string.
	 *
	 * @return The hex color code as a string.
	 */
	override fun toString(): String = value
}