package es.valhallalabs.kpdf.api.size

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Percentage
import org.junit.jupiter.api.Test

internal class SizeTest {
    @Test fun `sum pixel dimensions`() {
        val firstSize: Size = MetricSize(mm = 210f)
        val secondSize: Size = MetricSize(mm = 210f)
        val sum = firstSize + secondSize
        assertThat(sum.points).isEqualTo(firstSize.points + secondSize.points)
    }

    @Test fun `check conversion between metric and imperial dimensions`() {
        val metricDimension = MetricSize(mm = 210f)
        val expectedImperialDimension = ImperialSize(inches = 8.27f)

        assertThat(metricDimension.points).describedAs("metric and imperial dimensions are almost the same, given that 210mm is slightly different than 8.27 inches").isCloseTo(expectedImperialDimension.points, Percentage.withPercentage(0.05))
    }

    @Test fun `sum pixel dimensions using non standard dpi's`() {
        val metricDimension = MetricSize(mm = 210f, dpi = 144)
        val expectedImperialDimension = ImperialSize(inches = 8.27f, dpi = 144)

        assertThat(metricDimension.points).describedAs("metric and imperial dimensions are almost the same, given that 210mm is slightly different than 8.27 inches").isCloseTo(expectedImperialDimension.points, Percentage.withPercentage(0.05))
    }
}
