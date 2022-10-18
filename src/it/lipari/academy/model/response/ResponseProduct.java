package it.lipari.academy.model.response;



public class ResponseProduct<R> {
	private boolean isOkStatus;
	//private final List<String> errors;
	private R body;
	public boolean isOkStatus() {
		return isOkStatus;
	}
	public void setOkStatus(boolean isOkStatus) {
		this.isOkStatus = isOkStatus;
	}
	/*public List<String> getErrors() {
		return errors;
	}*/
	public R getBody() {
		return body;
	}
	public void setBody(R body) {
		this.body = body;
	}
	
	
}
