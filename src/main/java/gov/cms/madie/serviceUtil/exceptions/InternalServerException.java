package gov.cms.madie.serviceutil.exceptions;

public class InternalServerException extends RuntimeException {
	private static final long serialVersionUID = -8487952714331948002L;

	  public InternalServerException(String message) {
	    super(message);
	  }
}
