package it.uniroma2.art.semanticturkey.plugin.configuration;

public class UnloadablePluginConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1167867944150031146L;

	public UnloadablePluginConfigurationException() {
		super();
	}

	public UnloadablePluginConfigurationException(String message,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnloadablePluginConfigurationException(String message,
			Throwable cause) {
		super(message, cause);
	}

	public UnloadablePluginConfigurationException(String message) {
		super(message);
	}

	public UnloadablePluginConfigurationException(Throwable cause) {
		super(cause);
	}

	
}
