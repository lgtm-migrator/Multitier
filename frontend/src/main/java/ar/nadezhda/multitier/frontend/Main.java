package ar.nadezhda.multitier.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static final String [] packages = {
		"ar.nadezhda.multitier.backend",
		"ar.nadezhda.multitier.frontend"
	};

	public static void main(final String ... arguments) {
		try (final var context = new AnnotationConfigApplicationContext(packages)) {
			log.info("Context loaded.");
		}
		catch (final NoSuchBeanDefinitionException exception) {
			exception.printStackTrace();
		}
		catch (final Exception exception) {
			log.error("Unknown exception.");
			exception.printStackTrace();
		}
	}
}
