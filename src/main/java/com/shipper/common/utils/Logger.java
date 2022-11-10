package com.shipper.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import org.slf4j.LoggerFactory;

public class Logger implements Serializable {

	private static final long serialVersionUID = -7550301362617242746L;

	private transient org.slf4j.Logger log;

	private static final ThreadLocal<HashMap<String, String>> CONTEXT = new ThreadLocal<>();

	private Logger() {
		super();
	}

	private Logger(org.slf4j.Logger log) {
		super();
		this.log = log;
	}

	public static Logger getLogger(Class<?> className) {
		if (Boolean.TRUE.equals(Utils.checkCollectionIsEmpty(CONTEXT.get()))) {
			CONTEXT.set(new HashMap<>());
		}
		return new Logger(LoggerFactory.getLogger(className));
	}

	/**
	 * Log a message at the INFO level.
	 *
	 * @param msg the message string to be logged
	 */
	public void info(String msg) {
		log.info(msg);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * argument.
	 */
	public void info(String format, Object arg) {
		log.info(format, arg);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * arguments.
	 * <p/>
	 * <p>
	 * This form avoids superfluous string concatenation when the logger is disabled
	 * for the INFO level. However, this variant incurs the hidden (and relatively
	 * small) cost of creating an <code>Object[]</code> before invoking the method,
	 * even if this logger is disabled for INFO. The variants taking
	 * {@link #info(String, Object) one} and {@link #info(String, Object, Object)
	 * two} arguments exist solely in order to avoid this hidden cost.
	 * </p>
	 *
	 * @param format    the format string
	 * @param arguments a list of 3 or more arguments
	 */
	public void info(String format, Object... arguments) {
		log.info(format, arguments);
	}

	public void info(String msg, Throwable t) {
		log.info(msg, t);
	}

	public void error(String msg) {
		log.error(msg);
	}

	public void error(String format, Object arg) {
		log.error(format, arg);
	}

	public void error(String format, Object... arguments) {
		log.error(format, arguments);
	}

	public void error(String msg, Throwable t) {
		log.error(msg, t);
	}

	public void debug(String msg) {
		log.debug(msg);
	}

	public void debug(String format, Object arg) {
		log.debug(format, arg);
	}

	public void debug(String format, Object... arguments) {
		log.debug(format, arguments);
	}

	public void debug(String msg, Throwable t) {
		log.debug(msg, t);
	}

	public void setValue(String key, String value) {
		CONTEXT.get().put(key, value);
	}

	public String getValue(String key) {
		return CONTEXT.get().getOrDefault(key, "");
	}

	public void clearContext() {
		CONTEXT.remove();
	}

}
