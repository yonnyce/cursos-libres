package co.edu.ucentral.app.servicio.common.config.exception.rest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Representacion de errores en la api de la aplicacion
 * 
* @author Jonatan Quiroz C.
 *
 */
public class ApiError {

	private Date timeStamp;
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message, List<String> errors,
			Date timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
		this.timeStamp = timestamp;
	}

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public ApiError() {
		super();
	}

	public ApiError(HttpStatus status, String message, String error,
			Date timestamp) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
		this.timeStamp = timestamp;
	}

	public ApiError(HttpStatus status, String message, Date timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
