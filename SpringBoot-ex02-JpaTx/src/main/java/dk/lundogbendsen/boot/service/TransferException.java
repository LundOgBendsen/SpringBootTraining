package dk.lundogbendsen.boot.service;

public class TransferException extends RuntimeException {

	public TransferException() {
		super();
	}

	public TransferException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransferException(String message) {
		super(message);
	}

	public TransferException(Throwable cause) {
		super(cause);
	}
	
	
}
