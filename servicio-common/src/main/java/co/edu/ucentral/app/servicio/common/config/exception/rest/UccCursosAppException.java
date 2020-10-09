package co.edu.ucentral.app.servicio.common.config.exception.rest;

import java.util.Arrays;
import java.util.List;

/**
 * Excepcion de proposito general para la app
 * 
 * @author Jonatan Quiroz C.
 *
 */
public class UccCursosAppException extends RuntimeException {

	private static final long serialVersionUID = -7330775356821823140L;

	private final List<String> errors;

	public UccCursosAppException() {
		super();
		this.errors = null;

	}

	public UccCursosAppException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errors = null;
	}

	public UccCursosAppException(String message) {
		super(message);
		this.errors = null;
	}

	public UccCursosAppException(String message, String error) {
		super(message);
		this.errors = Arrays.asList(error);
	}

	public UccCursosAppException(String message, List<String> errores) {
		super(message);
		this.errors = errores;
	}

	public List<String> getErrors() {
		return errors;
	}
}
