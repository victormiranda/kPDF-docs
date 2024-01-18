package es.valhallalabs.kpdf.api.component.boxmodel


import es.valhallalabs.kpdf.api.size.PointSize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BoxModelTest {
    @Test fun testA4ComponentBoxSize() {
        val a4BoxModel: BoxModel = PageFormat.PAGE_BASE_A4

        assertThat(a4BoxModel.width.points).isEqualTo(595.2756f)
        assertThat(a4BoxModel.height.points).isEqualTo(841.88983f)
    }

    @Test fun `test how paddings affects inner box model properties`() {
        val paddingsSize = 10f
        val a4BoxModel: BoxModel = PageFormat.PAGE_BASE_A4.copy(
            paddings = Paddings.buildSameSizePaddings(PointSize(paddingsSize))
        )

        val expectedA4BoxSizeWidthInPoints = 595.2756f

        assertThat(a4BoxModel.width.points)
                .isEqualTo(expectedA4BoxSizeWidthInPoints)
        assertThat(a4BoxModel.effectiveWidth.points)
                .isEqualTo(expectedA4BoxSizeWidthInPoints - PageFormat.PAGE_BASE_A4.margins.horizontalMargin.points -  paddingsSize * 2 )
        assertThat(a4BoxModel.innerRectangle.height.points).isEqualTo(a4BoxModel.effectiveHeight.points)
        assertThat(a4BoxModel.innerRectangle.width.points).isEqualTo(a4BoxModel.effectiveWidth.points)
    }

}
