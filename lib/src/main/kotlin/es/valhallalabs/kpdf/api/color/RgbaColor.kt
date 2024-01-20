package es.valhallalabs.kpdf.api.color

data class RgbaColor(
	val red: Int,
	val green: Int,
	val blue: Int,
	val alpha: Float = 1f,
) : Color {

	override val javaColor: java.awt.Color
		get() {
			val alphaValue = (alpha * 255).toInt().coerceIn(0, 255)
			return java.awt.Color(red, green, blue, alphaValue)
		}

	override fun fade(percent: Int): RgbaColor {
		val newAlpha = (alpha + alpha * (percent / 100.0f)).coerceIn(0f, 1f)
		return copy(alpha = newAlpha)
	}

	override fun darken(percent: Int): RgbaColor {
		val factor = (100 - percent) / 100.0
		val newRed = (red * factor).coerceIn(0.0, 255.0).toInt()
		val newGreen = (green * factor).coerceIn(0.0, 255.0).toInt()
		val newBlue = (blue * factor).coerceIn(0.0, 255.0).toInt()
		return copy(red = newRed, green = newGreen, blue = newBlue)
	}


	fun toHexColorCode(): HexColorCode {
		val rgba = RgbaComponents(red, green, blue, alpha)
		return ColorUtils.rgbaToHex(rgba)
	}
}

data class RgbaComponents<R, G, B, A>(val red: R, val green: G, val blue: B, val alpha: A)
