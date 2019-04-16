package main;
import main.Pair;
import java.util.Scanner;

public class ISBNConverter {
	private static final int PRODUCT_ID_SIZE = 12;
	private static final int ISBN_ID_SIZE = 10;
	private static final int PREFIX_LENGTH = 3;
	public static final int SUCCESS_CODE = 200;
	public static final int FAILURE_CODE = 500;
	
	public static final String INVALID_PRODUCT_ID = "Please enter a valid product id, Example : 978155192370";
	public static Pair convertToISBN(String productID) {
		if (!isValidProductId(productID)) return new Pair(FAILURE_CODE, INVALID_PRODUCT_ID);
		
		String ISBNWithoutError = removePrefix(productID);
		String errorCode = getErrorCode(ISBNWithoutError);
		return new Pair(SUCCESS_CODE, ISBNWithoutError + errorCode);
	}
	
	private static boolean isValidProductId(String productID) {
		if (productID.length() != 12) return false;
		try {
			Long.parseLong(productID);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static String removePrefix(String productID) {
		return productID.substring(PREFIX_LENGTH);
	}
	
	private static String getErrorCode(String ISBNWithoutError) {
		int multiplier = 10;
		int weightedSum = 0;
		for (char c : ISBNWithoutError.toCharArray()) {
			weightedSum += (multiplier * Character.getNumericValue(c));
			multiplier--;
		}
		
		if (weightedSum % 11 == 0) return "0";
		
		int leftOver = 11 - (weightedSum % 11);
		if (leftOver >= 10) return "x";
		return String.valueOf(leftOver);		
	}
	

}
