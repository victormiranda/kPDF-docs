package es.valhallalabs.kpdf

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class KPdfTest {
	@Test fun `dummy test checking unit test integration with gradle`() {
		assertThat(KPdfTest::class).describedAs("dummy test that should be always green").isNotNull()
	}
}
