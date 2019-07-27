package ar.nadezhda.multitier.frontend.support;

import java.util.Stack;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public final class BreakableComponent {

	private static final Stack<ApplicationContext> CONTEXTS = new Stack<>();
	private static final Object LOCK = new Object();

	public static boolean requestUnavailableInjection = false;
	public static boolean raiseUnknownError = false;

	public BreakableComponent(final ApplicationContext context) throws Exception {
		lockedRun(() -> {
			CONTEXTS.add(context);
			if (1 < CONTEXTS.size()) {
				if (requestUnavailableInjection) {
					CONTEXTS.peek().getBean(UnavailableInjection.class);
				}
				if (raiseUnknownError) {
					throw new RuntimeException("Unknown runtime error.");
				}
			}
		});
	}

	public static void lockedRun(final Runnable runnable) {
		synchronized (LOCK) {
			runnable.run();
		}
	}

	public static void reset() {
		requestUnavailableInjection = false;
		raiseUnknownError = false;
	}
}
