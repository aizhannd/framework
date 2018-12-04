package framework.common.exception;

public class CommonTestRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 8441781398400036146L;

	public CommonTestRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommonTestRuntimeException(String arg0) {
		super(arg0);
	}

	public CommonTestRuntimeException(Throwable arg0) {
		super(arg0);
	}
}
