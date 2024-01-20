@file:Suppress("unused")
package es.valhallalabs.kpdf.api.color

/**
 * Color interface provides a definition for color-related operations.
 */
sealed interface Color {

	/**
	 * Gets the corresponding Java Color.
	 *
	 * @return Returns the java.awt.Color representation.
	 */
	val javaColor: java.awt.Color

	/**
	 * Fades the color by a specified percentage.
	 *
	 * @param percent The percentage to fade the color by.
	 * @return Returns a new Color that represents the faded color.
	 */
	fun fade(percent: Int): Color

	/**
	 * Darkens the color by a specified percentage.
	 *
	 * @param percent The percentage to darken the color by.
	 * @return Returns a new Color that represents the darkened color.
	 */
	fun darken(percent: Int): Color

	companion object {
		@SuppressWarnings("unused")
		val TRANSPARENT = RgbaColor(0, 0, 0, 0f)
		val WHITE = RgbaColor(255, 255, 255)
		val BLACK = RgbaColor(0, 0, 0)
		val RED = RgbaColor(255, 0, 0)
		val GREEN = RgbaColor(0, 255, 0)
		val BLUE = RgbaColor(0, 0, 255)
		val YELLOW = RgbaColor(255, 255, 0)
		val CYAN = RgbaColor(0, 255, 255)
		val MAGENTA = RgbaColor(255, 0, 255)
		val SILVER = RgbaColor(192, 192, 192)
		val GRAY = RgbaColor(128, 128, 128)
		val MAROON = RgbaColor(128, 0, 0)
		val OLIVE = RgbaColor(128, 128, 0)
		val PURPLE = RgbaColor(128, 0, 128)
		val TEAL = RgbaColor(0, 128, 128)
		val NAVY = RgbaColor(0, 0, 128)
		val ORANGE = RgbaColor(255, 165, 0)
	}

}

/**
 * ColorUtils is a utility class that provides methods for converting colors from one format to another.
 */
object ColorUtils {

	/**
	 * Convert hexadecimal color code to RGBA color.
	 *
	 * @param hexColorCode The hexadecimal color code as input.
	 * @return Returns a RgbaComponents object which contains individual RGBA components for the color.
	 */
	fun hexToRgba(hexColorCode: HexColorCode): RgbaComponents<Int, Int, Int, Float> {
		val hex = hexColorCode.toString()
		val r = hex.substring(1, 3).toInt(16)
		val g = hex.substring(3, 5).toInt(16)
		val b = hex.substring(5, 7).toInt(16)
		val a = if (hex.length == 9) hex.substring(7, 9).toInt(16) / 255.0f else 1f
		return RgbaComponents(r, g, b, a)
	}

	/**
	 * Convert RGBA color to hexadecimal color code.
	 *
	 * @param rgba The RgbaComponents color as input.
	 * @return Returns a HexColorCode which represents the RGBA color as hexadecimal color code.
	 */
	fun rgbaToHex(rgba: RgbaComponents<Int, Int, Int, Float>): HexColorCode {
		val (red, green, blue, alpha) = rgba
		val alphaHex = (alpha * 255).toInt()
		val hexString = "#%02X%02X%02X%02X".format(red, green, blue, alphaHex)
		return HexColorCode.fromString(hexString)
	}

}