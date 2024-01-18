package es.valhallalabs.kpdf.api.direction

/**
 * Enum representing vertical alignment options.
 * - TOP: aligned at the top
 * - MIDDLE: aligned in the middle
 * - BASELINE: aligned at the baseline
 * - BOTTOM: aligned at the bottom
 */
enum class VerticalAlignment {
	TOP,
	MIDDLE,
	BASELINE,
	BOTTOM
}

/**
 * Enum representing horizontal alignment options.
 * - LEFT: aligned to the left
 * - CENTER: aligned in the center
 * - RIGHT: aligned to the right
 * - JUSTIFIED: aligned by spreading evenly
 */
enum class HorizontalAlignment {
	LEFT,
	CENTER,
	RIGHT,
	JUSTIFIED
}