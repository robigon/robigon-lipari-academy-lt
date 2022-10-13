package it.lipari.academy.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe modello per la standardizzazione di tutte le risposte
 * dei controller
 *
 */

public class BaseResponse<T> {

	private boolean isOkStatus;
	private final List<String> errors;
	private T body;
	
	public BaseResponse() {
		this.errors = new ArrayList<>();
	}


	public boolean isOkStatus() {
		return isOkStatus;
	}


	public void setOkStatus(boolean isOkStatus) {
		this.isOkStatus = isOkStatus;
	}


	public List<String> getErrors() {
		return errors;
	}
	
	public void addError(String error) {
		this.errors.add(error);
	}
	
	public void addErrors(List<String> errors) {
		this.errors.addAll(errors);
	}


	public T getBody() {
		return body;
	}


	public void setBody(T body) {
		this.body = body;
	}
	
}
