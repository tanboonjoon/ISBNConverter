package test;

import static org.junit.Assert.*;

import org.junit.Test;
import main.ISBNConverter;
import main.Pair;
public class ISBNConverterTest {

	@Test
	public void testSuccess() {
		String [] ids = {"978155192370", "978140007917", "978037541457" , "978037428158"};
		String [] ISBNs = {"155192370x", "1400079179", "0375414576", "0374281580"};
		
		for (int i = 0; i < ids.length; i++) {
			Pair results = ISBNConverter.convertToISBN(ids[i]);
			assertEquals(results.getSuccesCode(), ISBNConverter.SUCCESS_CODE);
			assertEquals(results.getMessage(), ISBNs[i]);
		}
	}
	@Test
	public void testFailure() {
		String [] ids = {"97718155192370", "940007917", "9@80375svn1457" , "9780 374 28158"};
		
		for (int i = 0; i < ids.length; i++) {
			Pair results = ISBNConverter.convertToISBN(ids[i]);
			assertEquals(results.getSuccesCode(), ISBNConverter.FAILURE_CODE);
			assertEquals(results.getMessage(), ISBNConverter.INVALID_PRODUCT_ID);
		}
	}

}
