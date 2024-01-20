package es.valhallalabs.kpdf.api.color


data class HexColor(val hexRepresentation: HexColorCode) : Color {

	override val javaColor: java.awt.Color
		get() {
			val rgba = ColorUtils.hexToRgba(hexRepresentation)
			return java.awt.Color(rgba.red, rgba.green, rgba.blue, (rgba.alpha * 255).toInt().coerceIn(0, 255))
		}

	override fun fade(percent: Int): HexColor {
		val rgba = ColorUtils.hexToRgba(hexRepresentation)
		val fadedRgba = RgbaColor(rgba.red, rgba.green, rgba.blue, rgba.alpha).fade(percent)
		return HexColor(fadedRgba.toHexColorCode())
	}

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

class HexColorCode(private val value: String) {

	init {
		require(value.matches(Regex("#[0-9a-fA-F]{6}|#[0-9a-fA-F]{8}"))) {
			"Invalid hex color code: $value"
		}
	}

	companion object {
		fun fromString(hexString: String) = HexColorCode(hexString)
	}

	override fun toString(): String = value
}
