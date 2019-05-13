package com.jwtme.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

	// erro geral não tratado
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class })
	public ResponseEntity<Object> serverException(RuntimeException ex, WebRequest request) {

		return handleExceptionInternal(ex,
				DetalheErro.builder().addDetalhe("Ocorreu um erro.").addErro(ex.getMessage())
						.addStatus(HttpStatus.INTERNAL_SERVER_ERROR).addHttpMethod(getHttpMethod(request))
						.addPath(getPath(request)).build(),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	// erro de constraint do banco
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolada(org.hibernate.exception.ConstraintViolationException ex,
			WebRequest request) {
		return handleExceptionInternal(ex,
				DetalheErro.builder().addDetalhe("Constraint violada: '" + ex.getConstraintName() + "'")
						.addErro(ex.getMessage()).addStatus(HttpStatus.CONFLICT).addHttpMethod(getHttpMethod(request))
						.addPath(getPath(request)).build(),
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	//Erro tratados não expecíficos
	@ExceptionHandler(GeralException.class)
	public ResponseEntity<Object> entidadeNaoExiste(GeralException ex, WebRequest request) {

		return handleExceptionInternal(ex,
				DetalheErro.builder().addDetalhe("Uma exceção foi lançada ao realizar a operação.")
						.addErro(ex.getMessage())
						.addStatus(ex.getStatus()!=null ? ex.getStatus() : HttpStatus.NOT_FOUND)
						.addHttpMethod(getHttpMethod(request))
						.addPath(getPath(request)).build(),
				new HttpHeaders(), ex.getStatus()!=null ? ex.getStatus() : HttpStatus.NOT_FOUND, request);
	}
	
	
	
	private String getHttpMethod(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getMethod();
	}

	private String getPath(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getRequestURI();
	}

}