package ar.nadezhda.multitier.backend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import ar.nadezhda.multitier.backend.config.BackendTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(BackendTestConfig.class)
public final class BackendTest {

	@Test
	public void aTest() {
		assertTrue(true);
	}
}
