package ar.nadezhda.multitier.frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import ar.nadezhda.multitier.backend.config.BackendTestConfig;
import ar.nadezhda.multitier.frontend.config.FrontendTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({
	BackendTestConfig.class,
	FrontendTestConfig.class
})
public final class FrontendTest {

	@Test
	public void aTest() {
		Main.main();
		assertTrue(true);
	}
}
