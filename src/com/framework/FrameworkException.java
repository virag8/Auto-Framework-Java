package com.framework;

public class FrameworkException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1970962455161484229L;

	public FrameworkException() {
		super();
		MyLogger.write(LogLevel.ERROR, "");
	}

	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
		MyLogger.write(LogLevel.ERROR, message);
	}

	public FrameworkException(String message) {
		super(message);
		MyLogger.write(LogLevel.ERROR, message);
	}

	public FrameworkException(Throwable cause) {
		super(cause);

		MyLogger.write(LogLevel.ERROR, cause.toString());
	}

}
