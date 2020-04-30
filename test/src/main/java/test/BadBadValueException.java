package test;

public class BadBadValueException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public BadBadValueException(String message) {
			super(message);
		}
		
		public BadBadValueException() {
			super("Please check the time number it can't be negative");
		}
}
