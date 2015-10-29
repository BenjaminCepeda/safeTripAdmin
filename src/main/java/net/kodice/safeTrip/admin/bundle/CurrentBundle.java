package net.kodice.safeTrip.admin.bundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentBundle {
	private static final String BUNDLE_NAME = "net.kodice.safeTrip.admin.bundle.messages"; //$NON-NLS-1$
	private static final Logger LOGGER = Logger.getLogger(CurrentBundle.class.getName());


	public static String getBundle(final Locale locale, final String key, final Object... params) {

		// LOGGER.trace(locale);
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale, getCurrentClassLoader(params));

		String message = getString(bundle, key);

		if (message == null) {
			message = key;
		} else {
			if (params != null && params.length > 0) {
				MessageFormat mf = new MessageFormat(message, locale);
				message = mf.format(params, new StringBuffer(), null).toString();
			}

		}

		return message;
	}

	/**
	 * Se encarga de recuperar una instancia del classloader del thread actual.
	 *
	 * @param defaultObject
	 *            objeto usado para recuperar el class loader
	 * @return Instancia del class loader
	 */
	protected static ClassLoader getCurrentClassLoader(final Object defaultObject) {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}

		return loader;
	}

	/**
	 * Se encarga de recuperar un recuros desde el repositorio de recursos
	 * pasado como parametro.
	 *
	 * @param bundle
	 *            repositorio de recursos
	 * @param key
	 *            key del recurso que se quiere recuperar
	 * @return el recurso recuperado, si no existe retorna null
	 */
	private static String getString(final ResourceBundle bundle, final String key) {
		String message = null;
		try {
			message = bundle.getString(key);
		} catch (MissingResourceException e) {
			LOGGER.log(Level.INFO, "No existe el recurso {0} en el archivo de recursos", key);
			LOGGER.info(e.toString());
		}
		return message;
	}

}
