package ar.nadezhda.multitier.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static final String [] packages = {
		"ar.nadezhda.multitier.backend",
		"ar.nadezhda.multitier.frontend"
	};

	public static void main(final String ... arguments) {
		try {
			try (final var context = new AnnotationConfigApplicationContext(packages)) {
				log.info("Context loaded.");
			}
			catch (final BeanCreationException exception) {
				log.error("Rethrowing exception of type: '{}'.", exception.getClass());
				throw exception.getRootCause();
			}
		}
		catch (final NoSuchBeanDefinitionException exception) {
			log.error("Unavailable injection of type: '{}'.", exception.getBeanType());
			log.error("The injection name was: '{}'.", exception.getBeanName());
			log.error("The context contains {} injections that match the request.", exception.getNumberOfBeansFound());
			log.error("The error message is: '{}'.", exception.getMessage());
		}
		catch (final Throwable exception) {
			log.error("Unknown exception of type: '{}'.", exception.getClass().getName());
			log.error("The error message is: '{}'.", exception.getMessage());
			log.error("The stacktrace is:");
			exception.printStackTrace();
			log.error("End of stacktrace.");
		}
	}
}
