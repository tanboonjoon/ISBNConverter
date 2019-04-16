package main;
import main.ISBNConverter;
import java.util.Scanner;
public class Console {
	public static void main(String [] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Product ID : ");
		String input = scn.nextLine();
		Pair results = ISBNConverter.convertToISBN(input);
		
		if (results.getSuccesCode() == ISBNConverter.SUCCESS_CODE) {
			System.out.println("ISBN-10 : " + results.getMessage());
		}
		
		if (results.getSuccesCode() == ISBNConverter.FAILURE_CODE) {
			System.out.println("ERROR : " + results.getMessage());
		}
		
	}
}
