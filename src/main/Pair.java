package main;

public class Pair {
	private int sucessCode;
	private String message;
	
	Pair(int successCode, String message) {
		this.sucessCode = successCode;
		this.message = message;
	}
	
	public int getSuccesCode() { return this.sucessCode; }
	public String getMessage() { return this.message; }

}
