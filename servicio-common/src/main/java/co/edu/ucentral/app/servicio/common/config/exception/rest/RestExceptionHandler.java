package co.edu.ucentral.app.servicio.common.config.exception.rest;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Se encarga de manejar todas las excepciones arrojadas por el sistema
 * 
 * @author Jonatan Quiroz C.
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger log;

	public RestExceptionHandler() {
		super();
		log = LogManager.getLogger(RestExceptionHandler.class);
		log.info("---------------RestExceptionHandler creado--------------");
	}

	/**
	 * Controla todas las excepciones generales del sistema
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ UccCursosAppException.class })
	protected ResponseEntity<Object> handleBaseApp(UccCursosAppException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex.getErrors(), new Date());
		log.warn("Error general de app en {}: {}", request.getDescription(true), ex.getMessage());
		return new ResponseEntity<>(apiError, headers, apiError.getStatus());
	}

	/**
	 * Controla todas las excepciones de estado del sistema
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ IllegalStateException.class })
	protected ResponseEntity<Object> handleIllegalState(IllegalStateException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), new Date());
		log.warn("Error general de app en {}: {}", request.getDescription(true), ex.getMessage());
		return new ResponseEntity<>(apiError, headers, apiError.getStatus());
	}

	/**
	 * Controla la exception cuando no existe una entidad consultada
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ EntityNotFoundException.class })
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Recurso no encontrado", new Date());
		log.debug("Entidad no encontrada", ex);
		return new ResponseEntity<>(apiError, headers, apiError.getStatus());
	}

	/**
	 * Controla la exception cuando no existe una entidad consultada
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
			WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		ApiError apiError = new ApiError(HttpStatus.CONFLICT,
				"Para proteger la integridad de la base de datos no se permitir� realizar esta acci�n, puede haber informaci�n asociada o en conflicto",
				new Date());
		log.debug("Integridad de base de datos amenazada", ex);
		return new ResponseEntity<>(apiError, headers, apiError.getStatus());
	}

	/**
	 * Controla la excepcion generada cuando hay un error de autorizacion
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	protected ResponseEntity<Void> handleAccessDenied(AccessDeniedException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		log.warn("Acceso de denago: {}", request.getDescription(true));

		return new ResponseEntity<>(headers, HttpStatus.FORBIDDEN);
	}

	/**
	 * Controla todas las excepciones inesperadas que arroje el sistema
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
				"Ha ocurrido un error inesperado, porfavor contacte con el administrador del sistema", new Date());
		log.error("Error inesperado", ex);
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
