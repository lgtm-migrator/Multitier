package ar.nadezhda.multitier.frontend;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import ar.nadezhda.multitier.backend.config.BackendTestConfig;
import ar.nadezhda.multitier.frontend.config.FrontendTestConfig;
import ar.nadezhda.multitier.frontend.support.BreakableComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({
	BackendTestConfig.class,
	FrontendTestConfig.class
})
public final class MainTest {

	@BeforeEach
	public void beforeEach() {
		BreakableComponent.reset();
	}

	@Test
	public void canInstantiateFrontend() {
		final Main frontend = new Main();
		assertThat(frontend, is(notNullValue()));
	}

	@Test
	public void canDeployApplicationContext() {
		Main.main();
	}

	@Test
	public void canCatchUnavailableInjections() {
		BreakableComponent.lockedRun(() -> {
			BreakableComponent.requestUnavailableInjection = true;
			Main.main();
		});
	}

	@Test
	public void canCatchUnknownErrors() {
		BreakableComponent.lockedRun(() -> {
			BreakableComponent.raiseUnknownError = true;
			Main.main();
		});
	}
}
