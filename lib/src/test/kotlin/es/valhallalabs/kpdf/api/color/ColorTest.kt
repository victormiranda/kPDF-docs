package es.valhallalabs.kpdf.api.color


import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.satisfiesRequirements
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class ColorTestSuite {

	@Nested
	internal inner class RgbaColorTest {
		@Test fun `RGBA color should fade correctly`() {
			val color = RgbaColor(100, 100, 100, 0.5f)
			val fadedColor = color.fade(50)

			assertThat(fadedColor.alpha)
				.describedAs("Alpha value should be increased by 20%")
				.isEqualTo(0.75f)
		}

		@Test fun `Completely faded RGBA color should stay at zero alpha`() {
			val color = RgbaColor(100, 100, 100, 0f)
			val fadedColor = color.fade(20)

			assertThat(fadedColor.alpha)
				.describedAs("Alpha value should be increased by 20%")
				.isEqualTo(0.0f)
		}

		@Test fun `RGBA color should darken correctly`() {
			val color = RgbaColor(150, 150, 150, 1f)
			val darkenedColor = color.darken(20)

			assertThat(darkenedColor)
				.describedAs("Check each color component after darkening").satisfiesRequirements {
					assertThat(it.red).isEqualTo(120)
					assertThat(it.green).isEqualTo(120)
					assertThat(it.blue).isEqualTo(120)
					assertThat(it.alpha).isEqualTo(1f)
				}
		}

		@Test fun `RGBA color should convert to HexColorCode correctly`() {
			val color = RgbaColor(255, 0, 0, 1f)
			val hexColorCode = color.toHexColorCode()

			assertThat(hexColorCode.toString())
				.describedAs("Hex string should match the RGBA color")
				.isEqualTo("#FF0000FF")
		}
	}

	@Nested
	internal inner class HexColorTest {
		@Test fun `Hex color should fade correctly`() {
			val hexColor = HexColor(HexColorCode.fromString("#FF000080"))
			val fadedHexColor = hexColor.fade(25)

			assertThat(fadedHexColor.hexRepresentation.toString())
				.describedAs("Hex color should fade correctly")
				.isEqualTo("#FF0000A0")
		}

		@Test fun `Hex color should darken correctly`() {
			val hexColor = HexColor(HexColorCode.fromString("#969696FF"))
			val darkenedHexColor: HexColor = hexColor.darken(20) as HexColor

			assertThat(darkenedHexColor.hexRepresentation.toString())
				.describedAs("Hex color should darken correctly")
				.isEqualTo("#787878FF")
		}

		@Test fun `Fading and darkening operations should be symmetrical between RGBA and HexColor`() {
			val rgbaColor = RgbaColor(100, 150, 200, 1f)
			val hexColor = HexColor(HexColorCode.fromString("#6496C8FF"))

			val fadedRgba = rgbaColor.fade(10)
			val fadedHex = hexColor.fade(10)
			assertThat(fadedRgba.toHexColorCode().toString())
				.describedAs("Faded RGBA color should match faded Hex color")
				.isEqualTo(fadedHex.hexRepresentation.toString())

			val darkenedRgba = rgbaColor.darken(10)
			val darkenedHex = hexColor.darken(10) as HexColor
			assertThat(darkenedRgba.toHexColorCode().toString())
				.describedAs("Darkened RGBA color should match darkened Hex color")
				.isEqualTo(darkenedHex.hexRepresentation.toString())
		}
	}

	@Nested
	internal inner class HexColorCodeTest {
		@Test fun `HexColorCode should be created correctly without alpha channel`() {
			val hexString = "#FF5733"
			val hexColorCode = HexColorCode.fromString(hexString)

			assertThat(hexColorCode.toString())
				.describedAs("HexColorCode should match the hex string without alpha channel")
				.isEqualTo(hexString)
		}

		@Test fun `HexColorCode should be created correctly with alpha channel`() {
			val hexString = "#FF5733AA"
			val hexColorCode = HexColorCode.fromString(hexString)

			assertThat(hexColorCode.toString())
				.describedAs("HexColorCode should match the hex string with alpha channel")
				.isEqualTo(hexString)
		}

		@Test
		fun `Invalid hex string should throw IllegalArgumentException`() {
			val invalidHexString = "#GGG999"

			assertThatExceptionOfType(IllegalArgumentException::class.java)
				.isThrownBy { HexColorCode.fromString(invalidHexString) }
				.withMessageContaining("Invalid hex color code")
				.describedAs("Creating HexColorCode with an invalid hex string should throw IllegalArgumentException")
		}
	}

	@Nested
	internal inner class ColorUtilsTest {
		@Test fun `Convert HexColorCode to RGBA components correctly`() {
			val hex = HexColorCode.fromString("#FF0000")
			val rgba = ColorUtils.hexToRgba(hex)

			assertThat(rgba)
				.describedAs("Check each RGBA component from HexColorCode")
				.satisfiesRequirements {
					assertThat(it.red).isEqualTo(255)
					assertThat(it.green).isEqualTo(0)
					assertThat(it.blue).isEqualTo(0)
					assertThat(it.alpha).isEqualTo(1f)
				}
		}

		@Test
		fun `Convert RGBA components to HexColorCode correctly`() {
			val rgba = RgbaComponents(255, 0, 0, 1f)
			val hex = ColorUtils.rgbaToHex(rgba)

			assertThat(hex.toString())
				.describedAs("Hex string should match the RGBA components")
				.isEqualTo("#FF0000FF")
		}
	}
}
