package library;

public class VerifyHostnameResult {
	public enum ResultType {
		MalformedUri, InvalidCertificate, HostnameNotFound, NotFound, Timeout, Unknown, Null, OK, ServerError, Redirect
	}

	private String title;
	private String message;
	private ResultType type;
	private int responseCode;

	public ResultType getType() {
		return type;
	}

	public void setType(ResultType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
}
